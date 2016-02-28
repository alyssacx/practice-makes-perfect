/*
Valid Anagram
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;

        int[] dict = new int[26];
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            dict[index]++;
        }

        for(int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            dict[index]--;
        }

        for(int i = 0; i < dict.length; i++) {
            if(dict[i] != 0)
                return false;
        }

        return true;
    }
