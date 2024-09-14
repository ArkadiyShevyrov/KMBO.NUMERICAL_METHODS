package ru.kmbo.numerical_methods.calculate;

import lombok.experimental.UtilityClass;

@UtilityClass
public class GaussianElimination {
    public double[] solve(double[][] A, double[] b) {
        int n = b.length;

        // Прямой ход
        for (int i = 0; i < n; i++) {
            // Нахождение максимального элемента в столбце для улучшения точности
            int max = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(A[j][i]) > Math.abs(A[max][i])) {
                    max = j;
                }
            }

            // Поменять строки местами
            double[] temp = A[i];
            A[i] = A[max];
            A[max] = temp;

            double t = b[i];
            b[i] = b[max];
            b[max] = t;

            // Обнуление элементов ниже главного элемента
            for (int j = i + 1; j < n; j++) {
                double factor = A[j][i] / A[i][i];
                b[j] -= factor * b[i];
                for (int k = i; k < n; k++) {
                    A[j][k] -= factor * A[i][k];
                }
            }
        }

        // Обратная подстановка
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }

        return x;
    }
}
