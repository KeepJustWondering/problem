package Sort;

public class Insertion_sort {
    public static void main(String[] args){
        int[] array = {7,5,9,0,3,1,6,2,4,8};
        Insertion_sort result =new Insertion_sort();
        result.sort(array);
        result.print(array);

    }
    private void print(int[] array){
        for(int i=0; i<array.length;i++)
            System.out.print(array[i]+" ");
    }
    private void sort(int[] array){
        for(int i=1;i<array.length;i++){
            for(int j=i;j>0;j--){
                if(array[j]<array[j-1])
                    swap(array,j,j-1);
                else
                    break;
            }
        }
    }

    private void swap(int[] array,int i,int index){
        int temp = array[i];
        array[i] = array[index];
        array[index] = temp;
    }

}
