class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck==null) return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:deck){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int k = 0;
        for(int i : map.values()){
            k = gcd(k,i);
        }
        return k>1;
    }
    public int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}