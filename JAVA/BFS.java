import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    int v;
    int e;
    LinkedList <Integer> [] adj;
    boolean[] marked;

    @SuppressWarnings ("unchecked")
    BFS (int v) {
	this.v = v;
	this.adj = new LinkedList [v];
	for (int i = 0; i < v; i += 1) {
	    this.adj[i] = new LinkedList <Integer> ();
	}
	this.marked = new boolean[v];
    }

    public void addEdge (int v1, int v2) {
	this.adj[v1].add (v2);
	if (v1 != v2) this.adj[v2].add (v1);
	this.e += 1;
    }

    public Iterable <Integer> gItr (int v1) {
	return this.adj[v1];
    }

    public boolean bSearch (int v1, int v2) {
	markferFunc (v1);
	return this.marked[v2];
    }

    private void markferFunc (int v1) {
	Queue <Integer> q = new LinkedList <Integer> ();
	q.add (v1);
	this.marked[v1] = true;

	while (!q.isEmpty ()) {
	    int tmp = q.poll ();
	    for (int i : this.gItr (tmp)) {
		if (!this.marked[i]) {
		    q.add (i);
		    this.marked[i] = true;
		}
	    }
	}
    }

    public static void main (String[] args) {
	BFS g = new BFS (6);
	g.addEdge (0, 4); g.addEdge (0, 5);
	g.addEdge (4, 1); g.addEdge (1, 5);
	g.addEdge (2, 3);
	g.addEdge (1, 1);
	System.out.println (g.bSearch (0, 2));
    }

}
