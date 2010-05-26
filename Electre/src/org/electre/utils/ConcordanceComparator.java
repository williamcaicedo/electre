/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.utils;

/**
 *
 * @author william
 */
public class ConcordanceComparator extends AbstractComparator{

    public ConcordanceComparator(ComparatorPolicy policy) {
        super(policy);
    }

    @Override
    public double compare(double x, double threshold) {
        return (x > threshold)?1:0;
    }

}
