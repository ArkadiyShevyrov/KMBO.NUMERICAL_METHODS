package ru.kmbo.numerical_methods.labs.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kmbo.numerical_methods.core.calculate.PolynomialCalculate;
import ru.kmbo.numerical_methods.core.model.function.implementation.TabularFunction;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/lab_1_5")
@CrossOrigin(origins = "http://localhost:3000")
public class Lab_1_5_Controller {

    @PostMapping("/least-squares-method")
    public ResponseEntity<String> leastSquaresMethod(
        @RequestParam Double x,
        @RequestParam Integer degree,
        @RequestBody TabularFunction function
    ) {
        log.info("Получен запрос на вычисление приближающего многочлена функции{} в точке {}",
            function, x);
        Double result = PolynomialCalculate.getPointFunction(function, x, degree);
        log.info("Результат вычисления приближающего многочлена функции {} в точке {}: {}",
            function, x, result);
        return ResponseEntity.ok(String.valueOf(result));
    }
}
