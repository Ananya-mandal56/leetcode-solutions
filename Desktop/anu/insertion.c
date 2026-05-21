#include<stdio.h>
void print_array(int arr[], int n)
{
    for( int i=0;i<n;i++)
    {
        printf("%d",arr[i]);
    }
    printf("\n");
}
int main()
{
    int i,j,temp,n;
    printf("enter number of element: ");
    scanf("%d",&n);
    int arr[n];
    printf("enter %d element: ",n);
    for(i=0;i<n;i++)
    {
        scanf("%d",&arr[i]);
    }
    printf("\ninitial array\n");    
    print_array(arr,n);
    printf("\n");
//insertion sort
    for( int i=1;i<n;i++)
    {
        j=i;
        printf("step %d: insert element at index %d (value=%d)\n",i,i,arr[i]);
        while(j>0 && arr[j-1]>arr[j])
        {
            temp=arr[j];
            arr[j]=arr[j-1];
            arr[j-1]=temp;
            printf("swaped arr[%d] and arr[%d]: ", j-1,j);
            print_array(arr,n);
            j--;
        }

        printf("sorted array: ");
        print_array(arr,n);
        printf("\n");
            
    

}
return 0;
}

