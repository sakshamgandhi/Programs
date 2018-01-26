// Array is shifted by some unknown positions. 5 7 9 13 18  ->  13 18 5 7 9.
// Now do binary search. Algorithms should be O(logN) only.


int main()
{
    int i, N, num, res;	//Which are for : iterator, arrayysize, searchitem, resultingposition

    printf("\nEnter size: ");
    scanf("%d", &N);
    int A[N];

    printf("\nEnter elements: ");
    for(i = 0; i < N; i++)
      scanf("%d", &A[i]);

    printf("\nEnter number to search: ");
    scanf("%d", &num);

    res = binary_search(A, 0, (2*N)-1, num, N);    //Logically merge the array. 8 9 1 2 becomes 8 9 1 2 8 9 1 2
    if(res==-1) printf("\n\nNOT FOUND!\n\n");
    else printf("Found at index  %d\n\n", res);

    return 0;
}


int binary_search(int *A, int start, int end, int num, int size)
{
    int mid;
    if(start<=end)
    {
      mid = (start + end) / 2;
      if(A[mid%size] == num)  //Just use A[mid%size] for merged array
    	  return mid%size;
      else if(A[mid%size] > num)
	      return binary_search(A, start, (mid)-1, num, size);
      else
	      return binary_search(A, (mid)+1, end, num, size);
    }

    else return -1;
}
