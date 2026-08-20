class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        res=0
        for i in nums :
            res=i^res
        return res

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna