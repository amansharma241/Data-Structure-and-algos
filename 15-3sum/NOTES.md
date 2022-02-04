step 1 array ko sort krle.
step 2 for loop laga and for every i find the duet which satisfies nums[i] + nums[lo] + nums[hi] = 0. ye hoga using two sum problem for sorted array.
step 3 if found the correct combination then add the triplet into an arraylist and add the arraylist into main list;
​
important;
to avoid duplicacy we will have to write some more conditions, like
while(lo<hi && nums[lo]==nums[lo+1]) lo++;
while(lo<hi && nums[hi]==nums[hi-1]) hi--;