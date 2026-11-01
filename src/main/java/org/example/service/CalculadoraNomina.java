package org.example.service;

import org.example.model.*;

public class CalculadoraNomina {
    private static final double MONTO_BONO_ALIMENTACION = 1000000.0;

    public double calcularSalarioNeto(Empleado empleado, boolean aceptaFondoAhorro, double porcentajeArl) {
        double bruto = empleado.calcularSalarioBruto();

        double deduccionSeguroPension = bruto * 0.04;
        double deduccionArl = bruto * porcentajeArl;
        double totalDeducciones = deduccionSeguroPension + deduccionArl;

        double beneficios = 0.0;
        if (empleado.esPermanente()) {
            beneficios += MONTO_BONO_ALIMENTACION;
        }

        if (empleado instanceof EmpleadoPorHoras && empleado.getAntiguedadAnios() > 1 && aceptaFondoAhorro) {
            beneficios += bruto * 0.02;
        }

        double neto = bruto + beneficios - totalDeducciones;

        if (neto < 0) {
            throw new IllegalStateException("El salario neto no puede ser negativo.");
        }

        return neto;
    }
}