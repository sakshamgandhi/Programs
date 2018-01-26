#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>

#define MAX_SIZE_SMALL 32000
#define MAX_SIZE_LARGE 64000


void swap(int a[], int i, int j)
{
    if(i == j) return;
    int temp = a[i];

    a[i] = a[j];
    a[j] = temp;
}


int choosePivot(int a[], int left, int right)
{
    return left;
}

int chooseRandomPivot(int a[], int left, int right)
{
    int r = rand() % (right-left+1);
    return left + r;
}

void q_sort(int a[], int left, int right)
{
    // No elements remaining to be compared
    if(left >= right) return;

    // Choose the pivot element  at left
    // int pIndex = choosePivot(a, left, right);
    // Choose the pivot element at random and replace it with the left most element
    int pIndex = chooseRandomPivot(a, left, right);

    swap(a, left, pIndex);

    int last = left; //Will contain the position with which pivot needs to be replaced
    int i = left + 1;
    for( ;i <= right; ++i)
        if(a[i] <= a[left])
            swap(a, i, ++last);
    swap(a, left, last);
    q_sort(a, left, last-1);
    q_sort(a, last+1, right);
}

int main()
{
    int *a = (int *) malloc(sizeof(int) * MAX_SIZE_SMALL);
    int *b = (int *) malloc(sizeof(int) * MAX_SIZE_LARGE);
    int i = 0;
    srand(time(NULL));

    // Worst case for quicksort (Already sorted array)
    for(; i < MAX_SIZE_SMALL; i++)
        a[i] = i;
    for(i = 0; i < MAX_SIZE_LARGE; i++)
        b[i] = i;

    struct timeval start, end;
    gettimeofday(&start, NULL);
    q_sort(a, 0, MAX_SIZE_SMALL-1);
    gettimeofday(&end, NULL);
    time_t tSmall = (end.tv_sec * 1000000L + end.tv_usec) - (start.tv_sec * 1000000L + start.tv_usec);

    gettimeofday(&start, NULL);
    q_sort(b, 0, MAX_SIZE_LARGE-1);
    gettimeofday(&end, NULL);
    time_t tLarge = (end.tv_sec * 1000000L + end.tv_usec) - (start.tv_sec * 1000000L + start.tv_usec);

    printf("%g\n", tLarge * 1.0 /tSmall);

    // Print array content after sorting
    for(i = 0; i < MAX_SIZE_SMALL; i++)
        printf("%d ", a[i]);
    printf("\n");

    return 0;
}
