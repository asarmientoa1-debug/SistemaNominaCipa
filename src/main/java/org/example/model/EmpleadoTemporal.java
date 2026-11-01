package org.example.model;

public class EmpleadoTemporal extends Empleado {

    public EmpleadoTemporal(String id, String nombre, double salarioFijo, int antiguedadAnios) {
        super(id, nombre, salarioFijo, antiguedadAnios);
    }

    @Override
    public double calcularSalarioBruto() {
        return getSalarioBase();
    }

    @Override
    public boolean esPermanente() {
        return false;
    }
}