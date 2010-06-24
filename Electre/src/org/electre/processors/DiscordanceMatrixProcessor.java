/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.processors;

/**
 *
 * @author william
 */
public class DiscordanceMatrixProcessor extends AbstractThresholdMatrixProcessor{

    @Override
    public double[][] process(double[][] m) {
        double max = 0;
        double max2 = 0;
        double[][] discordanceMatrix = new double[m.length][m.length];
        for (int i = 0; i < m.length;i++) {
            for (int j = 0; j < m.length;j++) {
                max = 0;
                max2 = 0;
                if (i != j) {
                    for (int k = 0; k < m[0].length; k++) {
                         double subs = Math.abs(Math.abs(m[i][k]) - Math.abs(m[j][k]));
                        if (m[i][k] < m[j][k]) {
                           if (subs > max) {
                                max = subs;
                            }
                        }else{
                             if (subs > max2) {
                                max2 = subs;
                            }
                        }
                    }
                discordanceMatrix[i][j] = max/max2;
                }
                
            }
        }
        return discordanceMatrix;
    }



}
