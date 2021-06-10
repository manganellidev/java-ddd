package com.manga.ddd.logic.product;

import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public final class TypeCode {
    @Column(name = "type_code")
    private String value;

    private TypeCode() { }

    private TypeCode(String value) {
        this.value = value;
    }

    public static TypeCode create(String value) {
        if (!isValid(value))
            throw new RuntimeException("typeCode informed is not valid.");

        return new TypeCode(value);
    }

    public String value() {
        return this.value;
    }

    private static boolean isValid(String value) {
        return Arrays.stream(ProductTypes.values()).anyMatch((t) -> t.name().equals(value));
    }

    public boolean sameAs(TypeCode anotherTypeCode) {
        return value.equals(anotherTypeCode.value);
    }
}
