/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
*/
public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0)
            return list;

        Arrays.sort(strs);
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String newStr = new String(charArr);
            if(map.containsKey(newStr)) {
                map.get(newStr).add(strs[i]);
            } else {
                List<String> item = new ArrayList<String>();
                item.add(strs[i]);
                map.put(newStr, item);
            }
        }
        for(List<String> item : map.values()) {
            list.add(item);
        }
        return list;
    }
