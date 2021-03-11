package ATT;

import java.util.Arrays;
import java.util.List;

public class Q2 {
    public static List<Integer> distantODDNumbers(List<Integer> nums){
        int count = 0;
        int index;
        int temp = 0;
        for(int i = 0; i < nums.size(); i++){
            if(nums.get(i) %2 == 1){
                count++;
                index = getIndex(count, nums.size());
                temp = nums.get(index);
                nums.set(index, nums.get(i));
                nums.set(i, temp);
            }
        }
        return nums;
    }
    public static int getIndex(int count , int size){
        int res = 0;
        if(count == 1) return 0;
        if(count == 2) return size-1;
        for(int i = 3; i< size-1; i++){
            res = (size - 1)/2;
        }
        return res;
    }
    public static void main(String[] args) {
        List<Integer> input1 = Arrays.asList(4, 3, 5, 2, 3, 8);
        List<Integer> input2 = Arrays.asList(9, 2, 3, 3, 4);
        System.out.println(distantODDNumbers(input1));
        System.out.println(distantODDNumbers(input2));
    }
}
