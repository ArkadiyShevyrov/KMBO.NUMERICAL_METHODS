package ru.kmbo.numerical_methods.controller.lab;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Pattern;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kmbo.numerical_methods.service.CalculatingFunctionService;


@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/lab_1_1")
@CrossOrigin(origins = "http://localhost:3000")
public class Lab_1_1_Controller {

    @NonNull
    private final CalculatingFunctionService calculatingFunctionService;

    @GetMapping("/sin")
    public ResponseEntity<String> calculateSin(
            @Parameter(description = "Параметр функции", example = "1.570796")
            @Pattern(regexp = "\\d+(\\.\\d+)?", message = "Некорректный формат числа")
            @RequestParam String x,
            @Parameter(description = "Точность решения", example = "1e-10")
            @Pattern(regexp = "-?\\d+(\\.\\d+)?([eE][-+]?\\d+)?", message = "Некорректный формат числа")
            @RequestParam String predication
    ) {
        log.info("Получен запрос на вычисление sin({})", x);
        double result = calculatingFunctionService.calculateSin(Double.parseDouble(x),
                Double.parseDouble(predication));
        log.info("Результат вычисления sin({}): {}", x, result);
        return ResponseEntity.ok(String.valueOf(result));
    }

    @GetMapping("/exp")
    public ResponseEntity<String> calculateExp(
            @Parameter(description = "x", example = "10")
            @Pattern(regexp = "\\d+(\\.\\d+)?", message = "Некорректный формат числа")
            @RequestParam String x,
            @Parameter(description = "Точность решения", example = "1e-10")
            @Pattern(regexp = "-?\\d+(\\.\\d+)?([eE][-+]?\\d+)?", message = "Некорректный формат числа")
            @RequestParam String predication
    ) {
        log.info("Получен запрос на вычисление e^({})", x);
        double result = calculatingFunctionService.calculateExp(Double.parseDouble(x),
                Double.parseDouble(predication));
        log.info("Результат вычисления e^({}): {}", x, result);
        return ResponseEntity.ok(String.valueOf(result));
    }

    @GetMapping("/lg")
    public ResponseEntity<String> calculateLg(
            @Parameter(description = "x", example = "10")
            @Pattern(regexp = "\\d+(\\.\\d+)?", message = "Некорректный формат числа")
            @RequestParam String x,
            @Parameter(description = "Точность решения", example = "1e-10")
            @Pattern(regexp = "-?\\d+(\\.\\d+)?([eE][-+]?\\d+)?", message = "Некорректный формат числа")
            @RequestParam String predication
    ) {
        log.info("Получен запрос на вычисление lg({})", x);
        double result = calculatingFunctionService.calculateLg(Double.parseDouble(x),
                Double.parseDouble(predication));
        log.info("Результат вычисления lg({}): {}", x, result);
        return ResponseEntity.ok(String.valueOf(result));
    }

    @GetMapping("/cos")
    public ResponseEntity<String> calculateCos(
            @Parameter(description = "x", example = "10")
            @Pattern(regexp = "\\d+(\\.\\d+)?", message = "Некорректный формат числа")
            @RequestParam String x,
            @Parameter(description = "Точность решения", example = "1e-10")
            @Pattern(regexp = "-?\\d+(\\.\\d+)?([eE][-+]?\\d+)?", message = "Некорректный формат числа")
            @RequestParam String predication
    ) {
        log.info("Получен запрос на вычисление cos({})", x);
        double result = calculatingFunctionService.calculateCos(Double.parseDouble(x),
                Double.parseDouble(predication));
        log.info("Результат вычисления cos({}): {}", x, result);
        return ResponseEntity.ok(String.valueOf(result));
    }

    @GetMapping("/ln")
    public ResponseEntity<String> calculateLn(
            @Parameter(description = "x", example = "10")
            @Pattern(regexp = "\\d+(\\.\\d+)?", message = "Некорректный формат числа")
            @RequestParam String x,
            @Parameter(description = "Точность решения", example = "1e-10")
            @Pattern(regexp = "-?\\d+(\\.\\d+)?([eE][-+]?\\d+)?", message = "Некорректный формат числа")
            @RequestParam String predication
    ) {
        log.info("Получен запрос на вычисление ln({})", x);
        double result = calculatingFunctionService.calculateLn(Double.parseDouble(x),
                Double.parseDouble(predication));
        log.info("Результат вычисления ln({}): {}", x, result);
        return ResponseEntity.ok(String.valueOf(result));
    }

    @GetMapping("/log_a")
    public ResponseEntity<String> calculateLogBaseA(
            @Parameter(description = "x", example = "10")
            @Pattern(regexp = "\\d+(\\.\\d+)?", message = "Некорректный формат числа")
            @RequestParam String x,
            @Parameter(description = "a", example = "10")
            @Pattern(regexp = "\\d+(\\.\\d+)?", message = "Некорректный формат числа")
            @RequestParam String base,
            @Parameter(description = "Точность решения", example = "1e-10")
            @Pattern(regexp = "-?\\d+(\\.\\d+)?([eE][-+]?\\d+)?", message = "Некорректный формат числа")
            @RequestParam String predication
    ) {
        log.info("Получен запрос на вычисление log_{}({})", base, x);
        double result = calculatingFunctionService.calculateLogBaseA(Double.parseDouble(base), Double.parseDouble(x),
                Double.parseDouble(predication));
        log.info("Результат вычисления log_{}({}): {}", base, x, result);
        return ResponseEntity.ok(String.valueOf(result));
    }
}
