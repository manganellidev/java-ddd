package com.manga.book.store.logic;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FullNameTest {
    @Test
    public void shouldCreate() {
        FullName f = FullName.create("Jarbas", "Junior");
        assertNotNull(f);
    }

    @Test
    public void shouldBeEqual() {
        FullName f1 = FullName.create("Jarbas", "Junior");
        FullName f2 = FullName.create("Jarbas", "Junior");
        assertTrue(f1.sameAs(f2));
    }

    @ParameterizedTest
    @MethodSource("invalidValues")
    public void shouldThrowException(String firstName, String lastName) {
        assertThrows(RuntimeException.class, () -> FullName.create(firstName, lastName));
    }

    private static Stream<Arguments> invalidValues() {
        String valueTooLarge = "Jarbassssssssssssssssssssssssss";

        return Stream.of(
            Arguments.of("Jarbas", ""),
            Arguments.of("Jarbas", null),
            Arguments.of("", "Junior"),
            Arguments.of(null, "Junior"),
            Arguments.of(valueTooLarge, "Junior"),
            Arguments.of("Jarbas", valueTooLarge)
        );
    }
}