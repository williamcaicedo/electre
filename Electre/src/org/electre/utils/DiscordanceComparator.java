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

    
    @Override
    public double compare(double x, double threshold) {
        return (x < threshold)?1:0;
    }

}
