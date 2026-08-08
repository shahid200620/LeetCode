class Solution:
    def isPalindrome(self, s: str) -> bool:
        s1=""
        for i in s:
            if i.isalnum():
                s1+=i
        s1=s1.lower()
        s2="".join(reversed(s1))
        # print(s1)
        if s2 == s1:
            return True
        
        else :
            return False

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna