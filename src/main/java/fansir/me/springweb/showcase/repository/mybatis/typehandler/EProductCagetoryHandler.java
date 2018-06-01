package fansir.me.springweb.showcase.repository.mybatis.typehandler;

import org.apache.ibatis.type.MappedTypes;

import fansir.me.springweb.showcase.enumeration.EProductCagetory;

@MappedTypes(EProductCagetory.class)
public class EProductCagetoryHandler extends EnumTypeHandler<EProductCagetory> {

    public EProductCagetoryHandler(Class<EProductCagetory> type) {
        super(type);
    }

}
