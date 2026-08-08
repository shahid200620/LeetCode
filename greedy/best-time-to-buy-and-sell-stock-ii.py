class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0

        # Every upward step can be taken as a separate transaction.
        # Adding all positive day-to-day gains equals the optimal total profit.
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                profit += prices[i] - prices[i - 1]

        return profit

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna