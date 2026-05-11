package com.nguyenvanhao.ecommerce_backend.service;

import com.nguyenvanhao.ecommerce_backend.controller.ProductNotFound;
import com.nguyenvanhao.ecommerce_backend.exception.CartItemNotFound;
import com.nguyenvanhao.ecommerce_backend.models.Cart;
import com.nguyenvanhao.ecommerce_backend.models.CartDTO;




public interface CartService {
	
	public Cart addProductToCart(CartDTO cart, String token) throws CartItemNotFound;
	public Cart getCartProduct(String token);
	public Cart removeProductFromCart(CartDTO cartDto,String token) throws ProductNotFound;
//	public Cart changeQuantity(Product product,Customer customer,Integer quantity);
	
	public Cart clearCart(String token);
	
}
