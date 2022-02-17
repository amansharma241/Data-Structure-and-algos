class Solution {
    public int majorityElement(int[] nums) {
      // hum is question mein distinct elements ki pairing krenge. jo last mein unpaired reh jaega wo
       //hoga majority element.
        
        int val = nums[0]; // assume this is our majority element.
        int count = 1;
        
        for(int i = 1;i<nums.length;i++){
            if(val==nums[i]) count++; // we will increase the count jisse ho skega ki shayad ye maj element ho
            else if(count==0){ // pairing ho chuki sbki ab jo aaega wo potential maj element hoga.
                val = nums[i];
                count=1;
            }
            else count--; //hume pata chala ki element val ke equal nhi hai aur count 0 nhi hai mtlb pairing 
            // krdo iski. pairing hui kaise
            // dekho jo maj element man rkha tha, uska count kam kr diya and jiske sath pairing krni thi
            //i.e. arr[i] uspe se cursor hata ke i++ kr diya, which means maj element ka count km kr diya
            // and i++ krke arr[i] ko bhul gaye . so hypothetically inki pairing hi gayi.
        }
        return val;
    }
}