public class DeleteNode {
    Node root;
    public void insert (int val, String val2) {
	root = insert (root, val, val2);
    }

    private Node insert (Node n, int val, String val2) {
	if (n == null) return new Node (val, val2);
	if (val < n.val) n.left = insert (n.left, val, val2);
	else if (val > n.val) n.right = insert (n.right, val, val2);
	else {
	    //Do nothing
	}
	return n;
    }

    public void deleteMin () {
	if (root == null) return;
	root = deleteMin (root);
    }

    private Node deleteMin (Node n) {
	if (n.left == null) return n.right;
	else {
	    n.left = deleteMin (n.left);
	}
	return n;
    }

    public void deleteRoot (int val) {
	if (root == null) return;
	root = deleteRoot (root, val);
    }

    private Node deleteRoot (Node n, int val) {
	if (val > n.val) n.right = deleteRoot (n.right, val);
	else if (val < n.val) n.left = deleteRoot (n.left, val);
	else {
	    if (n.left == null) return n.right;
	    else if (n.right == null) return n.left;
	    else {
		Node tmp = n;
		n = getMin (tmp.right);
		n.right = deleteMin (tmp.right);
		n.left = tmp.left;
	    }
	}
	return n;
    }

    private Node getMin (Node n) {
	if (n.left == null) return n;
	else {
	    n = getMin (n.left);
	}
	return n;
    }

    public void preOrder () {
	preOrder (root);
    }

    private void preOrder (Node n) {
	if (n == null) return;
	System.out.println (n);
	preOrder (n.left);
	preOrder (n.right);
    }

    public static void main (String[] args) {
	DeleteNode t = new DeleteNode ();
	t.insert (8, "E");
	t.insert (6, "R");
	t.insert (1, "A");
	t.insert (7, "OF");
	t.insert (12, "OF");
	t.insert (2, "E");
	t.insert (3, "V");
	t.insert (4, "E");
	t.insert (13, "S");

	t.deleteMin ();
	t.preOrder ();
	System.out.println ("-----------------");
	t.deleteRoot (8);
	t.preOrder ();
    }
}
