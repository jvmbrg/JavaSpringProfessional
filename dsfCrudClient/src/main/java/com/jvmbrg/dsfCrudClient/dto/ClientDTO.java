package com.jvmbrg.dsfCrudClient.dto;

import com.jvmbrg.dsfCrudClient.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClientDTO {
    private Long id;

    @NotBlank(message = "Não pode ser vazio")
    private String name;

    private String cpf;
    private Double income;

    @PastOrPresent(message = "Não pode ser data futura")
    private LocalDate birthDate;

    private Integer children;

    public ClientDTO(){}
    public ClientDTO(LocalDate birthDate, Integer children, String cpf, Long id, Double income, String name) {
        this.birthDate = birthDate;
        this.children = children;
        this.cpf = cpf;
        this.id = id;
        this.income = income;
        this.name = name;
    }

    public ClientDTO(Client entity){
        birthDate = entity.getBirthDate();
        children = entity.getChildren();
        id = entity.getId();
        cpf = entity.getCpf();
        income = entity.getIncome();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
