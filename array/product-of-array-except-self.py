class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        if 0 in nums:
            l = [0] * len(nums)
            if nums.count(0)==1:
                i=nums.index(0)
                nums.remove(0)
                nums[i]=math.prod(nums)
            return l
        a=math.prod(nums)
        return [a//i for i in nums]

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna