/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/
public List<String> restoreIpAddresses(String s) {
    //A valid IP:
    //four parts
    //each part is from 0-255, length < 3
    //each part can not be like 021

    List<String> list = new ArrayList<String>();
    if(s == null || s.length() == 0)
        return list;
    helper(s, 0, new ArrayList<String>(), list);
    return list;
}

private void helper(String s, int index, List<String> item, List<String> list) {

    if(index == s.length()) {
        if(item.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < item.size(); i++) {
                sb.append(item.get(i));
                sb.append('.');
            }
            sb.deleteCharAt(sb.length()-1);
            list.add(sb.toString());
        }
        return;
    }

    if(item.size() == 4) {
        return;
    }

    for(int i = index; i < s.length(); i++) {
        String str = s.substring(index, i+1);
        if(isValid(str)) {
            item.add(str);
            helper(s, i+1, item, list);
            item.remove(item.size()-1);
        }
    }
}

private boolean isValid(String s) {

    if(s.length() > 1 && s.charAt(0) == '0')
        return false;
    if(s.length() > 3)
        return false;

    int num = Integer.parseInt(s);
    if(num < 0 || num > 255)
        return false;

    return true;
}
