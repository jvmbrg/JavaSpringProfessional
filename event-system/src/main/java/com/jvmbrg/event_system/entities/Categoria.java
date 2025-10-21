package com.jvmbrg.event_system.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private Set<Atividade> atividades = new HashSet<>();

    public Categoria(){}
    public Categoria(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Atividade> getAtividades() {
        return atividades;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Categoria categoria)) return false;

        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
