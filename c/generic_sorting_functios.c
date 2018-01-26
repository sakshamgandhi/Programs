#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include <strings.h>
#include <string.h>

/*
    returns -1 is s1 is numerically less than s2
    returns 0 is s1 is numerically equal than s2
    returns 1 is s1 is numerically greater than s2
*/
int numcmp(void* s1, void* s2)
{
   int x, y;

   sscanf((char *)s1, "%d", &x);
   sscanf((char *)s2, "%d", &y);

   if(x < y) return -1;
   if(x > y) return 1;
   return 0;
}

/*
    returns 1 is s1 is numerically less than s2
    returns 0 is s1 is numerically equal than s2
    returns -1 is s1 is numerically greater than s2
*/
int revnumcmp(void* s1, void* s2)
{
   int x, y;

   sscanf((char *)s1, "%d", &x);
   sscanf((char *)s2, "%d", &y);

   if(x < y) return 1;
   if(x > y) return -1;
   return 0;
}

/*
    Exchanges the pointers where they are pointing at
    Note: It does not exchange the content which would
    be a heavy operation
*/
void swap(void* a[], int i, int j)
{
    void* temp = a[i];

    a[i] = a[j];
    a[j] = temp;
}


int choosePivot(int left, int right)
{
    return left;
}

/*
    Choose random pivot
*/
int chooseRandomPivot(int left, int right)
{
    int r = rand() % (right-left+1);
    return left + r;
}

void q_sort(void *a[], int left, int right, int (*cmp)(void *, void *))
{
    // No elements remaining to be compared
    if(left >= right) return;

    // Choose the pivot element  at left
    // int pIndex = choosePivot(left, right);
    // Choose the pivot element at random and replace it with the left most element
    int pIndex = chooseRandomPivot(left, right);

    swap(a, left, pIndex);

    int last = left; //Will contain the position with which pivot needs to be replaced
    int i = left + 1;
    for( ;i <= right; ++i)
        if(((*cmp)(a[i], a[left])) <= 0)
            swap(a, i, ++last);
    swap(a, left, last);
    q_sort(a, left, last-1, cmp);
    q_sort(a, last+1, right, cmp);
}

int main(int argc, char* argv[])
{
    // LHS declares the function pointer. RHS casts function to the required type
    int (*fp)(void*, void*) = (int (*)(void *, void*)) strcmp;

    if(argc > 1) {
        if(!strcmp(argv[1], "-n"))
            fp = numcmp;
        else if(!strcmp(argv[1], "-r"))
            fp = revnumcmp;
        else if(!strcmp(argv[1], "-i"))
            fp = (int (*)(void*, void *))strcasecmp;
    }

    char *s[] = {"15", "13", "121", "9"};
    q_sort((void **)s, 0 , 3, fp);
    // Print
    int i = 0;
    for(; i < 4; i++)
        printf("%s ", s[i]);
    printf("\n");

    return 0;
}
