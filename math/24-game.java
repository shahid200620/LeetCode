import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return solve(list);
    }

    private boolean solve(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < EPSILON;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                List<Double> nextRound = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) {
                        nextRound.add(list.get(k));
                    }
                }

                double a = list.get(i);
                double b = list.get(j);

                // Addition
                nextRound.add(a + b);
                if (solve(nextRound)) return true;
                nextRound.remove(nextRound.size() - 1);

                // Subtraction (a - b)
                nextRound.add(a - b);
                if (solve(nextRound)) return true;
                nextRound.remove(nextRound.size() - 1);

                // Subtraction (b - a)
                nextRound.add(b - a);
                if (solve(nextRound)) return true;
                nextRound.remove(nextRound.size() - 1);

                // Multiplication
                nextRound.add(a * b);
                if (solve(nextRound)) return true;
                nextRound.remove(nextRound.size() - 1);

                // Division (a / b)
                if (Math.abs(b) > EPSILON) {
                    nextRound.add(a / b);
                    if (solve(nextRound)) return true;
                    nextRound.remove(nextRound.size() - 1);
                }

                // Division (b / a)
                if (Math.abs(a) > EPSILON) {
                    nextRound.add(b / a);
                    if (solve(nextRound)) return true;
                    nextRound.remove(nextRound.size() - 1);
                }
            }
        }
        return false;
    }
}