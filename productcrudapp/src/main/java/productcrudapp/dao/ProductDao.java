package productcrudapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productcrudapp.model.Product;

@Component
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//create product
	@Transactional
	public void createProduct(Product product) {
		
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	//get all products
	public List<Product> getProducts(){
		
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	//delete product
	@Transactional
	public void deleteProduct(int pid) {
		
		//get the product by using its id and save in p
		Product p = this.hibernateTemplate.load(Product.class, pid);
		//delete the product which we got in p
		this.hibernateTemplate.delete(p);
	}
	
	//get single product
	public Product getProduct(int pid) {
		
		return this.hibernateTemplate.get(Product.class, pid);
	}
	
	
	
}
