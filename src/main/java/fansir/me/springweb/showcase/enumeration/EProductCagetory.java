package fansir.me.springweb.showcase.enumeration;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fansir.me.springweb.common.enumeration.PageEnum;
import fansir.me.springweb.common.util.PageEnumSerializer;

/**
 * Class Name: EProductCagetory
 * 
 *
 */
@JsonSerialize(using = PageEnumSerializer.class)
public enum EProductCagetory implements PageEnum {

    BIRDS("B", "Birds"), FISH("F", "Fish"), DOGS("D", "Dogs"), REPTILES("R", "Reptiles"), CATS("C", "Cats");

    private String code;

    private String text;

    EProductCagetory(String code, String text) {
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
