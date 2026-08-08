class Solution:
    def numRescueBoats(self, p: List[int], limit: int) -> int:
        p.sort()
        i=0
        j=len(p)-1
        c=0
        while i<=j:
            if p[i]+p[j] <= limit:
                i+=1
                j-=1
                c+=1
            else :
                j-=1
                c+=1
        return c

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna