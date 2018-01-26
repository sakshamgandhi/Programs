import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class ShortestPath {
    int v;
    int e;
    LinkedList <Integer> [] adj;
    boolean[] marked;
    int[] distances;

    @SuppressWarnings ("unchecked")
    ShortestPath (int v) {
	this.v = v;
	this.adj = new LinkedList [v];
	for (int i = 0; i < v; i += 1) {
	    this.adj[i] = new LinkedList <Integer> ();
	}
	this.marked = new boolean[v];
	this.distances = new int[v];
    }

    public void addEdge (int v1, int v2) {
	this.adj[v1].add (v2);
	if (v1 != v2) this.adj[v2].add (v1);
	this.e += 1;
    }

    public Iterable <Integer> gItr (int v1) {
	return this.adj[v1];
    }

    public int pathfinder (int v1, int v2) {
	Arrays.fill(this.distances, -1);
	pathfinder (v1);
	return this.distances[v2];
    }

    private void pathfinder (int v1) {
	Queue <Integer> q = new LinkedList <Integer> ();
	q.add (v1);
	this.distances[v1] = 0;
	this.marked[v1] = true;

	while (!q.isEmpty ()) {
	    int tmp = q.poll ();
	    for (int i : this.gItr (tmp)) {
		if (!this.marked[i]) {
		    this.distances[i] = this.distances[tmp] + 1;
		    //Assuming edgeLength = 1
		    q.add (i);
		    this.marked[i] = true;
		}
	    }
	}
    }

    public static void main (String[] args) {
	ShortestPath g = new ShortestPath (6);
	g.addEdge (0, 4); g.addEdge (0, 5);
	g.addEdge (4, 2); g.addEdge (1, 5);
	g.addEdge (2, 3);
	g.addEdge (2, 1);
	System.out.println (g.pathfinder (0, 5));
    }

}
