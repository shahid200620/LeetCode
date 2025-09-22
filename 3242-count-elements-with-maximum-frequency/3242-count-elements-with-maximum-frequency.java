class Solution {
    public int maxFrequencyElements(int[] nums) {
        int [] freq=new int[101];
        int maxf=0;
        for(int num : nums){
            freq[num]++;
            maxf=Math.max(freq[num],maxf);
        }
        int ans=0;
        for(int i=1;i<=100;i++){
            if(maxf==freq[i]){
                ans+=freq[i];
            }
        }
        return ans;
    }
}