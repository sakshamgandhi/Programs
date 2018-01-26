import java.util.LinkedList;

public class DFS {
    int v;
    int e;
    LinkedList <Integer> [] adj;
    boolean[] marked;
    
    @SuppressWarnings ("unchecked")
    DFS (int v) {
	this.v = v;
	this.adj = new LinkedList[v];
	for (int i = 0; i < v; i += 1) {
	    this.adj[i] = new LinkedList <Integer> ();
	}
	this.marked = new boolean[v];
	this.e = 0;
    }

    public void addEdge (int v1, int v2) {
	this.adj[v1].add (v2);
	if (v1 != v2) this.adj[v2].add (v2);
	this.e += 1;
    }

    public Iterable <Integer> gItr (int v1) {
	return this.adj[v1];
    }

    public boolean depthSearch (int v1, int v2) {
	markerFunc (v1);
	return marked[v2];
    }

    private void markerFunc (int v1) {
	this.marked[v1] = true;
	for (int i : this.gItr(v1)) {
	    if (!this.marked[i]) {
		markerFunc (i);
	    }
	}
    }

    public static void main (String[] args) {
	DFS g = new DFS (6);
	g.addEdge (0, 4); g.addEdge (0, 5);
	g.addEdge (4, 1); g.addEdge (1, 5);
	g.addEdge (2, 3);
	g.addEdge (1, 1);
	System.out.println (g.depthSearch (0, 2));
    }
}
