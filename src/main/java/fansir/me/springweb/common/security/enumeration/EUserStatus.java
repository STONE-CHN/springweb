package fansir.me.springweb.common.security.enumeration;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fansir.me.springweb.common.enumeration.PageEnum;
import fansir.me.springweb.common.util.PageEnumSerializer;

/**
 * Class Name: EUserStatus
 *
 */
@JsonSerialize(using = PageEnumSerializer.class)
public enum EUserStatus implements PageEnum {

    NULL("", ""), ACTIVE("A", "Active"), INACTIVE("I", "Inactive"), CANCELLED("C", "Cancelled");

    private String code;

    private String text;

    EUserStatus(String code, String text) {
        this.code = code;
        this.text = text;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

}
