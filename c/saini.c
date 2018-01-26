#include<stdio.h>

int main(){
int n,i=0;
scanf("%d",&n);
int arr[n],arr1[n],arr2[n];
for(i=0;i<n;i++){
scanf("%d",&arr[i]);
arr1[i]=arr[i];
}
for(i=0;i<n;i++){
//for(int j=i;j<n;j++){
if(arr[i]==arr1[i+1]){
arr2[i]=arr[i];
}
else
	continue;
}
//}
for(i=0;i<n;i++){
		if(arr[i]>0)
printf("\n%d\n",arr2[i]);
}
}
