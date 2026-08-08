class Solution:
    def calPoints(self, o: List[str]) -> int:
        l=[]
        for i in o:
            if i == "D":
                l.append(l[-1]*2)
            elif i=="C":
                l.pop()
            elif i=="+":
                l.append(l[-1]+l[-2])
            else :
                l.append(int(i))
        return sum(l)

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna