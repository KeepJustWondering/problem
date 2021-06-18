package Sort;

public class Quick_sort {
    public static void main(String[] args){
        Quick_sort result = new Quick_sort();
        int[] array = {5,7,9,0,3,1,6,2,4,8};
        result.sort(array,0,array.length-1);
        result.print(array);
    }

    private void sort(int[] array,int first,int last){
        if (first >= last) return;
        int pivot = first;
        int count = first+1;
        int reverse = last;

        while(reverse >= count) {
            while (count <= last) {
                if (array[pivot] < array[count])
                    break;
                count++;
            }
            while (reverse > first) {
                if (array[pivot] > array[reverse])
                    break;
                reverse--;
            }
            if(reverse < count)
                swap(array, pivot, reverse);
            else
                swap(array, count, reverse);
        }


        sort(array,first,reverse-1);
        sort(array,reverse+1,last);

    }

    private void print(int[] array){
        for(int i=0; i<array.length;i++)
            System.out.print(array[i]+" ");
    }
    private void swap(int[] array,int i,int index){
        int temp = array[i];
        array[i] = array[index];
        array[index] = temp;
    }
}
