#include<stdio.h>
int binarySearch(int arr[],int key,int size)
{
    int low=0,high=size-1,mid;
    {
        while(low<=high)
        {
            mid=(low+high)/2; 
            {
                if(arr[mid]==key)
                {
                    return mid;
                }
                else if(arr[mid]<key)
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
                
                }
            }
        }
    
    return -1;
}

    int main()
    {
        int n,result,key;
        printf("enter the number the element: ");
        scanf("%d",&n);
        int arr[n];
        printf("enter %d element: ",n);
        for(int i=0;i<n;i++)
        {
            scanf("%d",&arr[i]);
        }
        printf("element to be search: ");
        scanf("%d",&key);
        result=binarySearch(arr,key,n);
        if(result!=-1)
        {
            printf("element found at index %d",result);
        }
        else
        {
            printf("element not found");
        }
        return 0;
    }

   