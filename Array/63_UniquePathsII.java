/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if(obstacleGrid[0][0] == 1) {
        obstacleGrid[0][0] = 0;
    } else {
        obstacleGrid[0][0] = 1;
    }
    for(int i = 1; i < obstacleGrid[0].length; i++) {
        if(obstacleGrid[0][i] == 0) {
            obstacleGrid[0][i] = obstacleGrid[0][i-1];
        } else {
            obstacleGrid[0][i] = 0;
        }
    }
    for(int i = 1; i < obstacleGrid.length; i++) {
        if(obstacleGrid[i][0] == 0) {
            obstacleGrid[i][0] = obstacleGrid[i-1][0];
        } else {
            obstacleGrid[i][0] = 0;
        }
    }
    for(int i = 1; i < obstacleGrid.length; i++) {
        for(int j = 1; j < obstacleGrid[0].length; j++) {
            if(obstacleGrid[i][j] == 1) {
                obstacleGrid[i][j] = 0;
            } else {
                obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }
    }
    return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];

}
