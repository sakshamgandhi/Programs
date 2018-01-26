/**Binary search tree class**/
public class bst
{
    /**Since only the the bst class is going to use this class**/
    private class Node{
    int key;
    Node left;
    Node right;
    /**Whenever the object of this class 'Node' is created it will be getting these values**/
    public Node(int key)
    {
        this.key = key;
        this.left = null;
        this.right = null;

    }
    }
    /**The first Element of the tree**/
    Node root;
    /**Inserting any values in your tree to make it preserve its order**/
    public void insert(int key){
    root = insert(root,key);
    }
    private Node insert(Node n, int key){
    if(n==null)return new Node(key);/**if Tree is empty**/
    if(key == n.key)/**If duplicate is added**/
        return n;
    else if(key<n.key)/**If Element is less than the root**/
        n.left = insert(n.left, key);
    else/**If Element is more than the root**/
        n.right = insert(n.right, key);
    return n;
    }
    /**Searching the element in the tree**/
    public boolean search(int key)
    {
        boolean b = search(root, key);
        return b;
    }
    private boolean search(Node n, int key)
    {
        if(n==null)return false;/**If tree is traversed and the element is not found**/
        if(n.key == key)return true;/**If the element is found**/
        if(n.key > key)return search(n.left, key);/**Go left**/
        return search(n.right,key);/**Go right**/
    }
    /**Getting the most minimum of all in the whole tree**/
    public Node getMin()
    {
        if(root == null)return root;
        return getMin(root);
    }
    private Node getMin(Node n)
    {
        if(n.left == null)return n;/**Just go left until a null is encountered**/
            return getMin(n.left);
    }
    public int getMax()
    {
        if(root == null)return -1;
        return getMax(root);
    }
    private int getMax(Node n)
    {
        if(n.right == null)return n.key;/**Just go right until a null is encountered**/
        return getMax(n.right);
    }
    public void delMin()
    {
        if(root == null)return;
        root = delMin(root);
    }
    private Node delMin(Node n)
    {
        if(n.left==null)return n.right;
        n.left = delMin(n.left);
        return n;
    }
    public void delMax()
    {
        if(root == null)return;
        root = delMax(root);
    }
    private Node delMax(Node n)
    {
        if(n.right == null)return n.left;
        n.right = delMax(n.right);
        return n;
    }
    public void del(int key)
    {
        if(root!=null)
        root = del(root,key);
    }
    private Node del(Node n, int key)
    {
        if(key > n.key)return del(n.right,key);
        else if(key < n.key)return del(n.left,key);
        else{
            if(n.left == null)return n.right;
            if(n.right == null)return n.left;
            Node temp = n;
            n = getMin(n.right);
            n.right = delMin(temp.right);
            n.left = temp.left;
        }
        return n;

    }
    public static void main(String []arg)
    {
        bst b = new bst();
        b.insert(5);
        b.insert(3);
        b.insert(4);
        b.insert(2);
        b.insert(7);
        b.insert(6);
        b.insert(8);
        /**Doing the search**/
        boolean boo = b.search(1);
        System.out.println(boo);
        //int x = b.getMin();
        //System.out.println(x);
        int y = b.getMax();
        System.out.println(y);



    }

}
