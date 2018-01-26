#include <stdio.h>
#include <malloc.h>

int main() {
    long int n, k;
    scanf("%ld%ld", &n, &k);
    long int size = n + k - 1;
    long int *arr = (long int*) malloc (sizeof (long int) * size);
    for(long long int i = 0; i < size; ++i) scanf("%ld", &arr[i]);
    long int *arr2 = (long int*) calloc (k - 1, sizeof (long int));
    for(long long int i = 0; i < n; ++i) {
	long int tmp = arr[i];
	for(long long int j = 0; j < k - 1; ++j) {
	    tmp = tmp ^ arr2[j];
	    //printf("%ld ", arr2[j]);
	}
	tmp = !(!tmp);
	printf("%ld", tmp);
	//printf("\n");
	for(long long int j = k - 2; j > 0; --j) {
	    arr2[j] = arr2[j - 1];
	}
	arr2[0] = tmp;
    }
    return 0;
}
