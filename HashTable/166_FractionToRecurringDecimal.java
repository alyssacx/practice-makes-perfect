/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/
public String fractionToDecimal(int numerator, int denominator) {

    if(numerator == 0)
        return "0";

    String res = "";
    if(numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0)
        res = "-";

    long numer = Math.abs((long)numerator);
    long den = Math.abs((long)denominator);
    res += Long.toString(numer/den);

    long a = numer%den;
    if(a == 0) {
        return res;
    }

    String fractionPart = "";
    HashMap<Long, Integer> map = new HashMap<Long, Integer>();
    int digitPos = 0;
    while(a != 0) {
        if(!map.containsKey(a)) {
            map.put(a, digitPos++);
        } else {
            int repeatPos = map.get(a);
            return res + "." + fractionPart.substring(0, repeatPos) + "(" + fractionPart.substring(repeatPos) + ")";
        }
        long num = a * 10/den;
        fractionPart += Long.toString(num);
        a = (a * 10)%den;
    }
    return res + "." + fractionPart;
}
