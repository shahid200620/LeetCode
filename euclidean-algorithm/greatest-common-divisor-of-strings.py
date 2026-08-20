class Solution:
    def gcdOfStrings(self, s1: str, s2: str) -> str:
        if s1+s2 != s2+s1:
            return ""
        g=math.gcd(len(s1),len(s2))
        s=s1[:g]
        return s

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna