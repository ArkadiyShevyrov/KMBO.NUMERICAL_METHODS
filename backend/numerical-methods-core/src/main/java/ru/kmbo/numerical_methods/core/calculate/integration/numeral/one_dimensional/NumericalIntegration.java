package ru.kmbo.numerical_methods.core.calculate.integration.numeral.one_dimensional;

import lombok.experimental.UtilityClass;
import ru.kmbo.numerical_methods.core.calculate.integration.numeral.one_dimensional.method.*;
import ru.kmbo.numerical_methods.core.model.function.implementation.OperandFunction;

@UtilityClass
public class NumericalIntegration {
    private final RectangleLeftMethod rectangleLeftMethod = new RectangleLeftMethod();
    private final RectangleMedianMethod rectangleMedianMethod = new RectangleMedianMethod();
    private final RectangleRightMethod rectangleRightMethod = new RectangleRightMethod();
    private final SimpsonMethod simpsonMethod = new SimpsonMethod();
    private final TrapezoidalMethod trapezoidalMethod = new TrapezoidalMethod();


    public Double integrate(OperandFunction f, double a, double b, double h, TypeMethod typeMethod) {
        return switch (typeMethod) {
            case RECTANGLE_LEFT_METHOD -> rectangleLeftMethod.integrate(f, a, b, h);
            case RECTANGLE_MEDIAN_METHOD -> rectangleMedianMethod.integrate(f, a, b, h);
            case RECTANGLE_RIGHT_METHOD -> rectangleRightMethod.integrate(f, a, b, h);
            case SIMPSON_METHOD -> simpsonMethod.integrate(f, a, b, h);
            case TRAPEZOID_METHOD -> trapezoidalMethod.integrate(f, a, b, h);
        };
    }

    public Double tolerance(OperandFunction f, double a, double b, double h, TypeMethod typeMethod) {
        return switch (typeMethod) {
            case RECTANGLE_LEFT_METHOD -> rectangleLeftMethod.tolerance(f, a, b, h);
            case RECTANGLE_MEDIAN_METHOD -> rectangleMedianMethod.tolerance(f, a, b, h);
            case RECTANGLE_RIGHT_METHOD -> rectangleRightMethod.tolerance(f, a, b, h);
            case SIMPSON_METHOD -> simpsonMethod.tolerance(f, a, b, h);
            case TRAPEZOID_METHOD -> trapezoidalMethod.tolerance(f, a, b, h);
        };
    }

    public enum TypeMethod {
        RECTANGLE_LEFT_METHOD,
        RECTANGLE_RIGHT_METHOD,
        RECTANGLE_MEDIAN_METHOD,
        SIMPSON_METHOD,
        TRAPEZOID_METHOD,
    }
}
