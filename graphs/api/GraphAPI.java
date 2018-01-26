package algos.graphs.api;

import java.util.Iterator;

public abstract class GraphAPI {

    protected int V;
    protected Bag[] adj;

    public GraphAPI(int V) {
        this.V = V;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag();
        }
    }

    protected abstract void addEdge(int v, int w);

    public int V() {
        return V;
    }

    public int[] adj(int v) {
        int[] data = new int[adj[v].size()];
        int i = 0;
        Iterator<Integer> ite = adjIterator(v);
        while (ite.hasNext()) {
            data[i++] = ite.next();
        }
        return data;
    }

    protected Iterator<Integer> adjIterator(int v) {
        return this.adj[v].iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Graph V : Edges");
        for (int v = 0; v < V; v++) {
            sb.append("\n\t");
            sb.append(v).append(" : [");
            for (int w : adj(v)) {
                sb.append(w).append("->");
            }
            sb.append("]");
            if (sb.charAt(sb.length() - 2) == '>') {
                sb.delete(sb.length() - 3, sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
