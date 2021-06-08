package com.manga.ddd.logic.product;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CodeTest {
    @Test
    public void shouldCreate() {
        Code c = Code.create("CODE1");
        assertNotNull(c);
    }

    @Test
    public void shouldCreateWithDesc() {
        Code c = Code.create("CODE1", "DESCRIPTION 1");
        assertNotNull(c);
    }

    @ParameterizedTest
    @MethodSource("invalidCodes")
    public void shouldThrowException(String value, String desc) {
        assertThrows(RuntimeException.class, () -> Code.create(value, desc));
    }

    private static Stream<Arguments> invalidCodes() {
        String valueTooLarge = "CODE1CODE1CODE1CODE1CODE1CODE1L";
        String descTooLarge = "DESCRIPTION 1 DESCRIPTION 1 DESCRIPTION 1 DESCRIPTION 1 DESCRIPTION 1 DESCRIPTION 1 " +
            "DESCRIPTION 1 DESCRIPTION 1 DESCRIPTION 1 DESCRIPTION 1 DESCRIPTION 1 DESCRIPTION 1 DESCRIPTION 1  " +
            "DESCRIPTION 1 LLLL";

        return Stream.of(
            Arguments.of("", ""),
            Arguments.of("", "DESC 1"),
            Arguments.of("CODE1@", ""),
            Arguments.of(valueTooLarge, "DESC 1"),
            Arguments.of("CODE1", "DESC 1!"),
            Arguments.of("CODE1", descTooLarge)
        );
    }

    @Test
    public void shouldBeEqual() {
        Code c1 = Code.create("CODE1");
        Code c2 = Code.create("CODE1");
        assertTrue(c1.sameAs(c2));
    }

    @Test
    public void shouldNotBeEqual() {
        Code c1 = Code.create("CODE1");
        Code c2 = Code.create("CODE2");
        assertFalse(c1.sameAs(c2));
    }
}