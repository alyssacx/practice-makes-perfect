/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/
public List<String> findRepeatedDnaSequences(String s) {
    List<String> list = new ArrayList<String>();
    HashMap<String, Boolean> map = new HashMap<String, Boolean>();
    for(int i = 0; i <= s.length()-10; i++) {
        String seq = s.substring(i, i+10);
        if(map.containsKey(seq)) {
            if(!map.get(seq)) {
                list.add(seq);
                map.put(seq, true);
            }
        } else {
            map.put(seq, false);
        }
    }
    return list;
}
