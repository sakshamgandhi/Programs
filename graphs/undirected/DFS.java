package algos.graphs.undirected;

public class DFS {

    public boolean[] marked;

    public DFS(Graph g, int s) {
        marked = new boolean[g.V()];
        dfs(g, s);
    }

    private void dfs(Graph g, int s) {

        marked[s] = true;
        for (int x : g.adj(s)) {
            if (marked[x] == false) {
                dfs(g, x);
            }
        }

    }
}
