package com.EirScientific;
import java.util.Arrays;

public class Main {

    public static int[] removeElement (int[] my_array, int remove_idx)
    {
        int[] result_array = Arrays.copyOf(my_array);
        for (int idx = remove_idx; idx < result_array.length-1; idx++)
        {
            result_array[idx] = result_array[idx + 1];
        }
        return result_array;
    }

    public static void main(String[] args) {
	    int[] my_array = {25, 14, 18, 39, 56, 36, 68, 77, 29, 109, 274};
	    int[] new_array = removeElement(my_array, 0);

	    System.out.println("old array: " + Arrays.toString(my_array));
	    System.out.println("new array: " + Arrays.toString(new_array));
    }
}
