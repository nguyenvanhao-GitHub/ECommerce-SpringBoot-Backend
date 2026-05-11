package com.nguyenvanhao.ecommerce_backend.controller;

public class ProductNotFound extends RuntimeException{

	public ProductNotFound() {
		// TODO Auto-generated constructor stub
	}
	public ProductNotFound(String message) {
		super(message);
	}

}
