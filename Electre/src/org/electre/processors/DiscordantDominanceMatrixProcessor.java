/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.processors;

import org.electre.utils.DiscordanceComparator;

/**
 *
 * @author william
 */
public class DiscordantDominanceMatrixProcessor extends AbstractDominanceMatrixProcessor{

    public DiscordantDominanceMatrixProcessor(DiscordanceComparator comparator, double threshold) {
        super(comparator, threshold);
    }


}
