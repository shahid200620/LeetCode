import java.util.Arrays;
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int playerIdx = 0;
        int trainerIdx = 0;
        int matches = 0;

        while (playerIdx < players.length && trainerIdx < trainers.length) {
            if (players[playerIdx] <= trainers[trainerIdx]) {
                matches++;
                playerIdx++;
                trainerIdx++;
            } else {
                trainerIdx++;
            }
        }

        return matches;
    }
}