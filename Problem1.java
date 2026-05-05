import java.util.*;

public class Problem1 {
    public static int maximumSum(String s) {
        int n = s.length();
        String doubled = s + s;
        Set<Character> set = new HashSet<>();
        int left = 0, sum = 0, maxSum = 0;
        for (int right = 0; right < doubled.length(); right++) {
            char ch = doubled.charAt(right);
            while (set.contains(ch) || (right - left + 1) > n) {
                char leftChar = doubled.charAt(left);
                sum -= (leftChar - 'a' + 1);
                set.remove(leftChar);
                left++;
            }

            set.add(ch);
            sum += (ch - 'a' + 1);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(maximumSum(s));
    }
}