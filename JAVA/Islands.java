
//CodEllect

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {
    int vertices;
    int edges;
    LinkedList <Integer>[] adj;
    boolean[] marked;

    @SuppressWarnings ("unchecked")
    public Solution (int v) {
	this.vertices = v;
	this.adj = new LinkedList [v];
	for (int i = 0; i < v; i += 1) {
	    this.adj[i] = new LinkedList <Integer> ();
	}
	this.edges = 0;
	this.marked = new boolean[v];
    }

    public void addEdge (int v1, int v2) {
	this.adj[v1].add (v2);
	this.adj[v2].add (v1);
	this.edges += 1;
    }

    public Iterable <Integer> graphIterator (int v) {
	return adj[v];
    }

    public int NoIslands () {
	int count = 0;
	Queue <Integer> q = new LinkedList <Integer> ();
	while (allnotMarked ()) {
	    int z = unmarked ();
	    if (z == -1) break;
	    q.add (z);
	    this.marked[z] = true;
	    count += 1;

	    while (!q.isEmpty ()) {
		z = q.poll ();
		for (int i : this.graphIterator (z)) {
		    if (!this.marked[i]) {
		        q.add (i);
		        this.marked[i] = true;
		    }
		}
	    }
	}
	return count;
    }

    private boolean allnotMarked () {
	for (int i = 0; i < this.vertices; i += 1) {
	    if (this.marked[i] == false) return true;
	}
	return false;
    }

    private int unmarked () {
	for (int i = 0; i < this.vertices; i += 1) {
	    if (this.marked[i] == false) return i;
	}
	return -1;
    }

    public static void main (String[] args) {
	Scanner sc = new Scanner (System.in);
	int N = sc.nextInt ();
	while (N > 0) {
	    int a = sc.nextInt ();
	    int b = sc.nextInt ();
	    Solution S = new Solution (a);
	    for (int i = 0; i < b; i += 1) {
	        S.addEdge(sc.nextInt(), sc.nextInt());
	    }
	    System.out.println (S.NoIslands ());
	    N -= 1;
	}
    
}
}
