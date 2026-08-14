class Solution:
    def maximumLengthSubstring(self, s: str) -> int:
        n = len(s)
        res = 0
        for left in range(n):
            count = [0] * 26
            for right in range(left, n):
                ch = ord(s[right]) - ord("a")
                count[ch] += 1
                if count[ch] > 2:
                    break
                res = max(res, right - left + 1)
        return res

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna