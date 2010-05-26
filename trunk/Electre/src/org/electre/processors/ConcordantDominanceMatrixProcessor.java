/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.processors;

import org.electre.utils.ConcordanceComparator;

/**
 *
 * @author william
 */
public class ConcordantDominanceMatrixProcessor extends AbstractDominanceMatrixProcessor{

    public ConcordantDominanceMatrixProcessor(ConcordanceComparator comparator, double threshold) {
        super(comparator, threshold);

    }
}
