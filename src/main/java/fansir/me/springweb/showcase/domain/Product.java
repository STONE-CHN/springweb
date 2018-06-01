package fansir.me.springweb.showcase.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import fansir.me.springweb.showcase.domain.converter.EProductCagetoryConverter;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import fansir.me.springweb.showcase.enumeration.EProductCagetory;

/**
 * Class Name: Product
 * Description: TODO
 * 
 *
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "category")
    @Convert(converter = EProductCagetoryConverter.class)
    private EProductCagetory category;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!this.getClass().isInstance(obj)) {
            return false;
        }
        return new EqualsBuilder().append(id, ((Product) obj).getId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).toHashCode();
    }
}
