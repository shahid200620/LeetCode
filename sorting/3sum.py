class Solution:
    def threeSum(self, n: list[int]) -> list[list[int]]:
        n.sort()
        s=set()        
        for i in range(len(n)-2):
            l=i+1
            r=len(n)-1
            while l < r:
                if n[i]+n[l]+n[r] == 0:
                    s.add((n[i],n[l],n[r]))
                    l+=1
                    r-=1
                elif n[i]+n[l]+n[r]>0:
                    r-=1
                else :
                    l+=1
        return [list(x) for x in s]

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna