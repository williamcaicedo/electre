/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.core;

import java.util.List;

/**
 *
 * @author william
 */
public class Alternativa {
    private String nombre;
    private List<Atributo> atributos;
    public Alternativa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    


}
