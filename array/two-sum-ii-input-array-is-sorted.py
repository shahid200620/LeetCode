class Solution:
    def twoSum(self, n: List[int], t: int) -> List[int]:
        d={}
        for i in n:
            if t-n[i] in d:
                return [d[t-n[i]]+1,i+1]
            d[t-n[i]]=i

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna