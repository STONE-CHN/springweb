package fansir.me.springweb.showcase.repository;

import fansir.me.springweb.showcase.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
* Class Name: ProductRepository
* Description: TODO
*
*/
public interface ProductRepository extends JpaRepository<Product, String>,
		JpaSpecificationExecutor<Product> {

}