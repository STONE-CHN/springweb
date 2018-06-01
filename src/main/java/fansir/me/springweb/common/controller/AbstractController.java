package fansir.me.springweb.common.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import fansir.me.springweb.common.constant.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Class Name: BaseController
 * Description: all controller should extend this base class
 * 
 *
 */

public abstract class AbstractController {

    /**
     * Description: get all static options from a enum object for display.
     * 
     * @param enumClass
     * @return
     */

    @Autowired
    private LocalValidatorFactoryBean validator;

    protected void validate(final Object validatedObj, final Class<?>[] groups) {
        final Set<ConstraintViolation<Object>> constraintViolations = validator.validate(validatedObj, groups);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(ApplicationConstant.MANUAL_VALIDATE, constraintViolations);
        }
    }

}
