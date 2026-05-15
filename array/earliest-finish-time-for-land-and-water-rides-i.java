class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minTime = Integer.MAX_VALUE;
        for ( int i=0; i< landStartTime.length; i++) {
            for( int j=0; j< waterStartTime.length; j++){
                int end1=Math.max(landStartTime[i],0)+landDuration[i];
                int finish1=Math.max(waterStartTime[j],end1)+waterDuration[j];
                minTime = Math.min(minTime, finish1);
                int end2 = Math.max(waterStartTime[j],0)+waterDuration[j];
                int finish2 = Math.max(landStartTime[i],end2)+landDuration[i];
                minTime = Math.min(minTime, finish2);
            }
        }
        return minTime;
    }
}