import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows <= 0) {
            return result;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> previousRow = result.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();

            currentRow.add(1);

            for (int j = 1; j < previousRow.size(); j++) {
                int sum = previousRow.get(j - 1) + previousRow.get(j);
                currentRow.add(sum);
            }

            currentRow.add(1);

            result.add(currentRow);
        }

        return result;
    }
}