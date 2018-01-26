import java.util.Queue;
import java.util.LinkedList;

public class Traversing {
    class Node {
	int val;
	Node left;
	Node right;

	Node (int val) {
	    this.val = val;
	    this.right = null;
	    this.left = null;
	}
    }

    Node root;
    public void insert (int val) {
	root = insert (val, root);
    }
    private Node insert (int val, Node n) {
	if (n == null) return new Node (val);
	if (n.val > val) n.left = insert (val, n.left);
	else if (n.val < val) n.right = insert (val, n.right);
	else {
	    // do nothing
	}
	return n;
    }

    public void preOrder () {
	preOrder (root);
    }

    private void preOrder (Node n) {
	if (n == null) return;
	System.out.println (n.val);
	preOrder (n.left);
	preOrder (n.right);
    }

    public void inOrder () {
	inOrder (root);
    }

    private void inOrder (Node n) {
	if (n == null) return;
	inOrder (n.left);
	System.out.println (n.val);
	inOrder (n.right);
    }

    public void postOrder () {
	postOrder (root);
    }

    private void postOrder (Node n) {
	if (n == null) return;
	postOrder (n.left);
	postOrder (n.right);
	System.out.println (n.val);
    }

    public void levelOrder () {
	Queue <Node> q = new LinkedList <Node> ();
	if (root == null) return;
	q.add (root);
	while (!q.isEmpty ()) {
	    Node n = q.poll ();
	    System.out.println (n.val);
	    if (n.left != null) q.add (n.left);
	    if (n.right != null) q.add (n.right);
	}
    }


    public static void main (String[] args) {
	Traversing t = new Traversing ();
	t.insert (8);
	t.insert (6);
	t.insert (1);
	t.insert (7);
	t.insert (12);
	t.insert (2);
	t.insert (3);
	t.insert (4);
	t.insert (5);

	t.preOrder ();
	System.out.println ("----------------------");
	t.inOrder ();
	System.out.println ("----------------------");
	t.postOrder ();
	System.out.println ("----------------------");
	t.levelOrder ();
	System.out.println ("----------------------");
    }
}
