/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.core;

/**
 *
 * @author william
 */
public class Atributo {

    private String nombre;
    private String unidades;
    private double peso;
    private final boolean positivo;
    private final double valor;

    public Atributo(String nombre, String unidades, double peso, boolean positivo, double valor) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.peso = peso;
        this.positivo = positivo;
        if (positivo)
            this.valor = valor;
        else
            this.valor = -valor;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public String getUnidades() {
        return unidades;
    }


}
