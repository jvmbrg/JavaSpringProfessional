package com.jvmbrg.spring_professional;


import java.util.Locale;
import java.util.Scanner;

import com.jvmbrg.spring_professional.services.OrderService;
import com.jvmbrg.spring_professional.services.ShippingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jvmbrg.spring_professional.entities.Order;

@SpringBootApplication
public class SpringProfessionalApplication implements CommandLineRunner {

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

		ShippingService shippingService = new ShippingService();
		OrderService orderService = new OrderService(shippingService);

		Order order = new Order(codigo, valor, desconto);
		Double total = orderService.total(order);

		System.out.printf("Pedido código %d%n",  codigo);
		System.out.printf("Valor total: R$ %.2f%n", total);
		
		sc.close();
	}

}
