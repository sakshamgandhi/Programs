
public class RedBlack {

    private static boolean RED = true;
    private static boolean BLACK = false;

    private class Node {
	int key;
	Node right;
	Node left;
	boolean color;

	Node (int key) {
	    this.key = key;
	    this.right = null;
	    this.left = null;
	    this.color = RED;
	}
    }

    private Node root;

    public void insert (int key) {
	root = insert (root, key);
	root.color = BLACK;
    }

    private Node insert (Node n, int key) {
	if (n == null) return new Node (key);
	
	if (isRed (n.right) && isRed (n.left)) flipColor (n);

	if (key < n.key) n.left = insert (n.left, key);
	else if (key > n.key) n.right = insert (n.right, key);
	else n.key = key;

	if (isRed (n.right) && !(isRed (n.left))) n = rotateLeft (n);
	if (isRed (n.left) && isRed (n.left.left)) n = rotateRight (n);
	
	return n;
    }

    private boolean isRed (Node n) {
	if (n == null) return false;
	return n.color;
    }

    private Node rotateLeft (Node n) {
	Node tmp = n.right;
	n.right = tmp.left;
	tmp.left = n;
	tmp.color = n.color;
	n.color = RED;
	return tmp;
    }

    private Node rotateRight (Node n) {
	Node tmp = n.left;
	n.left = tmp.right;
	tmp.right = n;
	tmp.color = n.color;
	n.color = RED;
	return tmp;
    }

    private void flipColor (Node n) {
	n.color = !n.color;
	n.right.color = !n.right.color;
	n.left.color = !n.left.color;
    }

    public void inOrder () {
	inOrder (root);
    }

    private void inOrder (Node n) {
	if (n != null) {
	    inOrder (n.left);
	    System.out.println (n.key);
	    inOrder (n.right);
	}
    }

    public int height () {
	return height (root);
    }

    private int height (Node n) {
	if (n == null) return -1;
	int l = height (n.left);
	int r = height (n.right);
	if (l > r) return l + 1;
	else return r + 1;
    }

    public static void main (String[] args) {
	RedBlack rb = new RedBlack ();
	rb.insert (5);
	rb.insert (4);
	rb.insert (3);
	rb.insert (2);
	rb.insert (6);
	rb.inOrder ();
	System.out.println ("Height = " + rb.height ());
    }
}
