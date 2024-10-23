package ru.kmbo.numerical_methods.calculate;

import lombok.experimental.UtilityClass;
import ru.kmbo.numerical_methods.model.function.implementation.LagrangeInterpolationPolynomial;
import ru.kmbo.numerical_methods.model.function.implementation.NewtonInterpolationPolynomial;
import ru.kmbo.numerical_methods.model.function.implementation.TabularFunction;

@UtilityClass
public class InterpolationCalculate {

    public static double lagrangeInterpolate(TabularFunction func, Double xStar) {
        LagrangeInterpolationPolynomial LagrangeInterpolationPolynomial = new LagrangeInterpolationPolynomial(func);
        return LagrangeInterpolationPolynomial.apply(xStar);
    }

    public double newtonInterpolate(TabularFunction func, Double xStar) {
        NewtonInterpolationPolynomial newtonInterpolationPolynomial = new NewtonInterpolationPolynomial(func);
        return newtonInterpolationPolynomial.apply(xStar);
    }
}
