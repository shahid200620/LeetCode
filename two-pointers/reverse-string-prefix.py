class Solution:
    def reversePrefix(self, s: str, k: int) -> str:
        a=[]
        for i in range(k):
            a.append(s[i])
        a.reverse()
        for i in range(k,len(s)):
            a.append(s[i])
        s=''
        b=s.join(a)
        return b