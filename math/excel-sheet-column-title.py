class Solution:
    def convertToTitle(self, c: int) -> str:
        r=''
        while c>0:
            c-=1
            rem=c%26
            r=chr(ord("A"))+r
            c=c//26
        return r

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna