package fansir.me.springweb.showcase.ws;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import fansir.me.springweb.showcase.domain.Product;
import fansir.me.springweb.showcase.service.ProductService;

/**
 * Class Name: CategoryServiceImpl Description: Sample implementation
 * 
 *
 */

@WebService(endpointInterface = "ProductWebService")
public class ProductWebServiceImpl implements ProductWebService {
    
    @Autowired
    ProductService productService;

    public Product getProductById(String productId) {
        return productService.findProductById(productId);
    }

}
