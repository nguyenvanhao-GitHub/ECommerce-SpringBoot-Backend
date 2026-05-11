package com.nguyenvanhao.ecommerce_backend.service;

import com.nguyenvanhao.ecommerce_backend.models.CustomerDTO;
import com.nguyenvanhao.ecommerce_backend.models.SellerDTO;
import com.nguyenvanhao.ecommerce_backend.models.SessionDTO;
import com.nguyenvanhao.ecommerce_backend.models.UserSession;


public interface LoginLogoutService {
	
	public UserSession loginCustomer(CustomerDTO customer);
	
	public SessionDTO logoutCustomer(SessionDTO session);
	
	public void checkTokenStatus(String token);
	
	public void deleteExpiredTokens();
	
	
	public UserSession loginSeller(SellerDTO seller);
	
	public SessionDTO logoutSeller(SessionDTO session);
	
	
}
