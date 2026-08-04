class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        l=max(len(word1),len(word2))
        a=''
        for i in range(l):
            if i>=len(word1):
                a+=word2[i]
            elif i>=len(word2):
                a+=word1[i]
            else:
                a+=word1[i]
                a+=word2[i]
        return a

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna