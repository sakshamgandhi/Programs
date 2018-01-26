
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class ZigZagView {
    class Node {
	int key;
	Node left;
	Node right;
	
	Node (int key) {
	    this.key = key;
	    this.left = null;
	    this.right = null;
	}

    }

    Node root;

    public void insert (int key) {
	root = insert (root, key);
    }

    private Node insert (Node n, int key) {
	if (n == null) return new Node (key);
	
	if (key < n.key) n.left = insert (n.left, key);
	else if (key > n.key) n.right = insert (n.right, key);
	else {}

	return n;
    }

    public void printZigZag () {
	Node n = root;
	Queue <Node> q = new LinkedList <Node> ();
	q.add (n);
	q.add (null);
	int flag = 0;

	while (!q.isEmpty ()) {
	    Node tmp = q.poll ();
	    if (tmp == null) {
		if (flag == 0) {
		    flag = 1;
		    //reverse
		    Stack <Node> s = new Stack <Node> ();
		    while (!q.isEmpty ()) s.push (q.poll ());
		    while (!s.isEmpty ()) q.add (s.pop ());
		}
		else flag = 0;
		if (!q.isEmpty ()) q.add (null);
	    }
	    else {
		System.out.println (tmp.key);
		if (tmp.left != null) q.add (tmp.left);
		if (tmp.right != null) q.add (tmp.right);
	    }
	}
    }

    public static void main (String[] args) {
	ZigZagView t = new ZigZagView ();
	t.insert (8);
	t.insert (6);
	t.insert (1);
	t.insert (7);
	t.insert (12);
	t.insert (2);
	t.insert (3);
	t.insert (4);
	t.insert (5);
	t.printZigZag ();
    }
}
