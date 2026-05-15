class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        c=0
        for i in jewels:
            for j in stones:
                if i == j:
                    c+=1
        return c