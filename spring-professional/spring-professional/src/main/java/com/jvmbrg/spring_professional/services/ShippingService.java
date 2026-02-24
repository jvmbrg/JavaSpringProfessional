package com.jvmbrg.spring_professional.services;

import org.springframework.stereotype.Service;

import com.jvmbrg.spring_professional.entities.Order;

@Service
public class ShippingService {
	
	public double shipment(Order order) {
		int frete = 0;
		
		if(order.getBasic() >= 100 && order.getBasic() <= 200) {
			frete = 12;
			return frete;
		}
		if(order.getBasic() < 100) {
			frete = 20;
			return frete;
		}

		return frete;
	}


	
	
	
}
