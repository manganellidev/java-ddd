package com.manga.ddd.logic.product;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TypeCodeTest {
    @Test
    public void shouldCreateAsMaterial() {
        TypeCode typeCode = TypeCode.create("MATERIAL");
        assertNotNull(typeCode);
    }

    @Test
    public void shouldCreateAsService() {
        TypeCode typeCode = TypeCode.create("SERVICE");
        assertNotNull(typeCode);
    }

    @Test
    public void shouldThrowExceptionWhenValueIsUnknown() {
        assertThrows(RuntimeException.class, () -> TypeCode.create("UNKNOWN"));
    }

    @Test
    public void shouldBeEqual() {
        TypeCode t1 = TypeCode.create("MATERIAL");
        TypeCode t2 = TypeCode.create("MATERIAL");
        assertTrue(t1.sameAs(t2));
    }

    @Test
    public void shouldNotBeEqual() {
        TypeCode t1 = TypeCode.create("MATERIAL");
        TypeCode t2 = TypeCode.create("SERVICE");
        assertFalse(t1.sameAs(t2));
    }
}