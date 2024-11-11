package ru.kmbo.numerical_methods.calculate;

import lombok.experimental.UtilityClass;
import ru.kmbo.numerical_methods.model.basic.Matrix;
import ru.kmbo.numerical_methods.model.basic.SystemLinearEquations;
import ru.kmbo.numerical_methods.model.basic.Vector;


@UtilityClass
public class SystemLinearEquationsCalculate {

    public Vector calculate(SystemLinearEquations systemLinearEquations) {
        Matrix A = systemLinearEquations.getA();
        Vector b = systemLinearEquations.getB();
        int n = b.size();

        for (int i = 0; i < n; i++) {
            int max = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(A.get(j, i)) > Math.abs(A.get(max, i))) {
                    max = j;
                }
            }

            A.swapRow(i, max);
            b.swapRow(i, max);

            for (int j = i + 1; j < n; j++) {
                double factor = A.get(j, i) / A.get(i, i);
                b.set(j, b.get(j) - factor * b.get(i));
                for (int k = i; k < n; k++) {
                    A.set(j, k, A.get(j, k) - factor * A.get(i, k));
                }
            }
        }

        Vector x = new Vector();
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A.get(i, j) * x.get(j);
            }
            double element = (b.get(i) - sum) / A.get(i, i);
            x.set(i, element);
        }

        return x;
    }
}
