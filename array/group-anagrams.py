class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        s=defaultdict(list)
        for i in strs:
            a=""+=(sorted(i))
            s[a].append(i)
        return list(s.values())

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna