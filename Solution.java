import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Longest Substring Without Repeating Characters
 * Approach: Sliding window with last-seen indexes of Unicode code points
 *
 * Time Complexity: O(N), where N is the number of Unicode code points
 * Space Complexity: O(min(N, number of distinct code points))
 */
public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Maps each Unicode code point to its most recent code-point index.
        Map<Integer, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        int codePointIndex = 0;

        for (int offset = 0; offset < s.length();) {
            int codePoint = s.codePointAt(offset);

            Integer previousIndex = lastSeen.put(codePoint, codePointIndex);
            if (previousIndex != null && previousIndex >= left) {
                left = previousIndex + 1;
            }

            maxLength = Math.max(maxLength, codePointIndex - left + 1);
            codePointIndex++;
            offset += Character.charCount(codePoint);
        }

        return maxLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        System.out.println(lengthOfLongestSubstring(input));
    }
}
