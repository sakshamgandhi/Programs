
//CodELLECT Solution

import java.io.*;
import java.util.*;
public class Solution{
    
class Node {
    int key;
    Node right;
    Node left;
    int N;

    public Node (int key) {
	this.key = key;
	this.left = null;
	this.right = null;
	this.N = 1;
    }
}
    private Node root;
    
    private int sizeof (Node n) {
	if (n == null) return 0;
	else return n.N;
    }

    public void insert (int key) {
	root = insert (root, key);
    }

    private Node insert (Node n, int key) {
	if (n == null) return new Node (key);
	else if (key < n.key) n.left = insert (n.left, key);
	else if (key > n.key) n.right = insert (n.right, key);
	else {}
	n.N = 1 + sizeof (n.left) + sizeof (n.right);
	return n;
    }

    public int getRank (int key) {
	if (search (root, key)) return getRank (root, key);
	return -1;
    }

    private boolean search (Node n, int key) {
	if (n == null) return false;
	if (key < n.key) return search (n.left, key);
	else if (key > n.key) return search (n.right, key);
	else {
	    return true;
	}
    }
    
    private int getRank (Node n, int key) {
	if (key == n.key) return sizeof (n.left);
	else if (key < n.key) return getRank (n.left, key);
	else {
	    return 1 + sizeof (n.left) + getRank (n.right, key);
	}

}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Solution s = new Solution ();
		for (int i = 0; i < N; i++) {
		    s.insert (sc.nextInt ());
		}
		N = sc.nextInt ();
		for (int i = 0; i < N; i += 1) {
		    System.out.println (s.getRank (sc.nextInt ()));
		}
		
	}
}
