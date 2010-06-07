/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.utils;

import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author william
 */
public class TableUtils {

    public static DefaultTableModel arrayToDefaultTableModel(double[][] m) {
        DefaultTableModel dm = new DefaultTableModel();
        DecimalFormat df = new DecimalFormat("0.000");
        Vector rowVector;
        for (int i = 1; i <= m[0].length; i++) {
            dm.addColumn(i);
        }
        for(double[] row : m) {
            rowVector = new Vector();
            for(double v : row) {
                rowVector.add(df.format(v));
            }
            dm.addRow(rowVector);
        }
        return dm;
    }

}
