package com.examen.calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Calculator usando JUnit 5
 */
@DisplayName("Pruebas Unitarias - Calculator")
public class CalculatorTest {
    
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    @DisplayName("Suma de dos números positivos")
    void testSumarNumerosPositivos() {
        // Arrange
        double a = 5.0;
        double b = 3.0;
        double resultadoEsperado = 8.0;
        
        // Act
        double resultado = calculator.sumar(a, b);
        
        // Assert
        assertEquals(resultadoEsperado, resultado, 0.001);
    }
    
    @Test
    @DisplayName("Suma de números negativos")
    void testSumarNumerosNegativos() {
        assertEquals(-8.0, calculator.sumar(-5.0, -3.0), 0.001);
    }
    
    @Test
    @DisplayName("Resta de dos números")
    void testRestar() {
        assertEquals(2.0, calculator.restar(5.0, 3.0), 0.001);
        assertEquals(-2.0, calculator.restar(3.0, 5.0), 0.001);
    }
    
    @Test
    @DisplayName("Multiplicación de números")
    void testMultiplicar() {
        assertEquals(15.0, calculator.multiplicar(5.0, 3.0), 0.001);
        assertEquals(0.0, calculator.multiplicar(5.0, 0.0), 0.001);
    }
    
    @Test
    @DisplayName("División normal")
    void testDividirNormal() {
        assertEquals(2.5, calculator.dividir(5.0, 2.0), 0.001);
        assertEquals(1.0, calculator.dividir(5.0, 5.0), 0.001);
    }
    
    @Test
    @DisplayName("División por cero debe lanzar excepción")
    void testDividirPorCero() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.dividir(5.0, 0.0)
        );
        
        assertEquals("No se puede dividir por cero", exception.getMessage());
    }
    
    @Test
    @DisplayName("Potencia de números")
    void testPotencia() {
        assertEquals(8.0, calculator.potencia(2.0, 3.0), 0.001);
        assertEquals(1.0, calculator.potencia(5.0, 0.0), 0.001);
    }
    
    @Test
    @DisplayName("Raíz cuadrada de número positivo")
    void testRaizCuadradaPositiva() {
        assertEquals(3.0, calculator.raizCuadrada(9.0), 0.001);
        assertEquals(5.0, calculator.raizCuadrada(25.0), 0.001);
    }
    
    @Test
    @DisplayName("Raíz cuadrada de número negativo debe lanzar excepción")
    void testRaizCuadradaNegativa() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.raizCuadrada(-9.0)
        );
        
        assertEquals("No se puede calcular la raíz cuadrada de un número negativo", exception.getMessage());
    }
    
    @Test
    @DisplayName("Operaciones con números decimales")
    void testOperacionesDecimales() {
        assertEquals(3.7, calculator.sumar(1.2, 2.5), 0.001);
        assertEquals(3.0, calculator.multiplicar(1.5, 2.0), 0.001);
        assertEquals(0.6, calculator.dividir(3.0, 5.0), 0.001);
    }
}
