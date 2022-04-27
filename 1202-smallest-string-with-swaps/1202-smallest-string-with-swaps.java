class Solution {
    int n, p[];
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        n = s.length();
        p = new int[n];
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) p[i] = i;
        for (List<Integer> l : pairs) {
            union(l.get(0), l.get(1));
        }
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(find(i), k -> new PriorityQueue<>((a, b) -> a - b));
            map.get(p[i]).offer(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(p[i]).poll());
        }
        return sb.toString();
    }
    
    private int find(int i) {
        if (i != p[i]) p[i] = find(p[i]);
        return p[i];
    }
    
    private void union(int i, int j) {
        int pi = find(i), pj = find(j);
        if (pi > pj) {
            p[pi] = pj;  // p[pi] other than p[i];
        } else {
            p[pj] = pi;
        }
    }
}