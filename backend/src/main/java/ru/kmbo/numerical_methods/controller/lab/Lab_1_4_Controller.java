package ru.kmbo.numerical_methods.controller.lab;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kmbo.numerical_methods.calculate.CubicSplineInterpolatorCalculate;
import ru.kmbo.numerical_methods.calculate.InterpolationCalculate;
import ru.kmbo.numerical_methods.model.function.implementation.TabularFunction;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/lab_1_4")
@CrossOrigin(origins = "http://localhost:3000")
public class Lab_1_4_Controller {

    @PostMapping("/cubic-spline-interpolation")
    public ResponseEntity<String> cubicSplineInterpolation(
            @RequestParam Double x,
            @RequestBody TabularFunction function
    ) {
        log.info("Получен запрос на вычисление интерполяции сплайна функции {} в точке {}",
                function, x);
        Double result = CubicSplineInterpolatorCalculate.evaluateSpline(function, x);
        log.info("Результат вычисления интерполяции сплайна функции {} в точке {}: {}",
                function, x, result);
        return ResponseEntity.ok(String.valueOf(result));
    }
}
