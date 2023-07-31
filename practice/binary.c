#include<stdio.h>

void main(){
    int flag=0;
    int arr[20];
    int n,x;
    printf("enter the no of elements\n");
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
      }
    printf("enter the searching element\n");
    scanf("%d",&x);
    int low = 0;
    int high = n-1;
    int mid;
    while(low<=high){
        mid = (low + high)/2;
        if(arr[mid]>x){
            high = mid -1;
        }
        else if(arr[mid]<x){
            low = mid +1;
        }
        else {
            flag =1;
            break;
        }
    }
    if(flag ==1){
        printf("element found at index %d\n",mid);
    }
    else{
        printf("element not found\n");
    }
}