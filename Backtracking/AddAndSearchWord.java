public class WordDictionary {

    HashSet<String> set;

    public WordDictionary() {
        set = new HashSet<String>();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        if(!set.contains(word)) {
            set.add(word);
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {

        if(set.contains(word)) {
            return true;
        }

        if(word.contains(".")) {
            char[] arr = word.toCharArray();
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] != '.')
                    continue;
                for(char c= 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String str = new String(arr);
                    if(search(str)) {
                        return true;
                    }
                    arr[i] = '.';
                }
            }
        }

        return false;

    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
