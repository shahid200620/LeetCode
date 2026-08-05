class Solution:
    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        m=lem(mat)
        n=len(mat[0])
        if r*c != m*n:
            return mat
        r=[[0]*c for i in range (r)]
        cou=0
        for i in range (m):
            for j in range(n):
                r[cou//c][cou%c]=mat[i][j]
                cou+=1
        return r


# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna