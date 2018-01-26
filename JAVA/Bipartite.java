import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    private LinkedList <Integer> [] adjancyList;
    private boolean [] marked;
    private boolean [] color;
    int vertices;
    int edges;
    boolean isBip;

    public Bipartite (int vertices) {
	this.vertices = vertices;
	this.adjancyList = new LinkedList [vertices];
	for (int i = 0; i < vertices; i += 1) this.adjancyList [i] = new LinkedList <Integer> ();
	this.marked = new boolean [vertices];
	this.color = new boolean [vertices];
	this.edges = 0;
	this.isBip = true;
    }

    public void addEdge (int v1, int v2) {
	this.adjancyList[v1].add (v2);
	if (v1 != v2) this.adjancyList[v2].add (v1);
	this.edges += 1;
    }

    public Iterable <Integer> graphIterator (int vertice) {
	return this.adjancyList[vertice];
    }

    public boolean bip () {
	this.color[0] = true;
	dfs (0);
	return this.isBip;
    }

    private void dfs (int v) {
	this.marked[v] = true;
	for (int i : this.graphIterator (v)) {
	    if (!this.marked[i]) {
		this.color[i] =  !this.color[v];
		dfs (i);
	    }
	    else {
		if (this.color[i] == this.color[v]) isBip = false;
	    }
	}
    }

    public static void main (String[] args) {
	Bipartite c = new Bipartite (5);
	c.addEdge (0, 1);
	c.addEdge (0, 2);
	c.addEdge (0, 3);
	c.addEdge (1, 4);
	c.addEdge (2, 4);
	c.addEdge (3, 4);

	System.out.println (c.bip ());
    }
}
