/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
public List<String> letterCombinations(String digits) {

    List<String> list = new ArrayList<String>();
    if(digits == null || digits.length() == 0)
        return list;
    helper(digits, 0, "", list);
    return list;
}

private void helper(String digits, int index, String item, List<String> list) {

    if(item.length() == digits.length()) {
        list.add(item);
        return;
    }

    String letterSet = getLetters(digits.charAt(index));
    for(int i = 0; i < letterSet.length(); i++) {
        helper(digits, index+1, item+letterSet.charAt(i), list);
    }
}

private String getLetters(char c) {
    switch (c) {
        case '2':
            return "abc";
        case '3':
            return "def";
        case '4':
            return "ghi";
        case '5':
            return "jkl";
        case '6':
            return "mno";
        case '7':
            return "pqrs";
        case '8':
            return "tuv";
        case '9':
            return "wxyz";
        case '0':
        case '1':
        default:
            return "";
    }
}
