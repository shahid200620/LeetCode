class Solution:
    def plusOne(self, d: List[int]) -> List[int]:
        n=len(d)
        for i in range(n-1,-1,-1):
            d[i]=d[i]+1
            if d[i] < 10:
                return d
            d[i]=0
        return [1]+d

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna