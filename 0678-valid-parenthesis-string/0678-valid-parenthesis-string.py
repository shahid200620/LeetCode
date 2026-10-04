class Solution:
    def checkValidString(self, s: str) -> bool:
        l = h = 0

        for c in s:
            l += ((c == '(') << 1) - 1
            h += ((c != ')') << 1) - 1

            if h < 0: return False

            l = max(l, 0)

        return l == 0

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna