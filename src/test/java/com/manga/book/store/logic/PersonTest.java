package com.manga.book.store.logic;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PersonTest {
    @Test
    public void shouldCreate() {
        Person p = new Person(FullName.create("Jarbas", "Junior"), LocalDate.of(1990, 1, 1));
        assertNotNull(p.getId());
        assertNotNull(p);
    }

    @Test
    public void shouldBeEqual() {
        Person p1 = new Person(FullName.create("Jarbas", "Junior"), LocalDate.of(1990, 1, 1));
        Person p2 = new Person(FullName.create("Jarbas", "Junior"), LocalDate.of(1990, 1, 1));
        assertAll(
            () -> assertEquals(p1, p2),
            () -> assertEquals(p1.hashCode(), p2.hashCode())
        );
    }

    @ParameterizedTest
    @MethodSource("invalidValues")
    public void shouldThrowException(String firstName, String lastName, LocalDate dateOfBirth) {
        assertThrows(RuntimeException.class, () -> new Person(FullName.create(firstName, lastName), dateOfBirth));
    }

    private static Stream<Arguments> invalidValues() {
        return Stream.of(
            Arguments.of("Jarbas", "Junior", (LocalDate)null),
            Arguments.of("Jarbas", "Junior", LocalDate.of(2300, 1, 1))
        );
    }
}
