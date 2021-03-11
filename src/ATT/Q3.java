package ATT;

public class Q3 {
    public static boolean isAnagram(String a, String b, int x) {
        String s1 = shift(a, x);
        String s2 = shift(b, x);

        return isAnagramHelper(s1, b) || isAnagramHelper(a, s2);
    }

    private static String shift(String s, int x) {
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = (char) ((arr[i] - 'a' + 26 + x) % 26 + 'a');
        }
        return new String(arr);
    }

    public static boolean isAnagramHelper(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(shift("zzcz", -1));
//        System.out.println(shift("aaad", -1));
//        System.out.println(isAnagramHelper("yyby", "aaac"));
        System.out.println(isAnagram("zzcz", "aaad", -1));
        System.out.println(isAnagram("aaad", "zzcz", -1));
        System.out.println(isAnagram("aaab", "zzcz", 2));
    }
}
