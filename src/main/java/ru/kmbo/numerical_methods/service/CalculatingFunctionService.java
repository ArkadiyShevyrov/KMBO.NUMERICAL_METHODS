package ru.kmbo.numerical_methods.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kmbo.numerical_methods.util.CalculatingUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalculatingFunctionService {

    public double calculateSin(double x, double precision) {
        return CalculatingUtils.calculateSin(x, precision);
    }

    public double calculateExp(double x, double precision) {
        return CalculatingUtils.calculateExp(x, precision);
    }

    public double calculateLg(double x, double precision) {
        return CalculatingUtils.calculateLg(x, precision);
    }

    public double calculateCos(double x, double precision) {
        return CalculatingUtils.calculateCos(x, precision);
    }

    public double calculateLn(double x, double precision) {
        return CalculatingUtils.calculateLn(x, precision);
    }

    public double calculateLogBaseA(double base, double x, double precision) {
        return CalculatingUtils.calculateLog(base, x, precision);
    }
}
