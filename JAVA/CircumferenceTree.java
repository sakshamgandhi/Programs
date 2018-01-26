import java.io.*;
import java.util.Scanner;

class Node {
    int key;
    Node left;
    Node right;
    int N;

    public Node (int key) {
	this.key = key;
	this.left = null;
	this.right = null;
	this.N = 1;
    }
}

public class CircumferenceTree {

    private Node root;

    public void insert (int key) {
	root = insert (root, key);
    }

    private Node insert (Node n, int key) {
	if (n == null) return new Node (key);
	if (key < n.key) n.left = insert (n.left, key);
	else if (key > n.key) n.right = insert (n.right, key);
	else {}

    n.N = sizeOf (n.left) + sizeOf (n.right) + 1;
	return n;
    }

    private int sizeOf (Node n) {
        if (n == null) return 0;
        else return n.N;    
    }

    public void boundary () {
	leftside (root);                
	middle (root);                 
	rightside (root.right);        
    }

    private void leftside (Node n) {
	if (n.left != null) {
	    System.out.println (n.key);   
	    leftside (n.left);
	}
	else if (n.right != null) {
	    System.out.println (n.key);
	    leftside (n.right);
	}
    } 



    private void middle (Node n) {
	if (n != null) {
	    middle (n.left);
	    middle (n.right);
	    if (n.N == 1) System.out.println (n.key);
	}
    }




    private void rightside (Node n) {
	if (n.right != null) {
	    rightside (n.right);
	    System.out.println (n.key);
	}
	else if (n.left != null) {
	    rightside (n.left);
	    System.out.println (n.key);
	}
    }

    



    public static void main (String[] args) {
	CircumferenceTree c = new CircumferenceTree ();
	c.insert (100);
	c.insert (90);
	c.insert (80);
	c.insert (95);
	c.insert (92);
	c.insert (85);
	c.insert (82);
	c.insert (84);
	c.insert (110);
	c.insert (105);
	c.insert (108);
	c.insert (109);
	c.insert (107);

	c.boundary ();
   }
}
