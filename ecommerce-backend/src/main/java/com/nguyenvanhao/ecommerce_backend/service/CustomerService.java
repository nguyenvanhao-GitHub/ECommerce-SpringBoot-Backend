package com.nguyenvanhao.ecommerce_backend.service;

import java.util.List;

import com.nguyenvanhao.ecommerce_backend.exception.CustomerException;
import com.nguyenvanhao.ecommerce_backend.exception.CustomerNotFoundException;
import com.nguyenvanhao.ecommerce_backend.models.Address;
import com.nguyenvanhao.ecommerce_backend.models.CreditCard;
import com.nguyenvanhao.ecommerce_backend.models.Customer;
import com.nguyenvanhao.ecommerce_backend.models.CustomerDTO;
import com.nguyenvanhao.ecommerce_backend.models.CustomerUpdateDTO;
import com.nguyenvanhao.ecommerce_backend.models.Order;
import com.nguyenvanhao.ecommerce_backend.models.SessionDTO;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer getLoggedInCustomerDetails(String token) throws CustomerNotFoundException;
	
	public List<Customer> getAllCustomers(String token) throws CustomerNotFoundException;
	
	public Customer updateCustomer(CustomerUpdateDTO customer, String token) throws CustomerNotFoundException;
	
	public Customer updateCustomerMobileNoOrEmailId(CustomerUpdateDTO customerUpdateDTO, String token) throws CustomerNotFoundException;
	
	public Customer updateCreditCardDetails(String token, CreditCard card) throws CustomerException;
	
	public SessionDTO updateCustomerPassword(CustomerDTO customerDTO, String token) throws CustomerNotFoundException;
	
	public SessionDTO deleteCustomer(CustomerDTO customerDTO, String token) throws CustomerNotFoundException;
	
	public Customer updateAddress(Address address, String type, String token) throws CustomerException;
	
	public Customer deleteAddress(String type, String token) throws CustomerException, CustomerNotFoundException;

	public List<Order> getCustomerOrders(String token) throws CustomerException; 

}
