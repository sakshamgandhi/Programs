public class Rev {
    class Node {
        Object val;
        Node next;
        
        Node (Object val) {
            this.val = val;
            this.next = null;
        }
    }
    
    private Node root;
    public void insert(Object o) {
        Node n = new Node(o);
        if (root == null) root = n;
        else {
            Node tmp = root;
            while (tmp.next != null) tmp = tmp.next;
            tmp.next = n;
        }
    }
    
    public void print() {
        Node tmp = root;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }
    
    public void revv() {
        Node cur = root;
        Node n = cur.next;
        Node prv = null;
        
        while (n != null) {
            n = cur.next;
            cur.next = prv;
            prv = cur;
            cur = n;
        }
        root = prv;
        
    }
    
    public static void main(String[] args) {
        Rev r = new Rev ();
        r.insert(1);
        r.insert(2);
        r.insert(3);
        r.insert(4);
        
        r.revv();
        r.print();
        
    }
}
