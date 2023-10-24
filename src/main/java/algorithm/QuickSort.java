package algorithm;

public class QuickSort {
    public static void main(String[] args) {
        int[] array=new int[100];
        for(int i=0;i<100;i++)
        {
            array[i]= (int)(Math.random() *1000);
            System.out.print(array[i]);
            System.out.print("-");
        }

        QuickSort quicksort=new QuickSort();
        quicksort.run(array,0,99);

        System.out.println("");
        for(int i=0;i<100;i++)
        {
            System.out.print(array[i]);
            System.out.print("-");

        }
    }

    public void run(int[] array,int a,int b){
        int t,temp,i,j,n;
        i=a;
        j=b;
        n=0;
        temp=array[i];
       while(i!=j){
          while(i<j&&i!=j) {
              if(temp<array[j]){
               j--;
              }else{
                  array[i]=array[j];
                  t=i;
                  i=j;
                  j=t;
                  j++;
                  n++;
              }
           }
           while(i>j&&i!=j){
              if(temp>array[j]){
                  j++;
              }else{
                  array[i]=array[j];
                  t=i;
                  i=j;
                  j=t;
                  j--;
                  n++;
              }
           }
       }
       array[i]=temp;
       if(a<=i-1&&n!=0) {
           this.run(array, a, i - 1);
       }
       if(b>=i+1&&n!=0) {
           this.run(array, i + 1, b);
       }
    }

}
