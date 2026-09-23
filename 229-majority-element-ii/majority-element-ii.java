class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int c1 = 0;
        int c2=0;
        int candidate1=0;
        int candidate2=0;
        for(int arr:nums){
            if(candidate1==arr)
             c1++;
            else if(candidate2==arr)
             c2++;
            else if(c1==0){
                candidate1=arr;
                c1++;
            }
            else if(c2==0){
                candidate2=arr;
                c2++;
            }
            else{
                c1--;
                c2--;
            }
        }
        int freq1=0;
        for(int arr: nums){
            if(arr==candidate1) freq1++;
        }
        int freq2=0;
        for(int arr: nums){
            if(arr==candidate2) freq2++;
        }
        if(freq1>nums.length/3 && candidate1!=candidate2) ans.add(candidate1);
        if(freq2>nums.length/3) ans.add(candidate2);
        return ans;
    }
}