package com.jvmbrg.spring_professional;


import java.util.Locale;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jvmbrg.spring_professional.entities.Order;
import com.jvmbrg.spring_professional.services.TotalService;
@SpringBootApplication
public class SpringProfessionalApplication implements CommandLineRunner {

	TotalService totalService;
	public SpringProfessionalApplication(TotalService totalService) {
		this.totalService = totalService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringProfessionalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int codigo = sc.nextInt();
		double valor = sc.nextDouble();
		double desconto = sc.nextDouble();
		
		Order order = new Order(codigo, valor, desconto);
		double total = totalService.totalPaymente(order);
		System.out.printf("Pedido código %d%n",  codigo);
		System.out.printf("Valor total: R$ %.2f%n", total);
		
		sc.close();
	}

}
