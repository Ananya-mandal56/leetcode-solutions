#include<stdio.h>
#include<math.h>

int main ()
{
   int a,b,add,sub,multiply,power,result,result1,option;
  printf("Enter two numbers: ");
    scanf("%d %d",&a,&b);
    printf("simple calculator\n1.add\n 2.sub\n 3.multiply \n 4.power \n 5.sqrt \n ");
    printf("Enter your option: ");
    scanf("%d",&option);
    if(option==1

    {
        add=a+b;
        printf("add will be %d",add);

    }
   if(option==2)
   {
       sub=a-b;
       printf("sub will be %d",sub);

   }    
    if(option==3)
       {
       multiply=a*b;
       printf("multiply will be %d",multiply);
       }    
    if(option==4) 
     {
     power=pow(a,b);
     printf("power of two number %d %d is %d ",a,b,power);
     }
    if(option==5)
    {
         result=sqrt(a);
         result1=sqrt(b);
         printf("square root of two number %d %d is %d %d",a,b,result,result1);
    }
    return 0;

}


