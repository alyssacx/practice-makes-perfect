/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public int evalRPN(String[] tokens) {

    if(tokens == null || tokens.length == 0)
        return 0;

    Stack<Integer> stack = new Stack<Integer>();
    for(int i = 0; i < tokens.length; i++) {
        if(tokens[i].equals("+") || tokens[i].equals("*") || tokens[i].equals("-") || tokens[i].equals("/")) {
            int val1 = stack.pop();
            int val2 = stack.pop();
            if(tokens[i].equals("+")) {
                stack.push(val1 + val2);
            }
            if(tokens[i].equals("-")) {
                stack.push(val2-val1);
            }
            if(tokens[i].equals("/")) {
                stack.push(val2/val1);
            }
            if(tokens[i].equals("*")) {
                stack.push(val1 * val2);
            }
        } else {
            stack.push(Integer.parseInt(tokens[i]));
        }
    }
    return stack.pop();

}  
