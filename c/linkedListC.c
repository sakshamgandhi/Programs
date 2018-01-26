#include<stdio.h>
typedef struct linkedList
{
    int data;
    struct linkedList* next;

}LL;

void addAtBeginning(LL** head1, int item)
{
    LL* newnode = (LL*)malloc(sizeof(LL));
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
void addAtLast(LL** head1 ,int item)
{
    LL* newnode = (LL*)malloc(sizeof(LL));
    newnode->data = item;
    newnode->next = NULL;
    if(*head1 == NULL)
    {
        *head1=newnode;
    }
    else
    {
        LL* current =*head1;
        while(current->next !=NULL)
        {
            current = current->next;
        }
        current->next=newnode;
    }

}
void addAtGivenPosition(LL**head1 , int item, unsigned int position)
{
     LL* newnode = (LL*)malloc(sizeof(LL));
    newnode->data = item;
    newnode->next = NULL;

    if (position ==1)
    {

    if(*head1== NULL)
    {
        *head1 = newnode;
    }
    else{


        newnode->next =*head1;
        *head1 = newnode;
    }

    }
    else
    {
        int p =1;
        LL* current = *head1;
        while(current !=NULL && p<position-1)
        {
            current = current->next;
            p++;
        }
        if(current==NULL)
        {

            printf("position does not exist\n");
        }
        else{
            newnode->next = current->next;
            current->next = newnode;
        }
    }
}
void deleteAtBeginning(LL**head1)
{
    if(*head1 == NULL)
    {
        printf("linked list is empty\n");
    }
    else{

        LL* temp = *head1;
        *head1= (*head1)->next;
        free(temp);
        temp = NULL;
    }
}
void deleteAtLast(LL** head1)
{
   if( *head1 == NULL)
    {
        printf("linked list is empty\n");
    }
    else if((*head1)->next==NULL)
    {
        LL* temp = *head1;
        *head1= (*head1)->next;
        free(temp);
        temp = NULL;
    }
    else
    {
        LL* current = *head1;
        while(current->next->next != NULL)
        {
            current = current ->next;
        }
        LL* temp = current->next;
        current->next =NULL;
        free(temp);
        temp=NULL;
    }
}
void print(LL* head)
{
    LL* current = head;

    while(current!= NULL)
    {
        printf("%d\n",current->data);
        current= current->next;
    }
}
void deleteAtGivenPosition(LL** head1, int position)
{
    if(position ==1)
    {
        if(*head1==NULL)
        {
            printf("linked list is empty");
        }
        else if((*head1)->next == NULL)
        {
            LL* temp =*head1;
            *head1= NULL;
            free(temp);
            temp =NULL;
        }
        else
        {
           LL* temp =*head1;
            *head1= (*head1)->next;
            free(temp);
            temp =NULL;
        }
    }
    else{

        int p =1;
        LL* current = *head1;
        while(current !=NULL && p<position-1)
        {
            current = current->next;
            p++;
        }
        if(current==NULL)
        {

            printf("position does not exist\n");
        }
        else
        {
            LL* temp = current->next;
            current->next = temp-> next;
            free(temp);
            temp=NULL;
        }


    }
}
int countNodes(LL* head)
{
    int count =0;
    LL* current = head;
    while(current!=NULL)
    {
        count = count +1;
        current = current->next;
    }
    return count;
}
int countNodesRecursive(LL* head)
{
    if(head == NULL)
    {
        return 0;
    }
    else
    {
        return 1 + countNodesRecursive(head->next);
    }
}
int search(LL* head, int item)
{
    LL* current = head;
    while(current!= NULL)
    {
        if(current->data == item)
        {
            return 1;
        }
        else
        {
            current =current->next;
        }
    }
    return 0;
}
int searchRecursive(LL* head, int data)
{
    if(head==NULL)
    {
        return 0;
    }
    else if(head->data == data)
    {
        return 1;
    }
    else
    {
        return searchRecursive(head->next, data);
    }
}

LL* findMiddle(LL* head)
{
    if(head==NULL)
    {
        printf("linked list is empty");
    }
    else if(head->next==NULL)
    {
        printf("linked list has no middle element");
    }
    else
    {
        LL*fast =head;
        LL*slow = head;
        while(fast!=NULL && fast->next!=NULL)
        {
            fast = fast->next->next;
            slow = slow->next;
        }
    }
}

int main()
{

    LL* head = NULL;
    addAtBeginning(&head,10);
    addAtBeginning(&head,20);
    addAtBeginning(&head,30);
    addAtBeginning(&head,40);
    addAtLast(&head,50);
    addAtGivenPosition(&head,70,6);
deleteAtGivenPosition(&head,3);
/*deleteAtLast(&head);*/
print(head);
}
