package com.kodilla.stream.sand;

import java.math.BigDecimal;

public final class Africa implements SandStorage {

    @Override
    public BigDecimal getSandBeansQuantity() {
        return new BigDecimal("99999999901234567890");
    }
}