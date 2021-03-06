/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/

public int canCompleteCircuit(int[] gas, int[] cost) {

       int curSum = 0;
       int totalSum = 0;
       int remainingSum = 0;
       int start = 0;

       for(int i = 0; i < gas.length; i++) {
           curSum = gas[i] - cost[i];
           if(remainingSum >= 0) {
               remainingSum += curSum;
           } else {
               remainingSum = curSum;
               start = i;
           }

           totalSum += curSum;
       }

       if(totalSum >= 0) {
           return start;
       }

       return -1;
    }
