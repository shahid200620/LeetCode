class Solution:
    def maxProfit(self, p: List[int]) -> int:
        min_price=p[0]
        max_profit=0
        profit=0
        for i in range(len(p)):
            if(min_price>p[i]):
                min_price=p[i]
            profit=p[i]-min_price
            if max_profit<profit:
                max_profit=profit
        return(max_profit)

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna