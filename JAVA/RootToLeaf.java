
// ONLY LOGIC

public void print_to_leaf () {
	int[] a = new int[100];
	print_to_leaf (a, 0, root);
    }

    private void print_to_leaf (int[] a, int k, Node n) {	
    a[k] = n.key;
	k += 1;
	if (n.left == null && n.right == null) {
	    for (int i = 0; i < k; i+=1) {
		System.out.print (a[i]+" ");
	    }
	    System.out.print ("\n");
	}
	else {
        if (n.left != null) print_to_leaf (a, k, n.left);
	    if (n.right != null) print_to_leaf (a, k, n.right);
	}
    }
