class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        a=[]
        for i in range(len(nums)-k+1):
            t=max(nums[i:i+k])
            a.append(t)
        return a

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna