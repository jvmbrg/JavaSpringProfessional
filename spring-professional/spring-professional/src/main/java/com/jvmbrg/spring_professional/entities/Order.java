package com.jvmbrg.spring_professional.entities;

import org.springframework.stereotype.Component;

@Component
public class Order {
	private int code;
	private double basic;
	private double discont;
	
	public Order() {}
	public Order(int code, double basic, double discont) {
		this.code = code;
		this.basic = basic;
		this.discont = discont;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public double getDiscont() {
		return discont;
	}
	public void setDiscont(double discont) {
		this.discont = discont;
	}
	
	

}
