import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: Longest Substring Without Repeating Characters
 * Approach: Optimized Sliding Window using ASCII Direct Index Mapping
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class Solution {
    
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Stores the last seen index of each ASCII character
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);

        int maxLen = 0;
        int left = 0; // Left pointer of the sliding window

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character was seen inside the active window, shift the left pointer
            if (lastSeen[currentChar] >= left) {
                left = lastSeen[currentChar] + 1;
            }

            // Record/update the character's latest index
            lastSeen[currentChar] = right;

            // Calculate current window length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        if (input == null) {
            System.out.println(0);
            return;
        }

        System.out.println(lengthOfLongestSubstring(input));
    }
}
