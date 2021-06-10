package com.manga.ddd.logic.product;

import com.manga.ddd.logic.common.Entity;
import java.util.Objects;
import java.util.UUID;

@javax.persistence.Entity
public class Product extends Entity {
    private Code code;
    private TypeCode typeCode;
    private Period period;

    private Product() { }

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

    public Period getPeriod() { return period; }

    public void setPeriod(Period period) { this.period = period; }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Product product = (Product)o;
        return code.equals(product.code) &&
            typeCode.equals(product.typeCode) &&
            period.equals(product.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), code, typeCode, period);
    }

    @Override
    public String toString() {
        return "Product{" +
            "code=" + code.value() +
            ", typeCode=" + typeCode.value() +
            ", validFrom=" + period.validFrom() +
            ", validTo=" + period.validTo() +
            ", id=" + id +
            '}';
    }
}
