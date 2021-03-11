package ATT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q4 {
    private static int max_sum = Integer.MIN_VALUE;
    private static List<Integer> result = new ArrayList<>();

    public static List<Integer> highestSumList(List<List<Integer>> lst) {
        dfs(lst, 0, 0, 0, new ArrayList<>());
        return result;
    }

    public static void dfs(List<List<Integer>> lst, int row, int col, int sum, List<Integer> track) {
        if (row == lst.size()) return;
        sum += lst.get(row).get(col);
        track.add(lst.get(row).get(col));
        if (row == lst.size() - 1) {
            if (sum > max_sum) {
                max_sum = sum;
                result = new ArrayList<>(track);
            }
        }
        dfs(lst, row + 1, col, sum, track);
        dfs(lst, row + 1, col + 1, sum, track);
        sum -= lst.get(row).get(col);
        track.remove(track.size() - 1);
    }

    public static void main(String[] args) {
        List<List<Integer>> lst = new ArrayList<>();
        lst.add(Arrays.asList(1, 0, 0, 0));
        lst.add(Arrays.asList(2, 5, 0, 0));
        lst.add(Arrays.asList(3, 2, 1, 0));
        lst.add(Arrays.asList(1, 3, 2, 1));
        System.out.println(highestSumList(lst));
    }
}
