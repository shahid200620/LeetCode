class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st = []

        for c in tokens:
            if c == "+":
                st.append(st.pop() + st.pop())
            elif c == "-":
                second, first = st.pop(), st.pop()
                st.append(first - second)
            elif c == "*":
                st.append(st.pop() * st.pop())
            elif c == "/":
                second, first = st.pop(), st.pop()
                st.append(int(first / second))                
            else:
                st.append(int(c))
        
        return st[0]

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna