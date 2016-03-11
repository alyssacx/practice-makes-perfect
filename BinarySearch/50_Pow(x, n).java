/*
Implement pow(x, n).
*/
public double myPow(double x, int n) {
    if(n == 0)
        return 1.0;

    double value = myPow(x, Math.abs(n)/2);
    if(n%2 == 0) {
        if(n > 0) {
            return value * value;
        } else {
            return 1/(value * value);
        }
    } else {
        if(n > 0) {
            return value * value * x;
        } else {
            return 1/(value * value * x);
        }
    }
}
