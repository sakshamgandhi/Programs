#include <stdio.h>

int getSolution(int a[6], int first, int last, int count, int searchElement) {
		if(first < last) {
			int mid = first + last;
			mid = mid / 2;
			if(a[mid] == searchElement) {
				count += 1;
			}

			count =  getSolution(a, first, mid + 1, count, searchElement);
			count = getSolution(a, mid - 1, last, count, searchElement);
		}
		return count;
}

int main() {
	int a[6] = {1,2,2,3,4,5};
	printf("%d", getSolution(a, 0, sizeof(a)/sizeof(a[0]) - 1, 0, 2));
	return 0;
}
