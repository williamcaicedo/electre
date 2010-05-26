/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.utils;

/**
 *
 * @author william
 */
public class DiscordanceComparator extends AbstractComparator{

    public DiscordanceComparator(ComparatorPolicy policy) {
        super(policy);
    }

    @Override
    public double compare(double x, double threshold) {
        return (x < threshold)?1:0;
    }

}
