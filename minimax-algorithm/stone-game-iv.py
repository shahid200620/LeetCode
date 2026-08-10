class Solution:
    def winnerSquareGame(self, n: int) -> bool:
        @cache
        def dfs(i):
            if i == 0: return False

            for j in range(1, isqrt(i) + 1):
                if not dfs(i - j ** 2): return True

            return False

        return dfs(n)

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna