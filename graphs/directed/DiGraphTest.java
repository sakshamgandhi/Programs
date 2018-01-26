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
public class DiGraphTest {

    public static void main(String[] args) {
        DiGraph g = new DiGraph(13);
        g.addEdge(0, 1);
        g.addEdge(0, 5);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 2);
        g.addEdge(3, 5);
        g.addEdge(4, 2);
        g.addEdge(4, 3);
        g.addEdge(5, 4);
        g.addEdge(6, 0);
        g.addEdge(6, 4);
        g.addEdge(6, 9);
        g.addEdge(6, 8);
        g.addEdge(7, 9);
        g.addEdge(7, 6);
        g.addEdge(8, 6);
        g.addEdge(9, 10);
        g.addEdge(9, 11);
        g.addEdge(10, 12);
        g.addEdge(11, 4);
        g.addEdge(11, 12);
        g.addEdge(12, 9);
        System.out.println(g.toString());
        
        DFS dfs = new DFS(g,0);
        System.out.println(dfs.toString());
        
        BFS bfs = new BFS(g,0);
        System.out.println(bfs.toString());
        
        DiGraph g2 = new DiGraph(7);
        
        g2.addEdge(0,5);
        g2.addEdge(0,1);
        g2.addEdge(3,5);
        g2.addEdge(5,2);
        g2.addEdge(6,0);
        g2.addEdge(1,4);
        g2.addEdge(0,2);
        g2.addEdge(3,6);
        g2.addEdge(3,4);
        g2.addEdge(6,4);
        g2.addEdge(3,2);
        TopologicalSort ts = new TopologicalSort(g2);
        System.out.println(ts.toString());
        
        DiGraph g3 = new DiGraph(6);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(3, 4);
        g3.addEdge(4, 5);
        g3.addEdge(5, 3);
        g3.addEdge(0, 3);
        System.out.println("--------------------------");
        SCC ts2 = new SCC(g3);
        System.out.println(ts2.toString());
    }
}
