/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
*/
public List<Integer> diffWaysToCompute(String input) {

    if(input == null || input.length() == 0)
        return new ArrayList<Integer>();
    List<Integer> list = calculate(0, input.length()-1, input);
    return list;
}

private List<Integer> calculate(int start, int end, String input) {
    List<Integer> list = new ArrayList<Integer>();

    for(int i = start+1; i < end; i++) {
        if(input.charAt(i) != '+' && input.charAt(i) != '-' && input.charAt(i) != '*')
            continue;
        List<Integer> part1 = calculate(start, i-1, input);
        List<Integer> part2 = calculate(i+1, end, input);
        if(input.charAt(i) == '+') {
            for(int j = 0; j < part1.size(); j++) {
                for(int k = 0; k < part2.size(); k++) {
                    list.add(part1.get(j) + part2.get(k));
                }
            }
        } else if (input.charAt(i) == '*') {
            for(int j = 0; j < part1.size(); j++) {
                for(int k = 0; k < part2.size(); k++) {
                    list.add(part1.get(j) * part2.get(k));
                }
            }
        } else {
            for(int j = 0; j < part1.size(); j++) {
                for(int k = 0; k < part2.size(); k++) {
                    list.add(part1.get(j) - part2.get(k));
                }
            }
        }
    }
    if(list.size() == 0)
        list.add(Integer.parseInt(input.substring(start, end+1)));
    return list;

}
