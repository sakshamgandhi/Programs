/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.graphs.directed;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Ritesh
 */
public class BFS {

    DiGraph g;
    int s;
    boolean[] marked;
    int[] edgeTo;

    public BFS(DiGraph g, int s) {
        this.g = g;
        this.s = s;
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        bfs(g, s);
    }

    private void bfs(DiGraph g, int s) {
        marked[s] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()) {
            int w = q.poll();
            for (int v : g.adj(w)) {
                if (!marked[v]) {
                    q.add(v);
                    marked[v] = true;
                    edgeTo[v] = w;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("BFS =\tvertex  : \tMarked  : \tEdgeTo");
        for (int v = 0; v < g.V(); v++) {
            sb.append("\n\t");
            sb.append(v).append("\t: \t").append(marked[v]).append("\t: \t").append(edgeTo[v]);
        }
        return sb.toString();

    }

}
