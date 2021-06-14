package com.manga.book.store.logic;

import com.manga.book.store.common.BaseEntity;
import com.manga.book.store.util.Contracts;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Person extends BaseEntity {
    private FullName fullName;
    private LocalDate dateOfBirth;

    public Person(FullName fullName, LocalDate dateOfBirth) {
        if (isNullOrAfterToday(dateOfBirth))
            throw new RuntimeException("dateOfBirth informed is not valid.");

        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.setId(UUID.randomUUID());
    }

    private boolean isNullOrAfterToday(LocalDate date) {
        return Contracts.EnsureNotNullOrEmpty(date) || date.isAfter(LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person)o;
        return fullName.equals(person.fullName) &&
            dateOfBirth.equals(person.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, dateOfBirth);
    }
}
