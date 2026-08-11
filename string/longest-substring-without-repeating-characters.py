class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l = 0
        a = set()
        ans = 0

        for r in range(len(s)):
            while s[r] in a:
                a.remove(s[l])
                l += 1

            a.add(s[r])
            ans = max(ans, r - l + 1)

        return ans

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna