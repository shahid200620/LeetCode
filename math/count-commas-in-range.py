class Solution:
    def countCommas(self, n: int) -> int:
        res = 0
        for a in range(1, n + 1):
            if a > 999:
                res += 1
        return res
        

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna