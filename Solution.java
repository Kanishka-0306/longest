import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Use a size that can cover the full Unicode/UTF-16 code unit range.
        int[] lastSeen = new int[Character.MAX_VALUE + 1];
        Arrays.fill(lastSeen, -1);

        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            int previousIndex = lastSeen[currentChar];

            // If the character was seen in the current window, move left forward.
            if (previousIndex >= left) {
                left = previousIndex + 1;
            }

            lastSeen[currentChar] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        // Handle missing input gracefully.
        if (input == null) {
            System.out.println(0);
            return;
        }

        System.out.println(lengthOfLongestSubstring(input.trim()));
    }
}
