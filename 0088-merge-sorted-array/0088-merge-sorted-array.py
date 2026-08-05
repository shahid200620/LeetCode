class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        # n1=[nums1[i] for i in range (m)]
        # # n2=[nums2[i] for i in range (n)]
        # n=n1+nums2
        # n.sort()
        # nums1=n
        j=0
        for i in range(m,len(nums1)):
            nums1[i]=nums2[j]
            j+=1
        nums1.sort()

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna