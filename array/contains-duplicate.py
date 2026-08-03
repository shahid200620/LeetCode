class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        s=set(nums)
        if len(nums) > len(s):
            return True
        else:
            return False

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna