package ru.kmbo.numerical_methods.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kmbo.numerical_methods.calculate.TaylorCalculate;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalculatingFunctionService {

    public double calculateSin(double x, double precision) {
        return TaylorCalculate.sin(x, precision);
    }

    public double calculateExp(double x, double precision) {
        return TaylorCalculate.exp(x, precision);
    }

    public double calculateLg(double x, double precision) {
        return TaylorCalculate.lg(x, precision);
    }

    public double calculateCos(double x, double precision) {
        return TaylorCalculate.cos(x, precision);
    }

    public double calculateLn(double x, double precision) {
        return TaylorCalculate.ln(x, precision);
    }

    public double calculateLogBaseA(double base, double x, double precision) {
        return TaylorCalculate.log(base, x, precision);
    }
}
