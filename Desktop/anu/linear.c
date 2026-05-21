#include<stdio.h>
int linearSearch(int arr[], int key,int size)
{
    for( int i=0;i<size;i++)
    {
        if(arr[i]==key)
        {
            return i;
        }
        
    }
    return -1;
}

int main()
{
    int n,result,key;
    printf("enter number of element: ");
    scanf("%d",&n);
    int arr[n];
    printf("enter %d element: ",n);
    for( int i=0;i<n;i++)
    {
        scanf("%d",&arr[i]);
    }
    printf("enter key to be search: ");
    scanf("%d",&key);
    result=linearSearch(arr,key,n);
    if(result!=-1)
    {
        printf("element found at index %d", result);
    }
    else 
    {
        printf("element not found");
    }
    return 0;
}