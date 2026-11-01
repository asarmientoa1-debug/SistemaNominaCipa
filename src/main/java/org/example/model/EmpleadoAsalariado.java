package org.example.model;

public class EmpleadoAsalariado extends Empleado {

    public EmpleadoAsalariado(String id, String nombre, double salarioFijo, int antiguedadAnios) {
        super(id, nombre, salarioFijo, antiguedadAnios);
    }

    @Override
    public double calcularSalarioBruto() {
        double bruto = getSalarioBase();
        if (getAntiguedadAnios() > 5) {
            bruto += getSalarioBase() * 0.10;
        }
        return bruto;
    }

    @Override
    public boolean esPermanente() {
        return true;
    }
}