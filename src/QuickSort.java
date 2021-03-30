import java.util.Scanner;

/**
 * @author zr
 * @create 2021-03-29-20:59
 */
public class QuickSort {


    public static int Partition(int a[],int low,int high){

        int value = a[low];
        int i=low,j=high+1;

        while (true){

            while (a[++i]<value&&i<=high){}

            while (a[--j]>value&&j>=low){}

            if(i>=j)
                break;

            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;

        }

        if(j!=low){
            int tmp = a[j];
            a[j] = a[low];
            a[low] = tmp;
        }

        return j;

    }

    public static void QuickSort(int a[], int low, int high){
        if(low>=high)
            return;

        int pivot = Partition(a, low, high);

        QuickSort(a,low,pivot-1);
        QuickSort(a,pivot+1,high);
    }

    public static void main(String[] args) {
        int a[] = new int[200] ;
        int n;

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for(int i=0;i<n;i++) {
            a[i] = scanner.nextInt();
        }


        int first = 0;
        int end = n-1;

        QuickSort(a, first, end);

        for (int i =0;i<n;i++){
            System.out.println(a[i]);
        }
    }
}
