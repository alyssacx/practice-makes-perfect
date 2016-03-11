/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/
public int mySqrt(int x) {
    int start = 1;
    int end = x;
    while(start <= end) {
        int mid = (start + end)/2;
        if(x/(mid+1)-1 < mid && mid <= x/mid) {
            return mid;
        } else if (mid > x/mid) {
            end = mid-1;
        } else {
            start = mid+1;
        }
    }
    return 0;

}
