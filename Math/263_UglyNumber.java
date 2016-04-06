/*
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
*/
public boolean isUgly(int num) {

    if(num == 0)
        return false;

    if(num == 1)
        return true;

    return helper(num);
}

private boolean helper(int num) {

    if(num == 1 || num == 2 || num == 3 || num == 5)
        return true;

    if(num%2 != 0 && num%3 != 0 && num%5 != 0)
        return false;

    boolean res1 = true;
    if(num%2 == 0) {
        res1 = helper(num/2);
    }
    boolean res2 = true;
    if(num%3 == 0) {
        res2 = helper(num/3);
    }
    boolean res3 = true;
    if(num%5 == 0) {
        res3 = helper(num/5);
    }

    return res1 && res2 && res3;
}
