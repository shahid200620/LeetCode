import java.util.Arrays;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] nChars = String.valueOf(n).toCharArray();
        Arrays.sort(nChars);
        String sortedN = new String(nChars);
        
        for (int i = 0; i < 30; i++) {
            int powerOf2 = 1 << i;
            char[] p2Chars = String.valueOf(powerOf2).toCharArray();
            Arrays.sort(p2Chars);
            String sortedP2 = new String(p2Chars);
            
            if (sortedN.equals(sortedP2)) {
                return true;
            }
        }
        
        return false;
    }
}