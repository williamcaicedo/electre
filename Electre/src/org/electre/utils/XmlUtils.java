/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import org.electre.core.Atributo;

/**
 *
 * @author william
 */
public class XmlUtils {

    public static void programToXML(MyTableModel model, List<Atributo> atributos, String programName) {
        StringBuffer sb = new StringBuffer();
        String sep = System.getProperty("line.separator");
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append(sep);
        sb.append("<electre-program>");
        sb.append(sep);
        for (Atributo a : atributos) {
            sb.append("<attribute name='"+a.getNombre()+"'>");
            sb.append(sep);
            sb.append("<attribute-weight>"+a.getPeso()+"</attribute-weight>");
            sb.append(sep);
            sb.append("<attribute-positive>"+a.isPositivo()+"</attribute-positive>");
            sb.append(sep);
            sb.append("</attribute>");
            sb.append(sep);
        }
        sb.append("<decisionMatrix>");
        sb.append(sep);
        for (Vector<String> row : (Vector<Vector<String>>)model.getDataVector()) {
            sb.append("<row>");
            sb.append(sep);
            for (Object col : row) {
                sb.append("<column value ='"+col+"'/>");
                sb.append(sep);
            }
            sb.append("</row>");
            sb.append(sep);
        }
        sb.append("</decisionMatrix>");
        sb.append(sep);
        sb.append("</electre-program>");
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(new File(programName + ".electre")));
            bf.write(sb.toString());
            bf.close();
        } catch (IOException ex) {

        }

    }

    

}
