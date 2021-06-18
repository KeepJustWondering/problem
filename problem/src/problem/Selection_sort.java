package Sort;

public class Selection_sort {
    public static void main(String[] args){
        int[]array = {7,5,9,0,3,1,6,2,4,8};
        Selection_sort result = new Selection_sort();
        result.sort(array);
        result.print(array);
    }
    private void print(int[] array){
        for(int i=0; i<array.length;i++)
            System.out.print(array[i]+" ");
    }

    private void sort(int[] array){
        for(int i=0;i<array.length;i++){
            int min = array[i];
            int index=i;
            for(int j=i;j<array.length;j++){
                if(min>array[j])
                {
                    min = array[j];
                    index = j;
                }
            }
            swap(array,i,index);
        }
    }

    private void swap(int[] array,int i,int index){
        int temp = array[i];
        array[i] = array[index];
        array[index] = temp;
    }
}
