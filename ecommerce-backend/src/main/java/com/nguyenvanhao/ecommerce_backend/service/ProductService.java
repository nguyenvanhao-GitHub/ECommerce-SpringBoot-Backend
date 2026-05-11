package com.nguyenvanhao.ecommerce_backend.service;

import java.util.List;

import com.nguyenvanhao.ecommerce_backend.models.CategoryEnum;
import com.nguyenvanhao.ecommerce_backend.models.Product;
import com.nguyenvanhao.ecommerce_backend.models.ProductDTO;
import com.nguyenvanhao.ecommerce_backend.models.ProductStatus;

public interface ProductService {

	public Product addProductToCatalog(String token, Product product);

	public Product getProductFromCatalogById(Integer id);

	public String deleteProductFromCatalog(Integer id);

	public Product updateProductIncatalog(Product product);
	
	public List<Product> getAllProductsIncatalog();
	
	public List<ProductDTO> getAllProductsOfSeller(Integer id);
	
	public List<ProductDTO> getProductsOfCategory(CategoryEnum catenum);
	
	public List<ProductDTO> getProductsOfStatus(ProductStatus status);
	
	
	
	public Product updateProductQuantityWithId(Integer id,ProductDTO prodDTO);

}
