/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/
public boolean searchMatrix(int[][] matrix, int target) {

    int start = 0;
    int end = matrix.length-1;
    while(start <= end) {
        int mid = (start+end)/2;
        if(matrix[mid][0] == target) {
            return true;
        } else if(matrix[mid][0] < target) {
            start = mid+1;
         } else {
            end = mid-1;
         }
    }

    int row = end;
    if(row == -1)
        return false;

    start = 0;
    end = matrix[0].length-1;
    while(start <= end) {
        int mid = (start +end)/2;
        if(matrix[0][mid] == target) {
            return true;
        } else if(matrix[0][mid] > target) {
            end = mid-1;
        } else {
            start = mid+1;
        }
    }
    int column = end;
    if(column == -1)
        return false;

    start = 0;
    end = matrix.length-1;
    while(start <= end) {
        int mid = (start +end)/2;
        if(matrix[mid][column] == target) {
            return true;
        } else if (matrix[mid][column] > target) {
            end = mid-1;
        } else {
            start = mid+1;
        }
    }

    int row2 = start;
    if(row2 == matrix.length)
        return false;

    start = 0;
    end = matrix[0].length-1;
    while(start <= end) {
        int mid = (start+end)/2;
        if(matrix[row][mid] == target) {
            return true;
        } else if(matrix[row][mid] > target) {
            end = mid-1;
        } else {
            start = mid+1;
        }
    }

    int column2 = start;
    if(column2 == matrix[0].length)
        return false;

    for(int i = Math.min(row, row2); i <= Math.max(row, row2); i++) {
        for(int j = Math.min(column, column2); j <= Math.max(column, column2); j++) {
            if(target == matrix[i][j])
                return true;
        }
    }
    return false;
}
