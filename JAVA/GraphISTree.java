
// IS graph Tree??

import java.io.*;
import java.util.*;
public class Solution{
    private LinkedList <Integer> [] adjancyList;
    private boolean [] marked;
    int vertices;
    int edges;
    boolean isCycle;

    @SuppressWarnings ("unchecked")
    public Solution (int vertices) {
	this.vertices = vertices;
	this.adjancyList = new LinkedList [vertices];
	for (int i = 0; i < vertices; i += 1) this.adjancyList [i] = new LinkedList <Integer> ();
	this.marked = new boolean [vertices];
	this.edges = 0;
    }

    public void addEdge (int v1, int v2) {
    this.adjancyList[v2].add (v1);
    this.adjancyList[v1].add (v2);
	this.edges += 1;
    }

    public Iterable <Integer> graphIterator (int vertice) {
	return this.adjancyList[vertice];
    }

    public boolean ccycle () {
	dfs (0, -1);
    for (int i = 0; i < this.vertices; i += 1) {
        if (this.marked[i] == false) return true;
    }
	return this.isCycle;
    }
    
    private void dfs (int v, int p) {
        this.marked[v] = true;
        for (int i : this.graphIterator(v)) {
            if (!this.marked[i]) {
                dfs (i,v);
            }
            else {
                if (i != p)isCycle = true;
            }
        }
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
	    System.out.println (!S.ccycle ());
	    N -= 1;
	}
    }
}
