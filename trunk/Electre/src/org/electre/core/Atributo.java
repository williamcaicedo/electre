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
    private boolean positivo;
    private double valor;

    public Atributo(String nombre, boolean positivo, double peso) {
        this.nombre = nombre;
        //this.unidades = unidades;
        this.peso = peso;
        this.positivo = positivo;
        
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
       if (positivo)
            this.valor = valor;
        else
            this.valor = -valor;
    }

    public boolean isPositivo() {
        return positivo;
    }

    public void setPositivo(boolean positivo) {
        this.positivo = positivo;
    }


}
