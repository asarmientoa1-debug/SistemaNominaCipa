package org.example.model;

public abstract class Empleado {
    private String id;
    private String nombre;
    private double salarioBase;
    private int antiguedadAnios;

    public Empleado(String id, String nombre, double salarioBase, int antiguedadAnios) {
        if (salarioBase < 0) {
            throw new IllegalArgumentException("El salario base no puede ser negativo.");
        }
        this.id = id;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.antiguedadAnios = antiguedadAnios;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getSalarioBase() { return salarioBase; }
    public int getAntiguedadAnios() { return antiguedadAnios; }

    public abstract double calcularSalarioBruto();
    public abstract boolean esPermanente();
}