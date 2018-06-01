package fansir.me.springweb.showcase.ws;

import javax.jws.WebService;

import fansir.me.springweb.showcase.domain.Product;

/**
 * Class Name: CategoryService Description: Just a sample
 * 
 *
 */

@WebService
public interface ProductWebService {

    Product getProductById(String productId);

}
