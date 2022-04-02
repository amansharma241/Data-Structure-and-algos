class Solution {
    public int singleNonDuplicate(int[] arr) {
       if(arr==null) return 0;
        int ans = -1;
        int lo = 0;
        int hi = arr.length-1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            ans = arr[mid];
            if(mid>0 && arr[mid]==arr[mid-1]){
                if(mid%2==0) hi = mid - 1;
                else lo = mid + 1;
            }
            else if(mid<arr.length-1 && arr[mid]==arr[mid+1]){
                if(mid%2==0) lo = mid+1;
                else hi = mid - 1;
            }
            else break;
        }
        return ans;
    }
}