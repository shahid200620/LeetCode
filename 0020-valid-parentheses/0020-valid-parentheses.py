class Solution:
    def isValid(self, s: str) -> bool:
        hashmap = {']':'[','}':'{',')':'('}
        stack = []
        for c in s:
            if c in hashmap:
                if not stack:
                    return False
                if stack[-1] != hashmap[c]:
                    return False
                else:
                    stack.pop()
            else:
                stack.append(c)
        return len(stack) == 0

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna