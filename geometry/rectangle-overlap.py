class Solution:
    def isRectangleOverlap(self, *A) -> bool:
        (x1, y1, x2, y2), (X1, Y1, X2, Y2) = A
        return x1 < X2 and X1 < x2 and y1 < Y2 and Y1 < y2

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna