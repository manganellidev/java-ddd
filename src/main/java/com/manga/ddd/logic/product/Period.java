package com.manga.ddd.logic.product;

import com.manga.ddd.logic.converters.InstantConverter;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

@Embeddable
public final class Period {
    @Convert(converter = InstantConverter.class)
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Instant validFrom;
    @Convert(converter = InstantConverter.class)
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Instant validTo;

    private Period() {
    }

    private Period(Instant validFrom, Instant validTo) {
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public static Period create(Instant validFrom, Instant validTo) {
        if (!isPeriodValid(validFrom, validTo))
            throw new RuntimeException("The period informed is not valid.");

        return new Period(validFrom, validTo);
    }

    public Instant validFrom() {
        return this.validFrom;
    }

    public Instant validTo() {
        return this.validTo;
    }

    private static boolean isPeriodValid(Instant validFrom, Instant validTo) {
        return validFrom.isAfter(validTo) ? false : true;
    }

    public boolean sameAs(Period anotherPeriod) {
        return validFrom.equals(anotherPeriod.validFrom) &&
            validTo.equals(anotherPeriod.validTo);
    }
}
