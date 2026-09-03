class Solution:
    def uniformArray(self, nums1: list[int]) -> bool:
        mn = nums1[0]
        hasOdd = False
        for v in nums1:
            if v < mn:
                mn = v
            if v & 1:
                hasOdd = True
        if mn & 1:
            return True
        return not 

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna