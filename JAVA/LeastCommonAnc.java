
//CodEllect Solution

import java.io.*;
import java.util.*;
public class Solution{
    class Node {
    int key;
    Node right;
    Node left;

    public Node (int key) {
	this.key = key;
	this.left = null;
	this.right = null;
    }
    }
    private Node root;
    

    public void insert (int key) {
	root = insert (root, key);
    }

    private Node insert (Node n, int key) {
	if (n == null) return new Node (key);
	else if (key < n.key) n.left = insert (n.left, key);
	else if (key > n.key) n.right = insert (n.right, key);
	else {}
	return n;
    }

    public int lca (int l, int r) {
        if (l == root.key || r == root.key) return -1;
        Node n = lca (root, l, r, null);
        if (n == null) return -1;
        else return n.key;
    }
    
    private Node lca (Node n, int l, int r, Node parent) {
        if (n == null) return n;
        if (n.key == l || n.key == r) return parent;
        Node left = lca (n.left, l, r, n);
        Node right = lca (n.right, l, r, n);
        if (left != null && right != null) return n;
        else if (left != null) return left;
        else return right;
    } 

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Solution s = new Solution ();
		for (int i = 0; i < N; i++) {
		    s.insert (sc.nextInt ());
		}
		N = sc.nextInt();
		for (int i = 0; i < N; i += 1) {
		    System.out.println (s.lca (sc.nextInt (), sc.nextInt()));
		}
	}
}
