package algos.graphs.undirected;

import algos.ds.Queue;

public class BFS {
    public boolean[] marked;
    public int[] edge;

    public BFS(Graph g, int s) {
        marked = new boolean[g.V()];
        edge = new int[g.V()];
        bfs(g, s);
    }

    private void bfs(Graph g, int s) {

        Queue<Integer> q = new Queue<>();
        q.enqueue(s);
        while (!q.isEmpty()) {
            int x = q.dequeue();
            marked[x] = true;
            for (int y : g.adj(x)) {
                if (marked[y] == false) {
                    marked[y] = true;
                    edge[y] = x;
                    q.enqueue(y);
                }
            }
        }
    }
}
