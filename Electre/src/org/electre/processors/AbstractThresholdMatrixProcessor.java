/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.processors;

/**
 *
 * @author william
 */
public abstract class AbstractThresholdMatrixProcessor extends AbstractMatrixProcessor{

    public double getThreshold() {
        double sum = 0;
        for(double[] row : this.matrix) {
            for (double v : row) {
                sum += v;
            }
        }
        return sum/(this.matrix.length*this.matrix[0].length);
    }

}
