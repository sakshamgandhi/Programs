#include<stdio.h>
#include<stdlib.h>
//void addAtBeginning(node** head1, int item);
struct node
{
 int data;
 struct node *next;
};

void duplicates(struct node *head)
{
  struct node *ptr1, *ptr2, *dup;
  ptr1 = head;

  while(ptr1 != NULL && ptr1->next != NULL)
  {
     ptr2 = ptr1;

     while(ptr2->next != NULL)
     {
       if(ptr1->data == ptr2->next->data)
       {
          dup = ptr2->next;
          ptr2->next = ptr2->next->next;
          free(dup);
       }
       else
       {
          ptr2 = ptr2->next;
       }
     }
     ptr1 = ptr1->next;
  }
}
void addAtBeginning(struct node** head1, int item)
{
   struct node* newnode = (struct node*)malloc(sizeof(struct node));
    newnode->data = item;
    newnode->next = NULL;

    if(*head1== NULL)
    {
        *head1 = newnode;
    }
    else{
        newnode->next =*head1;
        *head1 = newnode;
    }
}

int main()
{
  struct node *head = NULL;

    addAtBeginning(&head,10);
    addAtBeginning(&head,20);
    addAtBeginning(&head,30);
    addAtBeginning(&head,40);
	addAtBeginning(&head,15);
    addAtBeginning(&head,10);
    addAtBeginning(&head,3);
    addAtBeginning(&head,40);

  printf("\n before ");
  print(head);

  duplicates(head);

  printf("\n after ");
  print(head);

  getchar();
}

void print(struct node *node)
{
  while(node != NULL)
  {
    printf("%d ", node->data);
    node = node->next;
  }
}

