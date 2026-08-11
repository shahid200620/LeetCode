class Solution:
    def minSubArrayLen(self, t: int, n: List[int]) -> int:
        l=0
        r=1
        o=0
        mo=float("inf")
        s=n[0]+n[1]
        n.sort()
        if sum(n)<t:
            return 0
        if n[0]==t:
            return 1
        while l<=r and r<len(n)-1:
            if s>=t:
                o=r-l+1
                mo=min(o,mo)
                s-=n[l]
                l+=1
            else :
                r+=1
                s+=n[r]
        return mo

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna