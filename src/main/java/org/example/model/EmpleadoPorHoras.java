package org.example.model;

public class EmpleadoPorHoras extends Empleado {
    private double horasTrabajadas;

    public EmpleadoPorHoras(String id, String nombre, double tarifaPorHora, double horasTrabajadas, int antiguedadAnios) {
        super(id, nombre, tarifaPorHora, antiguedadAnios);
        if (horasTrabajadas < 0) {
            throw new IllegalArgumentException("Las horas trabajadas no pueden ser negativas.");
        }
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSalarioBruto() {
        double tarifa = getSalarioBase();
        if (horasTrabajadas <= 40) {
            return horasTrabajadas * tarifa;
        } else {
            double horasNormales = 40;
            double horasExtras = horasTrabajadas - 40;
            return (horasNormales * tarifa) + (horasExtras * tarifa * 1.5);
        }
    }

    @Override
    public boolean esPermanente() {
        return false;
    }

    public double getHorasTrabajadas() { return horasTrabajadas; }
}