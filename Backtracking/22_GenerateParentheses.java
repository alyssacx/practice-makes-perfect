/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public List<String> generateParenthesis(int n) {

    List<String> list = new ArrayList<String>();
    if(n <= 0)
        return list;
    generate(n, n, "", list);
    return list;
}

private void generate(int left, int right, String item, List<String> list) {

    if(right < left)
        return;

    if(left == 0 && right == 0) {
        list.add(item);
        return;
    }

    if(left > 0) {
        generate(left-1, right, item+"(", list);
    }

    if(right > 0) {
        generate(left, right-1, item + ")", list);
    }
}
