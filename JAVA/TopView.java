
import java.util.Queue;
import java.util.LinkedList;

public class TopView {
    class Node {
	int key;
	Node right;
	Node left;
	int col;

	public Node (int key, int col) {
	    this.col = col;
	    this.key = key;
	    this.right = null;
	    this.left = null;
	}
    }

    private Node root;
    int[] a = new int[100];
    int N = 0;

    public void insert (int key) {
	root = insert (root, key, 0);
    }

    private Node insert (Node n, int key, int marker) {
	if (n == null) return new Node (key, marker);
	
	if (key < n.key) n.left = insert (n.left, key, marker - 1);
	else if (key > n.key) n.right = insert (n.right, key, marker + 1);
	else {}

	return n;
    }

    public void printTopView () {
	Queue <Node> q = new LinkedList <Node> ();
	Node n = root;
	q.add (n);
	while (!q.isEmpty ()) {
	    Node tmp = q.poll ();
	    if (search (tmp.col));
	    else {
		System.out.println (tmp.key);
		a[N] = tmp.col;
		N += 1;
	    }
	    if (tmp.left != null) q.add (tmp.left);
	    if (tmp.right != null) q.add (tmp.right);
	}
    }

    private boolean search (int k) {
	for (int i = 0; i < N; i += 1) if (a[i] == k) return true;
	return false;
    }

    public static void main (String[] args) {
	TopView t = new TopView ();
	t.insert (8);
	t.insert (6);
	t.insert (1);
	t.insert (7);
	t.insert (12);
	t.insert (2);
	t.insert (3);
	t.insert (4);
	t.insert (5);
	t.printTopView ();
    }
}
