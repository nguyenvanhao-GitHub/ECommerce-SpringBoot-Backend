package com.nguyenvanhao.ecommerce_backend.exception;

public class OrderException extends RuntimeException{ 
	public OrderException() {
		
	}
	public OrderException(String message) {
		super(message);
	}

}
