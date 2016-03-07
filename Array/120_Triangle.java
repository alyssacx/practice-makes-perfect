/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/
public int minimumTotal(List<List<Integer>> triangle) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    for(int i = 1; i < triangle.size(); i++) {
        triangle.get(i).set(0, triangle.get(i).get(0) + triangle.get(i-1).get(0));
        for(int j = 1; j < triangle.get(i).size()-1; j++) {
            triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1)));
        }
        triangle.get(i).set(triangle.get(i).size()-1, triangle.get(i).get(triangle.get(i).size()-1) +
        triangle.get(i-1).get(triangle.get(i-1).size()-1));
    }
    int res = triangle.get(triangle.size()-1).get(0);
    for(int i = 1; i < triangle.get(triangle.size()-1).size(); i++) {
        res = Math.min(res, triangle.get(triangle.size()-1).get(i));
    }
    return res;
}
