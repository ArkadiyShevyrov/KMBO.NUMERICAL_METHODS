package ru.kmbo.numerical_methods.calculate;

import lombok.experimental.UtilityClass;
import ru.kmbo.numerical_methods.model.function.Polynomial;
import java.util.List;

import static ru.kmbo.numerical_methods.calculate.BasicCalculate.*;

@UtilityClass
public class PolynomialCalculate {
    public Double calculatePolynomial(Polynomial polynomial, Double x) {
        List<Double> coefficients = polynomial.getCoefficients();
        double sum = 0;
        for (int i = 0; i < coefficients.size(); i++) {
            sum += coefficients.get(i) * pow(x, i);
        }
        return sum;
    }
}
