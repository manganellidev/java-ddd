package com.manga.book.store.logic;

import com.manga.book.store.util.Contracts;

public class FullName {
    private String firstName;
    private String lastName;

    private FullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static FullName create(String firstName, String lastName) {
        if (isNullOrEmptyOrTooLarge(firstName))
            throw new RuntimeException("firstName informed is not valid.");
        if (isNullOrEmptyOrTooLarge(lastName))
            throw new RuntimeException("lastName informed is not valid.");

        return new FullName(firstName, lastName);
    }

    private static boolean isNullOrEmptyOrTooLarge(String value) {
        return Contracts.EnsureNotNullOrEmpty(value) || Contracts.EnsureMaxLength(30, value);
    }

    public boolean sameAs(FullName anotherFullName) {
        return this.firstName == anotherFullName.firstName
            && this.lastName == anotherFullName.lastName;
    }
}
