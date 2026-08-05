class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n=set(nums)
        for i in range(len(n)):
            nums[i]=n[i]
        return len(n)

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna