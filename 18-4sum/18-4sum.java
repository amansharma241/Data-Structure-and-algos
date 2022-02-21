class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
//         List<List<Integer>> res = new ArrayList<>();
//         int n = nums.length;
//         if(n<4) return res;
        
//         Arrays.sort(nums);
        
//         for(int i=0;i<n;i++){
//             int vali = nums[i];
//             for(int j = i+1;j<n;j++){
//                 int valj = nums[j];
//                 int lo  = j+1;
//                 int hi = n-1;
//                 int reqtarget = vali + valj + nums[lo] + nums[hi];
//                 while(lo<hi){
//                     if(reqtarget<target ) lo++;
//                     else if(reqtarget>target) hi--;
                    
//                     else{
//                         ArrayList<Integer> temp = new ArrayList<>();
//                         temp.add(vali);
//                         temp.add(valj);
//                         temp.add(nums[lo]);
//                         temp.add(nums[hi]);
//                         res.add(temp);
                        
//                         while(lo<hi && nums[lo]==nums[lo+1]) lo++;
//                         while(lo<hi && nums[hi]==nums[hi-1]) hi--;
//                     }
//                 }
//                 while(j+1<n && nums[j]==nums[j+1]) j++;
//             }
//             while(i+1<n && nums[i]==nums[i+1]) i++;
//         }
//         return res;
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (num == null || num.length == 0)
            return res;
        
        int n = num.length;
    
        Arrays.sort(num); 
    
        for (int i = 0; i < n; i++) {
        
            int target_3 = target - num[i];
        
            for (int j = i + 1; j < n; j++) {
            
                int target_2 = target_3 - num[j];
            
                int front = j + 1;
                int back = n - 1;
            
                while(front < back) {
                
                    int two_sum = num[front] + num[back];
                
                    if (two_sum < target_2) front++;
                
                    else if (two_sum > target_2) back--;
                
                    else {
                    
                        List<Integer> quad = new ArrayList<>(); 
                        quad.add(num[i]);
                        quad.add(num[j]);
                        quad.add(num[front]);
                        quad.add(num[back]);
                        res.add(quad);
                    
                        // Processing the duplicates of number 3
                        while (front < back && num[front] == quad.get(2)) ++front;
                    
                        // Processing the duplicates of number 4
                        while (front < back && num[back] == quad.get(3)) --back;
                
                    }
                }
                
                // Processing the duplicates of number 2
                while(j + 1 < n && num[j + 1] == num[j]) ++j;
            }
        
            // Processing the duplicates of number 1
            while (i + 1 < n && num[i + 1] == num[i]) ++i;
        
        }
        
    
        return res;
    }
}