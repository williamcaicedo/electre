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

    public Atributo(String nombre, String unidades, double peso) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.peso = peso;
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
