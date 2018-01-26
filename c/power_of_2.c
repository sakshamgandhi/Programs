#include<stdio.h>

int checkPower(int x){
int temp=x;
int count=0;
while(x!=0){
	if((x&1)==1){
		count++;
	}
	x=x>>1;
}
if(count==1)
	return 1;
else
	return 0;
}

int main(){
int x;
scanf("%d",&x);
int y=checkPower(x);
if(y)
	printf("yes %d is power of 2",x);
else
	printf("no");
}
