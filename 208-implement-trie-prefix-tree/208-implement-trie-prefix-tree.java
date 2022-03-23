class Trie {
    class Node{
        char c;
        boolean eow;
        Node[] arr = new Node[26];
        
        public Node(char c){
            this.c  = c;
        }
    }
     Node root;
    public Trie() {
         root = new Node(' ');
    }
    
    public void insert(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char curr = word.charAt(i);
            
            if(temp.arr[curr-'a']==null){
                Node tobeAdded = new Node(curr);
                temp.arr[curr-'a'] = tobeAdded;
            }
            temp = temp.arr[curr-'a'];
        }
        temp.eow = true;
    }
    
    public boolean search(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char curr = word.charAt(i);
            if(temp.arr[curr-'a']==null) return false;
            temp = temp.arr[curr-'a'];
        }
        if(temp.eow==true) return true;
        else return false;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;
        for(int i=0;i<prefix.length();i++){
            char curr = prefix.charAt(i);
            
            if(temp.arr[curr-'a']==null) return false;
            temp = temp.arr[curr-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */