/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/

public int candy(int[] ratings) {

    int[] candyNum = new int[ratings.length];
    candyNum[0] = 1;
    for(int i = 1; i < ratings.length; i++) {
        if(ratings[i] > ratings[i-1]) {
            candyNum[i] = candyNum[i-1] + 1;
        } else {
            candyNum[i] = 1;
        }
    }

    for(int i = ratings.length-2; i >= 0; i--) {
        if(ratings[i] > ratings[i+1]) {
            candyNum[i] = Math.max(candyNum[i], candyNum[i+1]+1);
        }
    }

    int total = 0;
    for(int i = 0; i < ratings.length; i++) {
        total += candyNum[i];
    }
    return total;

}
