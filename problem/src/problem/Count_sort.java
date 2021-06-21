package Sort;

public class Count_sort {
    public static void main(String[] args){
        int[] array = {7,5,9,0,3,1,6,2,9,1,4,8,0,5,2};
        Count_sort result = new Count_sort();
        result.sort(array);

    }

    private void sort(int[] arr){
        int[] arr2=new int[10];
        for(int i=0;i<arr.length;i++){
            arr2[arr[i]]++;
        }
        print(arr2);
    }

    private void print(int[] arr2){
        for(int i=0;i<arr2.length;i++){
            for(int j = 0; j<arr2[i];j++)
                System.out.print (i+" ");
        }
    }
}
