class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n=list(set(nums))
        n.sort()
        # for i in range(len(n)):
        #     nums[i]=n[i]
        # nums.sort()
        return len(n)

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna