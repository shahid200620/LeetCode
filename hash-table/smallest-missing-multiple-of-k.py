class Solution:
    def missingMultiple(self, nums: List[int], k: int) -> int:
        seen = set(nums)
        ans = k
        while ans in seen:
            ans += k
        return ans

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna