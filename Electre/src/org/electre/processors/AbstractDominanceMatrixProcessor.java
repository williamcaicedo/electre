/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.processors;

import org.electre.utils.AbstractComparator;

/**
 *
 * @author william
 */
public abstract class AbstractDominanceMatrixProcessor extends AbstractMatrixProcessor {

    protected boolean concordance;
    private double threshold;
    private final AbstractComparator comparator;

    public AbstractDominanceMatrixProcessor(AbstractComparator comparator, double threshold) {
        this.comparator = comparator;
        this.threshold = threshold;
    }

    @Override
    public double[][] process(double[][] m) {
        if (this.threshold == 0.0)
            this.threshold = this.getAverage(m);
        double[][] resultMatrix = new double[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                resultMatrix[i][j] = this.comparator.compare(m[i][j], this.threshold);
            }
        }
        this.matrix = resultMatrix;
        return resultMatrix;
    }

    private double getAverage(double[][] m) {
        double sum =0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                sum += m[i][j];
            }
        }
        return sum/(m.length*m[0].length);
    }
}
