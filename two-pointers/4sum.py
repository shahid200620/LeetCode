class Solution:
    def fourSum(self, n: List[int], t: int) -> List[List[int]]:
        s=set()
        n.sort()
        for i in range(len(n)-3) :
            for j in range(i+1,len(n)-2):
                l=j+1
                r=len(n)-1
                while (l< r):
                    if n[i]+n[j]+n[l]+n[r] == t:
                        s.add(( n[i],n[j],n[l],n[r]))
                        l+=1
                        r-=1
                    elif  n[i]+n[j]+n[l]+n[r] > t:
                        r-=1
                    else:
                        l+=1
        return [ list(x) for x in s]

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna