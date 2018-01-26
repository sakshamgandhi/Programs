/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.graphs.directed;

import java.util.Stack;

/**
 *
 * @author Ritesh
 */
public class SCC {

    DiGraph g;
    boolean[] marked;
    int[] scc;
    int count;

    public SCC(DiGraph g) {
        this.g = g;
        marked = new boolean[g.V()];
        scc = new int[g.V()];
        TopologicalSort tp = new TopologicalSort(g.reverse());
        System.out.println(tp.toString());
        Stack<Integer> s = tp.reverseOrder;
        while(!s.empty()){
            int i = s.pop();
          //  System.out.println(i);
            if (!marked[i]) {
                dfs(g, i);
                count++;
            }
        }
//        for (int i : tp.reverseOrder) {
//            System.out.println(i);
//            if (!marked[i]) {
//                dfs(g, i);
//                count++;
//            }
//        }
    }

    private void dfs(DiGraph g, int i) {
        marked[i] = true;
        scc[i] = count;
        for (int v : g.adj(i)) {
            if(!marked[v]) dfs(g, v);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SCC code is : ");
        for (int i = 0; i < g.V(); i++) {
            sb.append("\n").append(i).append(":").append(scc[i]);
        }
        return sb.toString();
    }
}
