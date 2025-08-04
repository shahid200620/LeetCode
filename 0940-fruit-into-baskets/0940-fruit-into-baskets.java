class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int maxFruits = 0;
        int i = 0;
        int j = 0;
        int firstFruit = -1;
        int secondFruit = -1;
        int lastIndexFirst = -1;
        int lastIndexSecond = -1;

        while (j < n) {
            int currentFruit = fruits[j];
            if (firstFruit == -1) {
                firstFruit = currentFruit;
                lastIndexFirst = j;
            } else if (currentFruit == firstFruit) {
                lastIndexFirst = j;
            } else if (secondFruit == -1) {
                secondFruit = currentFruit;
                lastIndexSecond = j;
            } else if (currentFruit == secondFruit) {
                lastIndexSecond = j;
            } else {
                maxFruits = Math.max(maxFruits, j - i);
                if (lastIndexFirst > lastIndexSecond) {
                    i = lastIndexSecond + 1;
                    secondFruit = currentFruit;
                    lastIndexSecond = j;
                } else {
                    i = lastIndexFirst + 1;
                    firstFruit = currentFruit;
                    lastIndexFirst = j;
                }
            }
            j++;
        }
        maxFruits = Math.max(maxFruits, j - i);
        return maxFruits;
    }
}