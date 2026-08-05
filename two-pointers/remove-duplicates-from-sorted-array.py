class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n=set(nums)
        nums=[[i] for i in n]
        return len(n)

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna