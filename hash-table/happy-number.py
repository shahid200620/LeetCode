def co(n):
        s=0
        while (n>=10):
            r=n%10
            s+=(r*r)+s
            n=n//10
        return s+(n*n)
class Solution:
    def isHappy(self, n: int) -> bool:
        if n!=1 and n<9:
            return False
        while (n >=10):
            n= co(n)
        if n==1:
            return True
        else:
            return False

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna