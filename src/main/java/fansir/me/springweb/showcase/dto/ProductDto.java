package fansir.me.springweb.showcase.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;

import fansir.me.springweb.showcase.validation.ProductExistenceCheck;
import org.hibernate.validator.constraints.NotBlank;

import fansir.me.springweb.showcase.enumeration.EProductCagetory;
import fansir.me.springweb.showcase.validation.NullCheck;

/**
 * Class Name: ProductDto Description: TODO
 * 
 *
 */
public class ProductDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "{error.required.field}")
    @ProductExistenceCheck(groups = { CreateProduct.class })
    private String id;

    @NullCheck
    private EProductCagetory category;

    @NotBlank(message = "{error.required.field}")
    @Size(max = 100, message = "{error.maximum.length.exceeded}")
    private String name;

    @Size(max = 200, message = "{error.maximum.length.exceeded}")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EProductCagetory getCategory() {
        return category;
    }

    public void setCategory(EProductCagetory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Validation group for creating a product.
     */
    public interface CreateProduct {

    }

}
