import java.io.*;

public class Trie {
    
    private class TrieNode {
    Integer value;
    TrieNode[] nodes = new TrieNode[26];
    }
    
    TrieNode root;
    public Trie () {
        root = new TrieNode ();
    }
    
    public void insert (String w, Integer v)   {
        TrieNode p = root;
        for (int i = 0; i < w.length (); i += 1) {
            int index = w.charAt (i) - 'a';
            if (p.nodes [index] == null) p.nodes[index] = new TrieNode ();
             p = p.nodes[index];
        }
        p.value = v;
    }
    
    public Integer search (String w) {
        TrieNode p = searchNode (w);
         if (p == null) return null;
        return p.value;
        
    }
    
    private TrieNode searchNode (String w) {
        TrieNode p = root;
        for (int i = 0; i < w.length (); i += 1) {
            int index = w.charAt (i) - 'a';
            if (p.nodes [index] == null) return null;
             p = p.nodes[index];
        }
        return p;
    }
    
    public boolean startwith (String w) {
        TrieNode p = searchNode (w);
        return p != null;
    }
    
    public void Softdelete (String w) {
        TrieNode p = root;
        for (int i = 0; i < w.length (); i += 1) {
            int index = w.charAt (i) - 'a';
             p = p.nodes[index];
        }
        p.value = null;
    }
    
    public void Harddelete (String w) {
       boolean b = hdel (root, w, 0);
    }
    
    private boolean hdel (TrieNode p, String w, int l) {
        if (p == null) return false;
        if (l == w.length ()) {
            if (hasChild (p)) {
                p.value = null;
                return false;
            }
            return true;
        }
        int index = w.charAt (l) - 'a';
        if (hdel (p.nodes[index], w, l + 1)) {
            p.nodes[index] = null;
            if (hasChild (p)) return false;
            else return true;
        }
        return false;
    }
    
    private boolean hasChild (TrieNode p) {
        for (int i = 0; i < 26; i += 1) {
            if (p.nodes[i] != null) return true;        
        }
        return false;
    }
    
    public void printAll () {
        printAll (root, "");    
    }

    private void printAll (TrieNode t, String s) {
        if (t == null) return; 
        if (t.value != null) System.out.println (s);
        for (int i = 0; i < 26; i += 1) {
            int tmp = i + 'a';
            if (t.nodes [i] != null) {
                s += (char) tmp;
                printAll (t.nodes [i], s);
                s = "";   
            }           
        }    
    }

    public static void main (String[] args) {
        Trie t = new Trie ();
        t.insert ("abc", 100);
        t.insert ("bcd", 100);
        t.insert ("abcd", 100);
        t.insert ("ab", 100);
        //t.Harddelete ("abc");
        System.out.println (t.search ("abcd"));
        t.printAll ();
    }
}
