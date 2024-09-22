package ru.kmbo.numerical_methods.controller;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kmbo.numerical_methods.calculate.DerivativeCalculate;
import ru.kmbo.numerical_methods.model.function.TabularFunction;


@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/lab_1_2")
@CrossOrigin(origins = "http://localhost:3000")
public class Lab_1_2_Controller {

    @PutMapping("/first-derivative")
    public ResponseEntity<String> firstDerivative(
            @Parameter(description = "Параметр функции", example = "1.0")
            @Pattern(regexp = "\\d+(\\.\\d+)?", message = "Некорректный формат числа")
            @RequestParam String xStar,
            @Parameter(description = "функция")
            @RequestBody TabularFunction tabularFunction
    ) {
        log.info("Получен запрос на вычисление первой производной заданной функции {} в точке {}",
                tabularFunction, xStar);
        Double result = DerivativeCalculate.firstDerivative(tabularFunction, Double.parseDouble(xStar));
        log.info("Результат вычисления первой производной заданной функции {} в точке {}: {}",
                tabularFunction, xStar, result);
        return ResponseEntity.ok(String.valueOf(result));
    }

    @PutMapping("/second-derivative")
    public ResponseEntity<String> secondDerivative(
            @Parameter(description = "Параметр функции", example = "1.0")
            @Pattern(regexp = "\\d+(\\.\\d+)?", message = "Некорректный формат числа")
            @RequestParam String xStar,
            @Parameter(description = "функция")
            @RequestBody TabularFunction tabularFunction
    ) {
        log.info("Получен запрос на вычисление второй производной заданной функции {} в точке {}",
                tabularFunction, xStar);
        Double result = DerivativeCalculate.secondDerivative(tabularFunction, Double.parseDouble(xStar));
        log.info("Результат вычисления второй производной заданной функции {} в точке {}: {}",
                tabularFunction, xStar, result);
        return ResponseEntity.ok(String.valueOf(result));
    }
}
