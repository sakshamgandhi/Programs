/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.graphs.undirected;

import org.junit.Assert;

/**
 *
 * @author Ritesh_Ranjan
 */
public class GraphTest {

    public static void main(String... args) throws Exception {
        Graph g = new Graph(8);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 7);
        g.addEdge(7, 4);
        g.addEdge(3, 4);
        g.addEdge(5, 6);
        
        System.out.println(g.toString());
        
        DFS dfs = new DFS(g,1);
       // dfs.dfs(1);

        Assert.assertTrue(dfs.marked[2]);
        Assert.assertTrue(dfs.marked[3]);
        Assert.assertTrue(dfs.marked[4]);
        Assert.assertTrue(dfs.marked[7]);
        Assert.assertFalse(dfs.marked[5]);
        Assert.assertFalse(dfs.marked[6]);


        BFS bfs = new BFS(g,1);
        //bfs.bfs(1);
        Assert.assertTrue(bfs.marked[2]);
        Assert.assertTrue(bfs.marked[3]);
        Assert.assertTrue(bfs.marked[4]);
        Assert.assertTrue(bfs.marked[7]);
        Assert.assertFalse(bfs.marked[5]);
        Assert.assertFalse(bfs.marked[6]);

        for (int i = 1; i < 8; i++) {
            if (!bfs.marked[i]) {
                System.out.println("No parth from 1 to " + i);
                Assert.assertTrue(i == 5 || i == 6);
                continue;
            }
            System.out.print("path from 1 to " + i + " : ");
            int j = i;
            int ctr = 0;
            while (j > 1) {
                System.out.print(j + "-");
                j = bfs.edge[j];
                ctr++;
            }
            if (i == 3 || i == 2) {
                Assert.assertEquals(ctr, 1);
            }
            if (i == 4 || i == 7) {
                Assert.assertEquals(ctr, 2);
            }
            if (i == 1) {
                Assert.assertEquals(ctr, 0);
            }
            System.out.println("1 shorted distance calculated = " + ctr);
        }




    }
}
