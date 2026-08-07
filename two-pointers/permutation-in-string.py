class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        k=len(s1)
        s1=sorted(s1)
        for i in range(len(s2)-k):
            l=[]
            l.append(s2[i])
            l.append(s2[i])
            l.append(s2[i])
            s="".join().l
            s=sorted(s)
            if s == s1:
                return True
        return False


# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna