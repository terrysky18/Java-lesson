package com.EirScientific;

public class Main {

    public static int findIndex (int[] my_array, int target)
    {
        if (my_array!=null)
        {
            int len = my_array.length;
            int idx = 0;
            while (idx < len)
            {
                if (my_array[idx] == target)
                {
                    return idx;
                }
                else
                {
                    idx++;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] my_array = {25, 14, 56, 15, 36, 56, 77, 18, 29, 28, 49, 108};
        System.out.println("Index position of 25 is: " + findIndex(my_array, 25));
        System.out.println("Index position of 180 is: " + findIndex(my_array, 180));
    }
}
