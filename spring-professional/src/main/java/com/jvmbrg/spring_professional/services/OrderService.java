package com.jvmbrg.spring_professional.services;

import org.springframework.stereotype.Service;

import com.jvmbrg.spring_professional.entities.Order;

@Service
public class OrderService {
	
	public double total(Order order) {
		double total = order.getBasic() - (order.getBasic() * (order.getDiscont()/100));
		return total;
	}

}
