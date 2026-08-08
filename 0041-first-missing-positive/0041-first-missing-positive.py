class Solution:
    def firstMissingPositive(self, nums):
        n = len(nums)
        seen = [False] * (n + 1)

        for num in nums:
            if 0 < num <= n:
                seen[num] = True

        for i in range(1, n + 1):
            if not seen[i]:
                return i

        return n + 1

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna