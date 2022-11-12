import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Быстрая сортировка");
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) Math.round(Math.random() * 100);

        }
        System.out.println(Arrays.toString(array));

        int[] arrayS;
        arrayS = sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(arrayS));
    }

    public static int[] sort(int[] arr, int start, int end) {
        if (start >= end) return arr;
        int i = start;
        int j = end;
        int referenceEl = i - (i - j) / 2;

        while (i < j) {
            while ((i < referenceEl) && (arr[i] <= arr[referenceEl])) i++;
            while ((j > referenceEl) && (arr[j] >= arr[referenceEl])) j--;

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                if (i == referenceEl) referenceEl = j;
                else if (j == referenceEl) referenceEl = i;
            }
        }
        sort(arr, start, referenceEl);
        sort(arr, referenceEl + 1, end);
        return arr;
    }
}
