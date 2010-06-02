/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.utils;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author william
 */
public class MyTableModel extends DefaultTableModel{

    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }
    public MyTableModel() {

    }

}
