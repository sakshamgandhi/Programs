/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.graphs.directed;

/**
 *
 * @author Ritesh
 */
public class DFS {

    DiGraph g;
    int s;
    boolean[] marked;
    int[] edgeTo;

    public DFS(DiGraph g, int s) {
        this.g = g;
        this.s = s;
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        dfs(g, s);
    }

    private void dfs(DiGraph g, int s) {
        marked[s] = true;
        for (int v : g.adj(s)) {
            if (!marked[v]) {
                dfs(g, v);
                edgeTo[v] = s;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DFS =\tvertex  : \tMarked  : \tEdgeTo");
        for (int v = 0; v < g.V(); v++) {
            sb.append("\n\t");
            sb.append(v).append("\t: \t").append(marked[v]).append("\t: \t").append(edgeTo[v]);
        }
        return sb.toString();

    }
}
