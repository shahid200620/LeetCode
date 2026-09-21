class Solution:
    def maxProfit(self, p: List[int]) -> int:
        m = p[0]
        ans = 0
        for x in p:
            m = min(m, x)
            ans = max(ans, x-m)
        return ans

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna