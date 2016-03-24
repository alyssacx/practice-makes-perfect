/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/
public List<List<String>> partition(String s) {

    List<List<String>> list = new ArrayList<List<String>>();
    if(s == null || s.length() == 0)
        return list;

    boolean[][] dict = new boolean[s.length()][s.length()];
    for(int i = 0; i < s.length(); i++) {
        for(int j = 0; j <= i; j++) {
            if(s.charAt(i) == s.charAt(j)) {
                if(i-j <= 2 || dict[j+1][i-1])
                    dict[j][i] = true;
            }
        }
    }
    helper(s, 0, new ArrayList<String>(), list, dict);
    return list;
}

private void helper(String s, int index, List<String> item, List<List<String>> list, boolean[][] dict) {

    if(index == s.length()) {
        list.add(new ArrayList<String>(item));
        return;
    }

    for(int i = index; i < s.length(); i++) {
        if(dict[index][i]) {
            item.add(s.substring(index, i+1));
            helper(s, i+1, item, list, dict);
            item.remove(item.size()-1);
        }
    }
}
