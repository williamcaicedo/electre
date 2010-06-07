/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.processors;

import java.util.List;
import org.electre.core.Atributo;

/**
 *
 * @author william
 */
public class DecisionMatrixProcessor extends AbstractMatrixProcessor{

    @Override
    public double[][] process(double[][] m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static double[][] normalize(double[][] m) {
        double[][] n = new double[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            double min = m[0][i];
            double max = min;
            for (int j = 0; j < m[0].length; j++) {
                if (m[j][i] > max) {
                    max = m[j][i];
                }
                if (m[j][i] < min) {
                    min = m[j][i];
                }
            }
             for (int j = 0; j < m[0].length; j++) {
                 n[j][i] = m[j][i]/(max-min);
             }
        }

        return n;
    }

    public static double[][] weigh(double[][] m, List<Atributo> attributes){
        double[][] n = new double[m.length][m[0].length];
        int i = 0;
        for(Atributo a : attributes) {
            for (int j = 0; j < m.length; j++) {
                n[j][i] = m[j][i]*a.getPeso();
            }
            i++;
        }
        return n;
    }

}
