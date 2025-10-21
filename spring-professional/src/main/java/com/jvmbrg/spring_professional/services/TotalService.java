package com.jvmbrg.spring_professional.services;

import org.springframework.stereotype.Service;

import com.jvmbrg.spring_professional.entities.Order;

@Service
public class TotalService {
	
	OrderService orderService;
	ShippingService shippingService;
	public TotalService(OrderService orderService, ShippingService shippingService) {
		this.orderService = orderService;
		this.shippingService = shippingService;
	}
	
	public double totalPaymente(Order order) {
		double total = orderService.total(order);
		double shipment = shippingService.shipment(order);
		double finish = total + shipment;
		return finish;
		
	}
	
	
}
