/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/
public List<Integer> spiralOrder(int[][] matrix) {
   List<Integer> list = new ArrayList<Integer>();
   if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
       return list;
   int row = matrix.length;
   int col = matrix[0].length;
   int i = 0;
   int j = 0;

   while(row > 0 && col > 0) {
       if(row == 1) {
           while(col > 0) {
               list.add(matrix[i][j++]);
               col--;
           }
           break;
       }

       if(col == 1) {
           while(row > 0) {
               list.add(matrix[i++][j]);
               row--;
           }
           break;
       }

       int rnum = row-1;
       int cnum = col-1;
       while(cnum > 0) {
           list.add(matrix[i][j++]);
           cnum--;
       }

       while(rnum > 0) {
           list.add(matrix[i++][j]);
           rnum--;
       }

       rnum = row-1;
       cnum = col-1;
       while(cnum > 0) {
           list.add(matrix[i][j--]);
           cnum--;
       }

       while(rnum > 0) {
           list.add(matrix[i--][j]);
           rnum--;
       }

       row = row-2;
       col = col-2;
       i++;
       j++;
   }
   return list;
}
