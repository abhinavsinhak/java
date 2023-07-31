#include<stdio.h>
int min(int a,int b) return (a<=b) ? a :b;
int fibonacci(int arr[20],int x,int n){
    int fib2 = 0;
    int fib1 = 1;
    int fib  =fib1 +fib2;

    while(fib<n){
        fib2 = fib1;
        fib1 = fib;
        fib = fib2+fib1;
    }
    int offset = -1;
    while(fib>1){
        int i = min(offset + fib2 ,n-1);
        if(arr[i] <x){
            fib = fib1;
            fib1 = fib2;
            fib2 = fib -fib1;
        }
        else if(arr[i]>x){
            fib = fib2;
            fib1 = fib1 - fib2;
            fib2 = fib-fib1;
        }
        else return i;

    }
    if(fib1 && arr[offset+1]==x){
        return offset+1;
    }
    return -1;
}
void main()