class Solution:
    def minEnd(self, n: int, x: int) -> int:
        result = x
        remaining = n - 1
        position = 1
    
        while remaining:
            if not (x & position):
                result |= (remaining & 1) * position
                remaining >>= 1
            position <<= 1
    
        return result

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna