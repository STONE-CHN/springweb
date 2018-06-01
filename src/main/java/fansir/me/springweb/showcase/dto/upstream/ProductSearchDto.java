package fansir.me.springweb.showcase.dto.upstream;

import java.io.Serializable;

import fansir.me.springweb.common.dto.widget.DataTablesRequestDto;


/**
* Class Name: ProductSearchDto
* Description: TODO
*
*/
public class ProductSearchDto extends DataTablesRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关键字
     */
    private String keyword;

    private String category;

    /**
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword
     *            the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category
     *            the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

}
