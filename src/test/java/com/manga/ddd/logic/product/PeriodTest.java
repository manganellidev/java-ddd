package com.manga.ddd.logic.product;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Instant;
import org.junit.jupiter.api.Test;

class PeriodTest {
    static final Instant validFrom1999 = Instant.parse("1999-01-01T00:00:00Z");
    static final Instant validTo9999 = Instant.parse("9999-12-31T23:59:59Z");

    @Test
    public void shouldCreate() {
        Period period = Period.create(validFrom1999, validTo9999);
        assertNotNull(period);
    }

    @Test
    public void shouldThrowExceptionWhenDateToIsBehindDateFrom() {
        Instant validFrom2010 = Instant.parse("2010-01-01T00:00:00Z");
        Instant validTo1999 = Instant.parse("1999-01-01T00:00:00Z");
        assertThrows(RuntimeException.class, () -> Period.create(validFrom2010, validTo1999));
    }

    @Test
    public void shouldBeEqual() {
        Period p1 = Period.create(validFrom1999, validTo9999);
        Period p2 = Period.create(validFrom1999, validTo9999);
        assertTrue(p1.sameAs(p2));
    }

    @Test
    public void shouldNotBeEqual() {
        Period p1 = Period.create(validFrom1999, validTo9999);
        Period p2 = Period.create(validFrom1999, Instant.parse("2010-01-01T00:00:00Z"));
        assertFalse(p1.sameAs(p2));
    }
}