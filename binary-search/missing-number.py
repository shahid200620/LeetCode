class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        v = [-1] * (n + 1)
        for num in nums:
            v[num] = num
        for i in range(len(v)):
            if v[i] == -1:
                return i
        return 0



# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna