/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
public int[][] generateMatrix(int n) {

    int[][] res = new int[n][n];
    int num = 1;

    for(int k = 0; k <= n/2; k++) {
        int row = k;
        int col = k;

        if(col == n-1-k) {
            res[row][col] = num++;
            break;
        }
        while(col < n-1-k) {
            res[row][col++] = num++;
        }
        while(row < n-1-k) {
            res[row++][col] = num++;
        }
        while(col > k) {
            res[row][col--] = num++;
        }
        while(row > k) {
            res[row--][col] = num++;
        }
    }
    return res;
}
