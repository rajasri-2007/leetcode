class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int acount=0;
        int count=0;
        for(int i=0; i<nums.length; i++){
          if(nums[i]==0){
            if(count>=acount){
                acount=count;
            }
                count=0;            
          }else
             count++;
        }
        if(count>acount)
         acount=count;
        return acount;
    }
}