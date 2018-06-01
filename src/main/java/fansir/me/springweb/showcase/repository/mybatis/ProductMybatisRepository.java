package fansir.me.springweb.showcase.repository.mybatis;

import fansir.me.springweb.showcase.domain.Product;


/**
* Class Name: ProductMybatisRepository
* Description: TODO
*
*/
public interface ProductMybatisRepository {

    Product findOne(String productId);

}
