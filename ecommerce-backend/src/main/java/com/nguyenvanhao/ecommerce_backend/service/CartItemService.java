package com.nguyenvanhao.ecommerce_backend.service;

import com.nguyenvanhao.ecommerce_backend.models.CartDTO;
import com.nguyenvanhao.ecommerce_backend.models.CartItem;

public interface CartItemService {
	
	public CartItem createItemforCart(CartDTO cartdto);
	
}
