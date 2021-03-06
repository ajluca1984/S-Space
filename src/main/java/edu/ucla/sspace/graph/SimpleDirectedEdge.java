/*
 * Copyright 2011 David Jurgens
 *
 * This file is part of the S-Space package and is covered under the terms and
 * conditions therein.
 *
 * The S-Space package is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation and distributed hereunder to you.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS" AND NO REPRESENTATIONS OR WARRANTIES,
 * EXPRESS OR IMPLIED ARE MADE.  BY WAY OF EXAMPLE, BUT NOT LIMITATION, WE MAKE
 * NO REPRESENTATIONS OR WARRANTIES OF MERCHANT- ABILITY OR FITNESS FOR ANY
 * PARTICULAR PURPOSE OR THAT THE USE OF THE LICENSED SOFTWARE OR DOCUMENTATION
 * WILL NOT INFRINGE ANY THIRD PARTY PATENTS, COPYRIGHTS, TRADEMARKS OR OTHER
 * RIGHTS.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package edu.ucla.sspace.graph;

/**
 * An implementation of {@link DirectedEdge}
 */
public class SimpleDirectedEdge implements DirectedEdge, java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private final int from;

    private final int to;

    public SimpleDirectedEdge(int from, int to) {
        this.from = from;
        this.to = to;
    }
    
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public <T extends Edge> T clone(int from, int to) {
        return (T)(new SimpleDirectedEdge(from, to));
    }   

    /**
     * Returns {@code true} if {@code o} is an {@link Edge} whose vertices are
     * oriented in the same way as this edge.  That is, the from and to vertices
     * are identical.
     */
    public boolean equals(Object o) {
        if (o instanceof Edge) {
            Edge e = (Edge)o;
            return e.from() == from && e.to() == to;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return from ^ to;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public <U extends Edge> U flip() {
        return (U)(new SimpleDirectedEdge(to, from));
    }

    /**
     * {@inheritDoc}
     */
    public int from() {
        return from;
    }

    /**
     * {@inheritDoc}
     */
    public int to() { 
        return to;
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return "(" + from + "->" + to + ")";
    }
}