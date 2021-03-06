/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/
public boolean searchMatrix(int[][] matrix, int target) {
    int top = 0;
    int bottom = matrix.length-1;
    while(top <= bottom) {
        int mid = (top + bottom)/2;
        if(matrix[mid][0] == target) {
            return true;
        } else if (matrix[mid][0] > target) {
            bottom = mid-1;
        } else {
            top = mid+1;
        }
    }
    if(bottom < 0)
      return false;
    int row = bottom;
    int left = 0;
    int right = matrix[0].length-1;
    while(left <= right) {
        int mid = (left + right)/2;
        if(matrix[row][mid] == target) {
            return true;
        } else if (matrix[row][mid] > target) {
            right = mid-1;
        } else {
            left = mid+1;
        }
    }
    return false;
}
