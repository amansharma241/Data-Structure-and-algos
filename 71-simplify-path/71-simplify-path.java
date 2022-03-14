class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        
        int i = 1;
        while(i < path.length()) {
            int nextSlash = path.indexOf('/',i);
            if(nextSlash == -1)
                nextSlash = path.length();
            String next = path.substring(i, nextSlash) ;
            if(next.length() == 0 || ".".equals(next)) {
                i = nextSlash + 1;
                continue;
            }
            else if("..".equals(next)) {
                if(!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(next);
            i = nextSlash + 1;
        }
        
        while(!stack.isEmpty()) {
            sb.insert(0,stack.pop());
            sb.insert(0,"/");
        }
        return sb.length() > 0 ? sb.toString() : "/";
    
    }
}