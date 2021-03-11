package ATT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q1 {
    // largest number,  second largest, smallest number, second smallest, Third largest, fourth largest, third smallest, fourth smallest
    public static List<Integer> funnySort(List<Integer> unsorted){
        Collections.sort(unsorted);
        int n = unsorted.size();
        int i = 0, j = n - 1;
        int count = 0, flag = 2;
        List<Integer> list = new ArrayList<>();
        while (i <= j){
            if (count < 2){
                list.add(unsorted.get(j));
                j--;
                count++;
                if (count == 2) flag = 0;
                continue;
            }
            if (flag < 2){
                list.add(unsorted.get(i));
                i++;
                flag++;
                if (flag == 2) count = 0;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> input1 = Arrays.asList(1, 7, 2, 3, 19, 5);
        List<Integer> input2 = Arrays.asList(2, 3, 4, 6, 17, 5);
        List<Integer> input3 = Arrays.asList(8, 1, 2, 3, 10);
        List<Integer> input4 = Arrays.asList(1, 2, 3, 4, 5, 6, 15);
        System.out.println(funnySort(input1));
        System.out.println(funnySort(input2));
        System.out.println(funnySort(input3));
        System.out.println(funnySort(input4));
    }
}
