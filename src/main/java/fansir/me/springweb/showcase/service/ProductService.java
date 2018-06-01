package fansir.me.springweb.showcase.service;

import fansir.me.springweb.common.dto.widget.DataTablesResponseDto;
import fansir.me.springweb.showcase.domain.Product;
import fansir.me.springweb.showcase.dto.upstream.ProductSearchDto;


/**
* Class Name: ProductService
* Description: TODO
*
*/
public interface ProductService {

    
    /**
    * Description: find a product
    *
    * @param id
    * @return
    */
    Product findProductById(String id);

    
    /**
    * Description: save a product
    *
    * @param product
    * @return
    */
    Product saveProduct(Product product);

    
    /**
    * Description: delete a product
    *
    * @param id
    */
    void deleteProduct(String id);

    
    /**
    * Description: search for products
    *
    * @param searchDto
    * @return
    */
    DataTablesResponseDto<Product> searchProduct(final ProductSearchDto searchDto);

}
