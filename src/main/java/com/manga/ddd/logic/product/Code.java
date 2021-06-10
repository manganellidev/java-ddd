package com.manga.ddd.logic.product;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public final class Code {
    @Column(name = "code", length = 30)
    private String value;
    @Column(name = "code_desc", length = 200)
    private String description;

    private Code() {
    }

    private Code(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String value() {
        return this.value;
    }

    public String description() {
        return this.description;
    }

    public static Code create(String value) {
        if (!isAlphanumericWithoutSpace(value))
            throw new RuntimeException("Code informed is not valid.");
        if (!hasValueValidLength(value))
            throw new RuntimeException("Code informed is not valid.");
        return new Code(value, "");
    }

    public static Code create(String value, String description) {
        if (!isAlphanumeric(description))
            throw new RuntimeException("Description informed is not valid.");
        if (!hasDescValidLength(description))
            throw new RuntimeException("Description informed is not valid.");

        Code c = create(value);
        c.description = description;
        return c;
    }

    private static boolean isAlphanumericWithoutSpace(String value) {
        return value.matches("^[a-zA-Z0-9]*$");
    }

    private static boolean isAlphanumeric(String description) {
        return description.matches("^[A-Za-z0-9\\s]+[A-Za-z0-9\\s]+$(\\.0-9+)?");
    }

    private static boolean hasValueValidLength(String value) {
        return value.length() >= 3 && value.length() <= 30 ? true : false;
    }

    private static boolean hasDescValidLength(String description) {
        return description.length() <= 200 ? true : false;
    }

    public boolean sameAs(Code anotherCode) {
        return value.equals(anotherCode.value) &&
            description.equals(anotherCode.description);
    }
}
