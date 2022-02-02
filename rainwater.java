import java.io.*;
import java.util.Scanner;

public class rainwater {
    public static int calc(int arr[], int n, int a, int b) {
        int sum = 0;
        for (int i = a + 1; i < b; i++)
            sum = sum + arr[i];
        return sum;
    }
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int n,i,j=0,count=0,less,i1,i2;
        System.out.print("Enter Limit : ");
        n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];//b array has one value and then index
        //Inputtung all elements
        System.out.print("Enter all elements : ");
        for(i=0;i<=n-1;i++)
            a[i] = sc.nextInt();
        //Initialising null array with 0 in all elements
        for(i=0;i<=n-1;i++)
            b[i]=0;

        //Calculating local maxima
        for(i=0;i<=n-1;i++)
        {
            if(i==0 && a[i]>=a[i+1])//If local maxima is 1st element
            {
                b[j++]=a[i];//initializing value
                b[j++]=i;//initializing index
            }   
            else if(a[i]>=a[i-1] && i==(n-1))//If local maxima is last element
                {
                    b[j++]=a[i];//initializing value
                    b[j++]=i;//initializing index
                } 
                else if(a[i]>=a[i-1] && a[i]>=a[i+1])//If local maxima is in between
                    {
                        b[j++]=a[i];//initializing value
                        b[j++]=i;//initializing index
                    }  
        }
        
        for(i=0;i<j-1;i+=2)//here one is value other is index so +2
        //i<j-1 because we need the spaces between two towers, so total towers - 1
        {
        less=(b[i]<b[i+2])?b[i]:b[i+2];//Calculating which is smaller element
         count=count+(less * (b[i+3] - b[i+1] - 1)) -calc(a , n , b[i+1] , b[i+3]);
        /*(less * (b[i+3] - b[i+1] - 1)) is total water collected between two local maxima
        (calc(a , n , b[i+1] , b[i+3]) is total blocks between two maxima
        */
        }
        System.out.print("Rainwater Trapping in blocks : "+count);
    }
}