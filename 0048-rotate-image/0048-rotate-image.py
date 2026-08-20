class Solution:
    def rotate(self, mat: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        m=len(mat)
        n=len(mat[0])
        # l=[[0]*m for _ in range(n)]
        for i in range(n):
            for j in range (i,m):
                mat[i][j],mat[j][i]=mat[j][i],mat[i][j]
        for i in range(m):
            mat[i].reverse()

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna