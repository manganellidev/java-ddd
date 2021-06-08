package com.manga.ddd.logic.product;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Instant;
import org.junit.jupiter.api.Test;

class ProductTest {
    static final Instant validFrom1999 = Instant.parse("1999-01-01T00:00:00Z");
    static final Instant validTo9999 = Instant.parse("9999-12-31T23:59:59Z");

    @Test
    public void shouldCreate() {
        Code code = Code.create("CODE1", "DESC 1");
        TypeCode typeCode = TypeCode.create(ProductTypes.MATERIAL.toString());
        Period period = Period.create(validFrom1999, validTo9999);
        Product product = new Product(code, typeCode, period);
        assertNotNull(product);
    }

}