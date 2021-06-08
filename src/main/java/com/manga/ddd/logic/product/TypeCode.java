package com.manga.ddd.logic.product;

import java.util.Arrays;

final class TypeCode {
    private String value;

    private TypeCode(String value) {
        this.value = value;
    }

    public static TypeCode create(String value) {
        if (!isValid(value))
            throw new RuntimeException("typeCode informed is not valid.");

        return new TypeCode(value);
    }

    private static boolean isValid(String value) {
        return Arrays.stream(ProductTypes.values()).anyMatch((t) -> t.name().equals(value));
    }

    public boolean sameAs(TypeCode anotherTypeCode) {
        return value.equals(anotherTypeCode.value);
    }
}
