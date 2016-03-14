/*
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.
*/
public int hIndex(int[] citations) {
    if(citations == null || citations.length == 0)
        return 0;

    int len = citations.length;
    int start = 0, end = len-1;
    while(start <= end) {
        int mid = (start + end)/2;
        if(citations[mid] >= len-mid) {
            end = mid-1;
        } else {
            start = mid+1;
        }
    }
    return len-start;
}
