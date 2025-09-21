package com.examen.calculadora;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * Pruebas de integración para la clase Calculator usando TestNG
 * Estas pruebas verifican el comportamiento completo del sistema
 */
public class CalculatorIntegrationTest {
    
    private Calculator calculator;
    
    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }
    
    @Test(groups = "integration")
    public void testFlujoCompletoCalculadora() {
        // Simula un flujo completo de operaciones matemáticas
        double resultado1 = calculator.sumar(10.0, 5.0);
        Assert.assertEquals(resultado1, 15.0, 0.001);
        
        double resultado2 = calculator.multiplicar(resultado1, 2.0);
        Assert.assertEquals(resultado2, 30.0, 0.001);
        
        double resultado3 = calculator.dividir(resultado2, 3.0);
        Assert.assertEquals(resultado3, 10.0, 0.001);
        
        double resultadoFinal = calculator.restar(resultado3, 2.0);
        Assert.assertEquals(resultadoFinal, 8.0, 0.001);
    }
    
    @Test(groups = "integration")
    public void testOperacionesComplejas() {
        // Prueba operaciones más complejas que involucran múltiples métodos
        double base = calculator.sumar(3.0, 2.0); // 5.0
        double potencia = calculator.potencia(base, 2.0); // 25.0
        double raiz = calculator.raizCuadrada(potencia); // 5.0
        
        Assert.assertEquals(raiz, 5.0, 0.001);
    }
    
    @Test(groups = "integration", expectedExceptions = IllegalArgumentException.class)
    public void testManejoErroresIntegracion() {
        // Prueba el manejo de errores en un flujo de integración
        double resultado = calculator.dividir(10.0, 0.0);
        // Esta línea no debería ejecutarse debido a la excepción
        Assert.fail("Debería haber lanzado una excepción");
    }
    
    @Test(groups = "integration")
    public void testPrecisionNumerica() {
        // Prueba la precisión numérica en operaciones complejas
        double resultado = calculator.dividir(
            calculator.multiplicar(calculator.sumar(1.0, 1.0), 3.0), 
            6.0
        );
        Assert.assertEquals(resultado, 1.0, 0.001);
    }
    
    @Test(groups = "integration")
    public void testCasosLimite() {
        // Prueba casos límite del sistema
        Assert.assertEquals(0.0, calculator.sumar(0.0, 0.0), 0.001);
        Assert.assertEquals(1.0, calculator.potencia(0.0, 0.0), 0.001);
        Assert.assertEquals(0.0, calculator.raizCuadrada(0.0), 0.001);
    }
}
