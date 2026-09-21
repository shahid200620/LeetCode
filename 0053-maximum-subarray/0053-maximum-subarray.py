class Solution:
    def maxSubArray(self, n: list[int]) -> int:
        t_s=n[0]
        m_s=n[0]
        for i in n[1:]:
            t_s=max(i,t_s +i)
            m_s=max(t_s , m_s)
        return m_s

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna