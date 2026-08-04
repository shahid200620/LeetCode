import math
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        l=[]
        for i in range (len(nums)):
            t=nums[i]
            nums.pop(i)
            l.append(math.prod(nums))
            nums.insert(i,t)
        return l

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna