/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.processors;

/**
 *
 * @author william
 */
public abstract class AbstractMatrixProcessor {
    protected double[][] matrix;

    public abstract double[][] process(double[][] m);
}
