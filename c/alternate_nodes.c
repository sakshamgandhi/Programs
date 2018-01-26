#include<stdio.h>

struct node{
int data;
struct node* next;
};

void addAtBeginning(node* head,int data){
node* newnode=(node*)malloc(sizeof(node));
newnode->data=data;
newnode->next=NULL;
if(head==NULL){
	head=newnode;
}
else {
newnode->next=head;
head=newnode;
	}
}

void print(node*head) {
	node*current=head;
	while(current!=NULL){
		printf("%d",current->data);
		current=current->next;
	}
}

void alternate(node*head){
	 node*current=head;
	 while(current->next!=NULL){
		current->next
	 }
}
