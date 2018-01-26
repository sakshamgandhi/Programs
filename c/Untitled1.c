#include <stdlib.h>
#include <math.h>
#include <stdio.h>

	struct node
{
    int data;
    struct node *next;
};

void push(struct node ** head)
{
    int new_data;
    scanf("%d",&new_data);
    struct node* new_node =
           (struct node*) malloc(sizeof(struct node));
    new_node->data  = new_data;
    new_node->next = (*head);
    (*head)  = new_node;
}

void printList(struct node *head)
{
    struct node *temp = head;
    while (temp != NULL)
    {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

void merge(struct node *p, struct node **q)
{
     struct node *p_curr = p, *q_curr = *q;
     struct node *p_next, *q_next;

     while (p_curr != NULL && q_curr != NULL)
    {
         p_next = p_curr->next;
         q_next = q_curr->next;

         q_curr->next = p_next;
         p_curr->next = q_curr;
         p_curr = p_next;
         q_curr = q_next;
    }

    *q = q_curr;
}

int main()
{
     struct node *p = NULL, *q = NULL;
     int n,m;
   scanf("%d",&n);
   scanf("%d",&m);
   printf("%d\t%d\n",n,m);
   for(int j=n;j=0;j--)
   push(&p);

   for(int i=m;i=0;i--)
   push(&q);
    printf("First Linked List:\n");
     printList(p);
      printf("second Linked List:\n");
     printList(q);
     merge(p, &q);

     printList(p);
     printList(q);

     return 0;
}
