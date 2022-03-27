class Solution {
    public int [][] merge(int [][] intervals){
        ArrayList<int []> list = new ArrayList<>();
        int [] st = new int [intervals.length];
        int [] et = new int [intervals.length];
        
        for(int i=0;i<intervals.length;i++){
            st[i] = intervals[i][0];
            et[i] = intervals[i][1];
        }
        Arrays.sort(st);
        Arrays.sort(et);
        
        int ptr = 0;
        int j = 0;
        
        while(ptr<intervals.length-1){
            if(et[ptr]>=st[ptr+1]) ptr++;
            else{
                int [] tempans = new int[2];
                tempans[0] = st[j];
                tempans[1] = et[ptr];
                list.add(tempans);
                j = ptr+1;
                ptr++;
            }
        }
        int [] arr = new int [2];
        arr[0] = st[j];
        arr[1] = et[ptr];
        list.add(arr);
        
        return list.toArray(new int[list.size()][2]);
    }
}