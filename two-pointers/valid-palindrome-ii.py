class Solution:
    def validPalindrome(self, s: str) -> bool:
        l=0
        r=len(s)-1
        if s ==s[::-1]:
            return True
        while s[l]==s[r]:
            l+=1
            r-=1
        return s[l:r] == s[l:r][::-1] or s[l+1:r+1] == s[l+1:r+1][::-1]

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna