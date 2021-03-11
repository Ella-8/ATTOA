package ATT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q5 {
    public static List<Integer> sumOfPrimes(int number) {
        List<List<Integer>> result;
        if (number < 2) return new ArrayList<>();
        boolean[] notPrime = new boolean[number];
        for (int i = 2; i < number; i++) {
            if (notPrime[i] == false) {
                for (int j = 2; i * j < number; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        List<Integer> dic = new ArrayList<>();
        for (int i = 2; i < number; ++i) {
            if (!notPrime[i])
                dic.add(i);
        }
        result = combinationSum(dic.stream().mapToInt(i -> i).toArray(), number);
        if (result.isEmpty()) {
            return new ArrayList<>();
        } else return result.get(0);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();

        Arrays.sort(candidates);

        backtrack(candidates, comb, target, 0, results);
        return results;
    }

    private static void backtrack(int[] candidates, LinkedList<Integer> comb,
                                  Integer remain, Integer curr,
                                  List<List<Integer>> results) {
        if (remain == 0) {
            // copy the current combination to the final list.
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (int nextCurr = curr; nextCurr < candidates.length; ++nextCurr) {
            if (nextCurr > curr && candidates[nextCurr] == candidates[nextCurr - 1])
                continue;

            Integer pick = candidates[nextCurr];
            // optimization: early stopping
            if (remain - pick < 0)
                break;

            comb.addLast(pick);
            backtrack(candidates, comb, remain - pick, nextCurr + 1, results);
            comb.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(sumOfPrimes(9));
        System.out.println(sumOfPrimes(6));
        System.out.println(sumOfPrimes(5));
    }
}
