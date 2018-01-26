/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.graphs.directed;

import algos.graphs.api.GraphAPI;

/**
 *
 * @author Ritesh
 */
public class DiGraph extends GraphAPI{

    private int E = 0;

    public DiGraph(int V) {
        super(V);
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].enqueue(w);
        E++;
    }

    public int E() {
        return this.E;
    }

    public DiGraph reverse() {
        DiGraph g = new DiGraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                g.addEdge(w, v);
            }
        }
        return g;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DiGraph V : Edges");
        for (int v = 0; v < V; v++) {
            sb.append("\n\t");
            sb.append(v).append(" : [");
            for (int w : adj(v)) {
                sb.append(w).append("->");
            }
            sb.append("]");
            if (sb.charAt(sb.length() - 2) == '>') {
                sb.delete(sb.length() - 3, sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
