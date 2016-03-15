/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/
public int lengthOfLongestSubstring(String s) {
    if(s == null || s.length() == 0)
        return 0;
    int left = 0;
    int right = 0;
    int maxLen = 0;
    HashSet<Character> set = new HashSet<Character>();
    while(right < s.length()) {
        if(!set.contains(s.charAt(right))) {
            set.add(s.charAt(right));
        } else {
            maxLen = Math.max(maxLen, right-left);
            while(s.charAt(left) != s.charAt(right)) {
                set.remove(s.charAt(left));
                left++;
            }
            left++;
        }
        right++;
    }
    maxLen = Math.max(maxLen, right-left);
    return maxLen;
}
