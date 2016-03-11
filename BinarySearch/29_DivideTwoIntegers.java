/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
*/
public int divide(int dividend, int divisor) {
    boolean negative = false;
    if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
        negative = true;

    if(divisor == 1) {
        return dividend;
    }
    if(divisor == -1 && dividend == Integer.MIN_VALUE) {
        return Integer.MAX_VALUE;
    }


    long b = Math.abs((long)dividend);
    long a = Math.abs((long)divisor);
    int res = 0;
    while(a <= b) {
        int count = 1;
        while (a + a <= b) {
            count += count;
            a += a;
        }
        b = b - a;
        a = Math.abs((long)divisor);
        res += count;
    }
    return negative? -res: res;


}
