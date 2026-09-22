class Solution:
    def commonChars(self, words: list[str]) -> list[str]:
        l=[]
        for i in words[0]:
            p=0
            for j in range(1,len(words)):
                if i in words[j]:
                    words[j]=words[j].replace(i,"",1)
                    print()
                else :
                    p=1
                    break
            if p==0:
               l.append(i)
        return l 

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna