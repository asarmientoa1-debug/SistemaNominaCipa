package org.example.model;

public class EmpleadoComision extends Empleado {
    private double ventasRealizadas;
    private double porcentajeComision;

    public EmpleadoComision(String id, String nombre, double salarioBase, double ventasRealizadas, double porcentajeComision, int antiguedadAnios) {
        super(id, nombre, salarioBase, antiguedadAnios);
        if (ventasRealizadas < 0) {
            throw new IllegalArgumentException("Las ventas no pueden ser menores a $0.");
        }
        this.ventasRealizadas = ventasRealizadas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public double calcularSalarioBruto() {
        double bruto = getSalarioBase() + (ventasRealizadas * porcentajeComision);
        if (ventasRealizadas > 20000000) {
            bruto += ventasRealizadas * 0.03;
        }
        return bruto;
    }

    @Override
    public boolean esPermanente() {
        return true;
    }
}