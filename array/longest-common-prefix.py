class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        strs.sort()
        s1=strs[0]
        s2=strs[len(strs)-1]
        s=""
        for i in range(len(s1)):
            if s1[i]==s2[i]:
                s+=s1[i]
            else :
                return s
        return s

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna