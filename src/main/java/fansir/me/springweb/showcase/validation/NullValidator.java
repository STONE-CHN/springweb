package fansir.me.springweb.showcase.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fansir.me.springweb.common.validation.BaseValidator;


/**
* Class Name: NullValidator
* Description: TODO
*
*/
public class NullValidator extends BaseValidator implements ConstraintValidator<NullCheck, Object> {

    @Override
    public void initialize(NullCheck check) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return true;
    }

}
