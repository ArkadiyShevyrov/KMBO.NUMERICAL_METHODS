package ru.kmbo.numerical_methods.core.calculate;

import lombok.experimental.UtilityClass;
import ru.kmbo.numerical_methods.core.model.basic.Matrix;
import ru.kmbo.numerical_methods.core.model.basic.SystemLinearEquations;
import ru.kmbo.numerical_methods.core.model.basic.Vector;
import ru.kmbo.numerical_methods.core.model.function.Polynomial;
import ru.kmbo.numerical_methods.core.model.function.implementation.TabularFunction;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Multiply;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Num;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Pow;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@UtilityClass
public class PolynomialCalculate {
    public Double getPointFunction(TabularFunction tabularFunction, Double xStar, int polynomialDegree) {
        Polynomial polynomial = new Polynomial(getCoefficientsUseLeastSquaresMethod(tabularFunction, polynomialDegree));
        return PolynomialCalculate.calculatePolynomial(polynomial, xStar);
    }

    public Double calculatePolynomial(Polynomial polynomial, Double x) {
        Vector coefficients = polynomial.getCoefficients();
        double sum = 0;
        for (int i = 0; i < coefficients.size(); i++) {
            sum += coefficients.get(i) * BasicCalculate.pow(x, i);
        }
        return sum;
    }

    private static Vector getCoefficientsUseLeastSquaresMethod(TabularFunction tabularFunction, int polynomialDegree) {
        Matrix matrix = new Matrix();
        Vector vector = new Vector();

        for (int i = 0; i <= polynomialDegree; i++) {
            for (int j = 0; j <= polynomialDegree; j++) {
                Map<Integer, Operand> xOperands = new HashMap<>();
                Set<Double> xList = tabularFunction.getNodes().keySet();
                int n = xList.size();
                int count = 1;
                for (Double x : xList) {
                    xOperands.put(count++, new Pow(x, i + j));
                }
                Double value = bigSum(1, n, xOperands);
                matrix.set(i, j, value);
            }
        }

        for (int i = 0; i <= polynomialDegree; i++) {
            Map<Integer, Operand> xOperands = new HashMap<>();
            Set<Double> xList = tabularFunction.getNodes().keySet();
            int n = xList.size();
            int count = 1;
            for (Double x : xList) {
                Double y = tabularFunction.apply(x);
                xOperands.put(count++, new Multiply(new Num(y), new Pow(x, i)));
            }
            vector.set(i, bigSum(1, n, xOperands));
        }

        SystemLinearEquations systemLinearEquations = new SystemLinearEquations(matrix, vector);
        return SystemLinearEquationsCalculate.calculate(systemLinearEquations);
    }

    private static Double bigSum(int iStart, int iEnd, Map<Integer, Operand> x) {
        double sum = 0;
        for (int i = iStart; i <= iEnd; i++) {
            sum += x.get(i).getResult();
        }
        return sum;
    }

}
