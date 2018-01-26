/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.graphs.directed;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ritesh
 */
public class SymbolTableGraph {
    Map<String, Integer> st;
    String[] keys;
    DiGraph g;
    public SymbolTableGraph(int V){
        st = new HashMap<>();
        keys = new String[V];
        g = new DiGraph(V);
    }
    public void add(String key){
        keys[st.size()] = key;
        st.put(key, st.size());
    }
    public boolean contains(String s){
        return st.containsKey(s);
    }
    public int index(String s){
        return st.get(s);
    }
    public String name(int index){
        return keys[index];
    }
    public DiGraph G(){
        return g;
    }
    
    public static void main(String[] args) {
        SymbolTableGraph sg = new SymbolTableGraph(6);
        sg.add("zero");
        sg.add("one");
        sg.add("two");
        sg.add("three");
        sg.add("four");
        sg.add("five");
        
        DiGraph g3 = sg.G();
        g3.addEdge(sg.index("zero"), sg.index("one"));
        g3.addEdge(sg.index("one"), sg.index("two"));
        g3.addEdge(sg.index("zero"), sg.index("two"));
        g3.addEdge(sg.index("three"), sg.index("four"));
        g3.addEdge(sg.index("four"), sg.index("five"));
        g3.addEdge(sg.index("three"), sg.index("five"));
        g3.addEdge(sg.index("three"), sg.index("zero"));
        SCC ts2 = new SCC(g3);
        StringBuilder sb = new StringBuilder("SCC code is : ");
        for (int i = 0; i < 6; i++) {
            sb.append("\n").append(sg.name(i)).append(":").append(ts2.scc[i]);
        }
        System.out.println(sb.toString());
        System.out.println(ts2.toString());
    }
}
