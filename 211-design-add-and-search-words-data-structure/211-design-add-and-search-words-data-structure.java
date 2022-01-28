class WordDictionary {
    private final List[] list;
    

    public WordDictionary() {
        list = new List[501];
        for (int i = 0; i < list.length; i++)
            list[i] = new LinkedList<>();
    }
    
    public void addWord(String word) {
        List<String> lst = list[word.length()];
        lst.add(word);
    }
    
    public boolean search(String word) {
        List<String> lst = list[word.length()];
        for (String wrd : lst) {
            if (compare(wrd, word))
                return true;
        }
        return false;
    }
    
    private boolean compare(String source, String pattern) {
        for (int i = 0; i < source.length(); i++) {
            char ptn = pattern.charAt(i);
            if (ptn == '.')
                continue;
            
            if (source.charAt(i) != ptn)
                return false;
        }
        return true;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */