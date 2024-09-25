package ru.kmbo.numerical_methods.service.lab_logic;

import lombok.experimental.UtilityClass;
import ru.kmbo.numerical_methods.calculate.PolynomialCalculate;
import ru.kmbo.numerical_methods.calculate.SystemLinearEquationsCalculate;
import ru.kmbo.numerical_methods.model.basic.Vector;
import ru.kmbo.numerical_methods.model.basic.*;
import ru.kmbo.numerical_methods.model.function.Polynomial;
import ru.kmbo.numerical_methods.model.function.TabularFunction;
import ru.kmbo.numerical_methods.model.operand.implementation.Multiply;
import ru.kmbo.numerical_methods.model.operand.implementation.Num;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Pow;
import java.util.*;

@UtilityClass
public class L_1_5_Logic {

    public List<Point> getPointFunction(TabularFunction tabularFunction, FunctionalOption functionalOption, int polynomialDegree) {
        List<Point> result = new ArrayList<>();

        Polynomial polynomial = new Polynomial(getCoefficientsUseLeastSquaresMethod(tabularFunction, polynomialDegree));

        double xMin = functionalOption.getXMin();
        double xMax = functionalOption.getXMax();
        double step = functionalOption.getStep();

        for (double x = xMin; x <= xMax; x += step) {
            Double y = PolynomialCalculate.calculatePolynomial(polynomial, x);
            result.add(new Point(x, y));
        }

        return result;
    }

    private static List<Double> getCoefficientsUseLeastSquaresMethod(TabularFunction tabularFunction, int polynomialDegree) {
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
                Double y = tabularFunction.getResult(x);
                xOperands.put(count++, new Multiply(new Num(y),new Pow(x, i)));
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
