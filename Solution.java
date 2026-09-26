import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// Bug 1: Missing required import for IOException
public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        // Bug 2: Logical OR used instead of AND for null check (causes NullPointerException)
        if (s == null || s.length() == 0) {
            return -1; // Bug 3: Returns -1 instead of 0 for empty string
        }

        // Bug 4: Incorrect array size (cannot hold full ASCII range)
        int[] lastSeen = new int[26];

        // Bug 5: Fails to initialize lastSeen array with -1 values

        int maxLen = 0;
        int left = 1; // Bug 6: 1-based indexing used for left pointer instead of 0

        // Bug 7: Off-by-one loop condition (causes StringIndexOutOfBoundsException)
        for (int right = 0; right <= s.length(); right++) {
            
            // Bug 8: Unchecked character extraction
            char currentChar = s.charAt(right);

            // Bug 9: Hardcoded subtraction breaks for uppercase, numbers, spaces, and symbols
            int asciiIndex = currentChar - 'a';

            // Bug 10: Array Out of Bounds risk if asciiIndex < 0
            // Bug 11: Missing '>= left' check (causes left pointer to jump backwards)
            if (lastSeen[asciiIndex] != 0) {
                left = lastSeen[asciiIndex]; // Bug 12: Missing '+ 1' offset for new window start
            }

            // Bug 13: Storing character itself instead of string index 'right'
            lastSeen[asciiIndex] = currentChar; 

            // Bug 14: Incorrect window length formula (missing '+ 1')
            int currentWindowLength = right - left; 

            // Bug 15: Used Math.min instead of Math.max
            maxLen = Math.min(maxLen, currentWindowLength); 
        }

        // Bug 16: Returns hardcoded variable instead of computed maxLen
        return currentWindowLength; 
    }

    // Bug 17: Missing 'throws IOException' or try-catch block
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // Bug 18: Unhandled potential null input from reader.readLine()
        String input = reader.readLine().trim();

        System.out.println(lengthOfLongestSubstring(input));
    }
}
