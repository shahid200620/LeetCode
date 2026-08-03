class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        s=[]
        for i in nums:
            if nums.count(i) >= k:
                s.append(i)
        l=[]
        s1=set(s)
        s2=list(s1)
        for i in range (k):
            l.append(s2[i])
        return l

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna