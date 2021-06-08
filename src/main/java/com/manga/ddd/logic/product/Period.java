package com.manga.ddd.logic.product;

import java.time.Instant;

final class Period {
    private Instant validFrom;
    private Instant validTo;

    private Period(Instant validFrom, Instant validTo) {
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public static Period create(Instant validFrom, Instant validTo) {
        if (!isPeriodValid(validFrom, validTo))
            throw new RuntimeException("The period informed is not valid.");

        return new Period(validFrom, validTo);
    }

    private static boolean isPeriodValid(Instant validFrom, Instant validTo) {
        return validFrom.isAfter(validTo) ? false : true;
    }

    public boolean sameAs(Period anotherPeriod) {
        return validFrom.equals(anotherPeriod.validFrom) &&
            validTo.equals(anotherPeriod.validTo);
    }
}
