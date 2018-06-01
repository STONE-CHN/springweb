package fansir.me.springweb.showcase.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fansir.me.springweb.showcase.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;

import fansir.me.springweb.common.validation.BaseValidator;
import fansir.me.springweb.showcase.service.ProductService;


/**
* Class Name: ProductExistenceValidator
* Description: Customized validator.
*
*/
public class ProductExistenceValidator extends BaseValidator implements
        ConstraintValidator<ProductExistenceCheck, String> {

    @Autowired
    private ProductService productService;

    @Override
    public void initialize(ProductExistenceCheck check) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Product product = productService.findProductById(value);
        return product == null;
    }

}
