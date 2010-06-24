/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.electre.core.Atributo;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author william
 */
public class ElectreSAXHandler extends DefaultHandler{
    private String attributeName;
    private boolean isWeight;
    private boolean isPositive;
    private double weight;
    private boolean positive;
    private List<Atributo> attributes = new ArrayList<Atributo>();
    private Vector<String> row;
    private Vector<Vector<String>> matrix = new Vector<Vector<String>>();
    //private double cellValue;
     @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
       if ("attribute".equals(qName)) {
           this.attributeName = attrs.getValue("name");
       }
       if ("attribute-weight".equals(qName)) {
           this.isWeight = true;
       }
       if ("attribute-positive".equals(qName)) {
           this.isPositive = true;
       }
       if ("row".equals(qName)) {
           this.row = new Vector<String>();
       }
        if ("column".equals(qName)) {
           //double cellValue = Double.parseDouble(attrs.getValue("value"));
           this.row.add(attrs.getValue("value"));
       }



    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("attribute".equals(qName)) {
            this.attributes.add(new Atributo(this.attributeName,this.positive,this.weight));
            
        }
        if ("attribute-weight".equals(qName)) {
            this.isWeight = false;
        }
        if ("attribute-positive".equals(qName)) {
           this.isPositive = false;
       }
        if ("row".equals(qName)) {
           this.matrix.add(this.row);
        }
        if ("decisionMatrix".equals(qName)) {

        }


    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(this.isWeight) {
            this.weight = Double.parseDouble(new String(ch,start,length));
        }
        if(this.isPositive) {
            this.positive = Boolean.parseBoolean(new String(ch,start,length));
        }

    }

    public List<Atributo> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Atributo> attributes) {
        this.attributes = attributes;
    }

    public Vector<Vector<String>> getMatrix() {
        return matrix;
    }

    public void setMatrix(Vector<Vector<String>> matrix) {
        this.matrix = matrix;
    }
    /*
    public double[][] getDecisionMatrix() {
        double[][] decisionMatrix = new double[this.matrix.size()][this.matrix.get(0).size()];
        for(int i = 0; i < this.matrix.size(); i++){
            for(int j = 0; j < this.matrix.get(0).size(); j++){
                decisionMatrix[i][j] = this.matrix.get(i).get(j);
            }
        }
    }
    */

}

