class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        for i in nums :
            if nums.count(i)==1:
                return i

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna