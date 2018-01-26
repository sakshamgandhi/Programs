/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.graphs.undirected;

/**
 *
 * @author Ritesh
 */
public class CC {

    private final int[] cc;
    private final boolean[] marked;
    private int count;

    public CC(Graph g) {
        cc = new int[g.V()];
        marked = new boolean[g.V()];
        for (int s = 0; s < g.V(); s++) {
            if (!marked[s]) {
                dfs(g, s);
                count++;
            }
        }
    }

    private void dfs(Graph g, int s) {
        marked[s] = true;
        cc[s] = count;
        for (int v : g.adj(s)) {
            if (!marked[v]) {
                dfs(g, v);
            }
        }
    }

    public int[] getCc() {
        return cc;
    }

    public static void main(String[] args) {
        Graph g = new Graph(13);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 5);
        g.addEdge(0, 6);
        g.addEdge(5, 3);
        g.addEdge(5, 4);
        g.addEdge(4, 3);
        g.addEdge(4, 6);
        g.addEdge(7, 8);
        g.addEdge(9, 10);
        g.addEdge(9, 11);
        g.addEdge(9, 12);
        g.addEdge(11, 12);
        CC cc = new CC(g);
        int[] ccArray = cc.getCc();
        for (int i = 0; i < 13; i++) {
            System.out.println(ccArray[i]);
        }
    }

}
