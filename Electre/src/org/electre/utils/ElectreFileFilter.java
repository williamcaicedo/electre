/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.utils;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author william
 */
public class ElectreFileFilter extends FileFilter{

    public boolean accept(File pathname) {
        if (pathname.isDirectory()) {
            return true;
        }
        if (pathname.getName().indexOf(".electre") != -1) {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Archivos de JElectre";
    }

}
