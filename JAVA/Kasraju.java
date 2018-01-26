import java.util.LinkedList;
import java.util.Stack;

public class Kasraju {
    int v;
    int e;
    LinkedList <Integer> [] adj;
    boolean [] marked;
    Stack <Integer> s;
    
    
    Kasraju (int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i += 1) this.adj[i] = new LinkedList <> ();
        this.marked = new boolean[v];
        this.s = new Stack <> ();
        this.e = 0;
    }
    
    public void addEdge (int v1, int v2) {
        this.adj[v1].add (v2);
        this.e += 1;
    }
    
    public Iterable <Integer> graphIterator (int v1) {
        return this.adj[v1];
    }
    
    public void dfs (int i) {
        this.marked[i] = true;
        for (int j : this.graphIterator (i)) {
            if (!this.marked[j]) {
                dfs (j);
            }
        }
        this.s.push (i);
    }
    
    static void implementation (Kasraju k) {
        
        //Reverse of Graph
        Kasraju rev = new Kasraju (k.v);
        for (int i = 0; i < k.v; i += 1) {
            for (int j : k.graphIterator (i)) {
                rev.addEdge (j, i);
            }
        }
        
        //Topological Sort
        for (int i = 0; i < rev.v; i += 1) {
            if (!rev.marked[i]) rev.dfs (i);
        }
        
        //Strongly Connected
        int count = 0;
        while (!rev.s.isEmpty ()) {
            int x = rev.s.pop ();
            if (!k.marked[x]) {
                k.dfs (x);
                count += 1;
            }
        }
        
        System.out.println (count);
    }
    
    
    
    public static void main (String[] args) {
        Kasraju k = new Kasraju (6);
        k.addEdge (0, 2);
        k.addEdge (2, 1);
        k.addEdge (1, 0);
        k.addEdge (2, 3);
        k.addEdge (3, 4);
        k.addEdge (4, 5);
        k.addEdge (5, 3);
        
        implementation (k);
    }
}