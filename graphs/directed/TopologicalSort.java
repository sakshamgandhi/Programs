/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.graphs.directed;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author Ritesh
 */
public class TopologicalSort {

    DiGraph g;
    boolean[] marked;
    Stack<Integer> reverseOrder;

    public TopologicalSort(DiGraph g) {
        this.g = g;
        reverseOrder = new Stack<>();
        marked = new boolean[g.V()];
        for (int s = 0; s < g.V(); s++) {
            if (!marked[s]) dfs(g, s);
        }
    }

    private void dfs(DiGraph g, int s) {
        marked[s] = true;
        for (int v : g.adj(s)) {
            if (!marked[v]) {
                dfs(g, v);
            }
        }
        reverseOrder.push(s);
    }

    @Override
    public String toString() {
        Iterator<Integer> ite = reverseOrder.iterator();
        StringBuilder sb = new StringBuilder("Topological order = ");
        while (ite.hasNext()) {
            sb.append(ite.next()).append("->");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

}
