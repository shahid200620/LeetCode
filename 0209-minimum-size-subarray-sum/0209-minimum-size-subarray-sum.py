class Solution:
    def minSubArrayLen(self, t: int, n: List[int]) -> int:
        l = 0
        s = 0
        mo = float("inf")

        for r in range(len(n)):
            s += n[r]

            while s >= t:
                mo = min(mo, r - l + 1)
                s -= n[l]
                l += 1

        return 0 if mo == float("inf") else mo

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna