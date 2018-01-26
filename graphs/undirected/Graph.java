package algos.graphs.undirected;

import algos.graphs.api.GraphAPI;

public class Graph extends GraphAPI {

    public Graph(int V) {
        super(V);
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].enqueue(w);
        adj[w].enqueue(v);
    }
}
