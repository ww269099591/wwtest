package main.java.algorithm;

public class Bubblesort {
    public static void main(String[] args) {
        int N=10;
        int[] array=new int[N];
        for(int i=0;i<N;i++)
        {
            array[i]= (int)(Math.random() *1000);
            System.out.print(array[i]);
            System.out.print("-");
        }

        Bubblesort bubblesort=new Bubblesort();
        bubblesort.run(array,0,N-1);

        System.out.println("");
        for(int i=0;i<N;i++)
        {
            System.out.print(array[i]);
            System.out.print("-");

        }
    }
    public void run(int[] array,int a,int b){
        int temp,i,j,n;
        j=b;
        while(j>a) {
            n=0;
            i=0;
            temp=array[i];
            while (i < j) {
                if (temp < array[i+1]) {
                    array[i] = array[i+1];
                    array[i+1]=temp;
                    i++;
                    n++;
                } else {
                    temp = array[i+1];
                    i++;
                }
            }
            if(n==0){
                break;
            }
            j--;
        }
    }
}
