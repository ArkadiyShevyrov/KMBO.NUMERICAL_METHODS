package ru.kmbo.numerical_methods.util;

import lombok.experimental.UtilityClass;
import java.math.BigDecimal;
import java.math.RoundingMode;

@UtilityClass
public class RoundUtils {
    public double roundToPrecision(double value, double precision) {
        BigDecimal bdValue = new BigDecimal(value);
        int decimalPlaces = (int) (-Math.log10(precision));
        bdValue = bdValue.setScale(decimalPlaces, RoundingMode.HALF_UP);
        return bdValue.doubleValue();
    }
}
