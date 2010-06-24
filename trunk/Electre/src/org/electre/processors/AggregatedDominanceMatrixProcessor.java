/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.processors;

/**
 *
 * @author william
 */
public class AggregatedDominanceMatrixProcessor {
    private double[][] matrix = null;
    private String analysisText = "";

    public double[][] process(double[][] m1 ,double[][] m2) {
        double[][] resultMatrix = new double[m1.length][m1[0].length];
        for(int i = 0;  i < m1.length; i++) {
            for(int j = 0;  j < m1[0].length; j++) {
                resultMatrix[i][j] = (m1[i][j] == 1 && m2[i][j] == 1)?1:0;
            }
        }
        this.matrix = resultMatrix;
        return resultMatrix;
    }
    public String getMatrixAnalysisText() {
        if (this.matrix != null) {
            if ("".equals(this.analysisText)) {
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                int dominanceCount;
                for (int i = 0; i< matrix.length; i++) {
                    dominanceCount = 0;
                    for (int j =0; j< matrix.length; j++) {
                        if (i != j && matrix[i][j] == 1) {
                            dominanceCount++;
                            sb2.append(j+1+",");
                        }
                    }
                    if (sb2.length() > 0)
                        sb2.setCharAt(sb2.length()-1,')');
                    if (dominanceCount > 0) {
                        int n = i+1;
                        sb.append("La alternativa "+n+" domina "+dominanceCount+" alternativa(s) (");
                        sb.append(sb2.toString());
                        sb.append(". ");
                        sb2 = new StringBuilder();
                    }else{
                        int n = i+1;
                        sb.append("La alternativa "+n+" no domina a ninguna alternativa. ");
                    }
                }
                sb.append("Las alternativas coloreadas en gris pertenecen al núcleo (Conjunto de alternativas que no son dominadas por ninguna otra).");
                this.analysisText =  sb.toString();
           }

            return this.analysisText;
        }else{
            return "";
        }
    }

    


}
