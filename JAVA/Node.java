public class Node implements Comparable <Node> {
    int val;
    String val2;
    Node right;
    Node left;
    int N;
    
    Node (int val, String val2) {
	this.val = val;
	this.val2 = val2;
	this.right = null;
	this.left = null;
	this.N = 1;
    }

    public int compareTo (Node n) {
	return this.val2.compareTo (n.val2);
    }

    public String toString () {
	return "values are " + val2 + " " + val + " ";
    }
}
