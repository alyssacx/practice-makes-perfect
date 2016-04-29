/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

public int numDecodings(String s) {

    if(s == null || s.length() == 0)
        return 0;

    int[] count = new int[s.length()+1];
    count[0] = 1;
    for(int i = 0; i < s.length(); i++) {
        if(s.charAt(i) == '0') {
            if(i == 0)
                return 0;
            if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
                count[i+1] = count[i-1];
                continue;
            } else {
                return 0;
            }

        }
        count[i+1] = count[i];
        if(i > 0) {
            String str = s.substring(i-1, i+1);
            int value = Integer.parseInt(str);
            if(value > 10 && value <= 26) {
                count[i+1] += count[i-1];
            }
        }

    }

    return count[s.length()];

}
