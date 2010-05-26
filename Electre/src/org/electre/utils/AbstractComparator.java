/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.utils;

/**
 *
 * @author william
 */
public abstract class AbstractComparator {

    protected final ComparatorPolicy policy;

    public AbstractComparator(ComparatorPolicy policy) {
        this.policy = policy;
    }

    public abstract double compare(double x, double threshold);
}
