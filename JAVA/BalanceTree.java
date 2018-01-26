import java.io.*;
import java.util.Arrays;

class Node {
    int key;
    Node right;
    Node left;
    int N;

    public Node (int key) {
	this.key = key;
	this.right = null;
	this.left = null;
	this.N = 1;
    }
}

public class BalanceTree {
    
    private Node root;
    //
    // Insertion of key and Size
    //

    public void insert (int key) {
	root = insert (root, key);
    }

    private Node insert (Node n, int key) {
	if (n == null) return new Node (key);
	if (key < n.key) n.left = insert (n.left, key);
	else if (key > n.key) n.right = insert (n.right, key);
	else {}

	n.N = 1 + sizeof (n.left) + sizeof (n.right);
	return n;
    }

    private int sizeof (Node n) {
	if (n == null) return 0;
	else return n.N;
    }

    //
    // Generation of balance tree
    //

    public void generate () {
	int[] a  = {6, 3, 1, 5, 2, 4, 7};
	Arrays.sort (a);
	
	balance (a, 0, a.length - 1);
    }

    private void balance (int[] a, int l, int r) {
	if (l <= r) {
	    int m = (l + r) / 2;
	    System.out.println (a[m]);
	    insert (a[m]);
	    balance (a, l, m - 1);
	    balance (a, m + 1, r);
	}
    }

    public static void main (String[] args) {
	BalanceTree b = new BalanceTree ();
	b.generate ();
    }
}
