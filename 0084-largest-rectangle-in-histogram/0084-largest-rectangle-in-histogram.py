class Solution:
    def largestRectangleArea(self, h: list[int]) -> int:
        s = []
        ans = 0
        h.append(0)
        for i,x in enumerate(h):
            while s and h[s[-1]] > x:
                j = s.pop()
                w = i if not s else i - s[-1] - 1
                ans = max(ans, h[j] * w)
            s.append(i)
        return ans

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna