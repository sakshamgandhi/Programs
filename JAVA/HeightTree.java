
// Question is present in hackkerank
//Link is given below
https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree

static int getHeight(Node root) {
      	// Write your code here.
        if (root == null) return -1;
        else {
            int max;
            int l = getHeight (root.left) + 1;
            int r = getHeight (root.right) + 1;
            if (l > r) max = l;
            else max = r;
            return max;
        }
    }
