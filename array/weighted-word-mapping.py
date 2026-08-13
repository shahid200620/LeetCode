class Solution:
    def mapWordWeights(self, w: List[str], we: List[int]) -> str:
        r=""
        for i in w:
            s=0
            for j in range(len(i)):
                s+=we[ord(i[j])-97]
            s=s%26
            r+=chr(97+25-s)
        return r

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna