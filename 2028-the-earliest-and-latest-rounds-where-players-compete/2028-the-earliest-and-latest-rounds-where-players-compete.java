import java.util.*;

class Solution {
    private Map<List<Integer>, int[]> memo = new HashMap<>();
    private int firstPlayer;
    private int secondPlayer;

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        
        List<Integer> initialPlayers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            initialPlayers.add(i);
        }
        
        return solve(initialPlayers);
    }
    
    private int[] solve(List<Integer> currentPlayers) {
        if (memo.containsKey(currentPlayers)) {
            return memo.get(currentPlayers);
        }
        
        int n = currentPlayers.size();
        int fpIdx = -1;
        int spIdx = -1;
        
        for (int i = 0; i < n; i++) {
            if (currentPlayers.get(i) == firstPlayer) {
                fpIdx = i;
            }
            if (currentPlayers.get(i) == secondPlayer) {
                spIdx = i;
            }
        }
        
        if (fpIdx + spIdx == n - 1) {
            return new int[]{1, 1};
        }
        
        int minRounds = Integer.MAX_VALUE;
        int maxRounds = Integer.MIN_VALUE;

        List<int[]> otherMatches = new ArrayList<>();
        for (int i = 0; i < n / 2; i++) {
            int playerA = currentPlayers.get(i);
            int playerB = currentPlayers.get(n - 1 - i);
            if ((playerA != firstPlayer && playerA != secondPlayer) && (playerB != firstPlayer && playerB != secondPlayer)) {
                otherMatches.add(new int[]{playerA, playerB});
            }
        }
        
        int numCombinations = 1 << otherMatches.size();
        for (int i = 0; i < numCombinations; i++) {
            List<Integer> nextRoundPlayers = new ArrayList<>();
            
            int comboIndex = 0;
            for (int j = 0; j < n / 2; j++) {
                int playerA = currentPlayers.get(j);
                int playerB = currentPlayers.get(n - 1 - j);
                
                int winner;
                if (playerA == firstPlayer || playerB == firstPlayer) {
                    winner = firstPlayer;
                } else if (playerA == secondPlayer || playerB == secondPlayer) {
                    winner = secondPlayer;
                } else {
                    if (((i >> comboIndex) & 1) == 1) {
                        winner = playerB;
                    } else {
                        winner = playerA;
                    }
                    comboIndex++;
                }
                nextRoundPlayers.add(winner);
            }
            
            if (n % 2 == 1) {
                nextRoundPlayers.add(currentPlayers.get(n / 2));
            }
            
            Collections.sort(nextRoundPlayers);
            
            int[] res = solve(nextRoundPlayers);
            minRounds = Math.min(minRounds, 1 + res[0]);
            maxRounds = Math.max(maxRounds, 1 + res[1]);
        }
        
        int[] result = new int[]{minRounds, maxRounds};
        memo.put(currentPlayers, result);
        return result;
    }
}