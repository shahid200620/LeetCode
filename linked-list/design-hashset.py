class MyHashSet:

    def __init__(self):
        self.mp=defaultdict(int)
        

    def add(self, key: int) -> None:
        self.mp[key]=True
        

    def remove(self, key: int) -> None:
        self.mp[key]=False

    def contains(self, key: int) -> bool:
        return self.mp[key]
        

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna