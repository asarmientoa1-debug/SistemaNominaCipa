package org.example.service;

import org.example.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraNominaTest {

    private final CalculadoraNomina calculadora = new CalculadoraNomina();

    @Test
    void testEmpleadoPorHorasConHorasExtras() {
        // 50 horas: 40 normales a 10.000 + 10 extras a 15.000 (1.5x) = 550.000
        EmpleadoPorHoras emp = new EmpleadoPorHoras("1", "Carlos", 10000, 50, 2);
        assertEquals(550000, emp.calcularSalarioBruto());
    }

    @Test
    void testValidacionHorasNegativasThrowsException() {
        // Regla de negocio: las horas no pueden ser negativas
        assertThrows(IllegalArgumentException.class, () -> {
            new EmpleadoPorHoras("2", "Ana", 10000, -5, 1);
        });
    }

    @Test
    void testEmpleadoComisionBonoVentasSuperiores20Millones() {
        // Base 1.000.000 + 5% de 25M (1.250.000) + Bono 3% sobre 25M (750.000) = 3.000.000
        EmpleadoComision emp = new EmpleadoComision("3", "Luis", 1000000, 25000000, 0.05, 3);
        assertEquals(3000000, emp.calcularSalarioBruto());
    }

    @Test
    void testCalculoSalarioNetoConBeneficioPermanente() {
        EmpleadoAsalariado emp = new EmpleadoAsalariado("4", "Maria", 2000000, 6);
        double neto = calculadora.calcularSalarioNeto(emp, false, 0.01);
        assertEquals(3090000, neto);
    }
}