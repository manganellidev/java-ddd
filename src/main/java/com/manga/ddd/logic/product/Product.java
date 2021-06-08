package com.manga.ddd.logic.product;

import com.manga.ddd.logic.common.Entity;
import java.util.UUID;

public class Product extends Entity {
    private Code code;
    private TypeCode typeCode;
    private Period period;

    public Product(Code code, TypeCode typeCode, Period period) {
        this.setId(UUID.randomUUID());
        this.setCode(code);
        this.setTypeCode(typeCode);
        this.setPeriod(period);
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public TypeCode getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(TypeCode typeCode) {
        this.typeCode = typeCode;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}
