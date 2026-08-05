class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        n=list(set(nums))
        n.sort()
        tm=0
        m=0
        if len(n)==0:
            return 0
        for i in range(1,len(n)):
            if n[i-1]==n[i]-1:
                m+=1
            else :
                tm=max(m,tm)
                m=0
        tm=max(m,tm)
        return tm+1

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna