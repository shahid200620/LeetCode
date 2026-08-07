class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        k=len(s1)
        s1=sorted(s1)
        s4="".join(s1)
        for i in range(len(s2)-k+1):
            l=[]
            for j in range(i,i+k):
                l.append(s2[j])
            s="".join(l)
            s=sorted(s)
            s3="".join(s)
            if s3 == s4:
                return True
        return False

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna