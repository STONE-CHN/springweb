package fansir.me.springweb.showcase.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import fansir.me.springweb.common.util.EnumHelper;
import fansir.me.springweb.showcase.enumeration.EProductCagetory;


/**
* Class Name: EProductCagetoryConverter
* Description: TODO
*
*/
@Converter
public class EProductCagetoryConverter implements AttributeConverter<EProductCagetory, String> {

    @Override
    public String convertToDatabaseColumn(EProductCagetory attribute) {
        return attribute.getCode();
    }

    @Override
    public EProductCagetory convertToEntityAttribute(String dbData) {
        return EnumHelper.translate(EProductCagetory.class, dbData);
    }

}
