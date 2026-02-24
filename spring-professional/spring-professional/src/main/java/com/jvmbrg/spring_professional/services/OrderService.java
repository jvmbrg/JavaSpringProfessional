package com.jvmbrg.spring_professional.services;

import org.springframework.stereotype.Service;

import com.jvmbrg.spring_professional.entities.Order;

@Service
public class OrderService {

	private ShippingService shippingService;

	public OrderService(ShippingService shippingService){
		this.shippingService = shippingService;
	}

	public double total(Order order) {
		double total = (order.getBasic() - (order.getBasic() * order.getDiscont()/100) + shippingService.shipment(order));
		return total;
	}

}
