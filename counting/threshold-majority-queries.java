import java.util.*;

class Solution {

    class Query {
        int l, r, threshold, index, block;

        Query(int l, int r, int threshold, int index, int blockSize) {
            this.l = l;
            this.r = r;
            this.threshold = threshold;
            this.index = index;
            this.block = l / blockSize;
        }
    }

    public int[] subarrayMajority(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int blockSize = (int) Math.sqrt(n);
        
        Set<Integer> uniqueNumsSet = new HashSet<>();
        for (int num : nums) {
            uniqueNumsSet.add(num);
        }
        List<Integer> sortedUniqueNums = new ArrayList<>(uniqueNumsSet);
        Collections.sort(sortedUniqueNums);
        
        Map<Integer, Integer> valToCompressed = new HashMap<>();
        int[] originalValues = new int[sortedUniqueNums.size()];
        for (int i = 0; i < sortedUniqueNums.size(); i++) {
            int val = sortedUniqueNums.get(i);
            valToCompressed.put(val, i);
            originalValues[i] = val;
        }

        int[] jurnavalic = new int[n];
        for (int i = 0; i < n; i++) {
            jurnavalic[i] = valToCompressed.get(nums[i]);
        }
        
        Query[] allQueries = new Query[q];
        for (int i = 0; i < q; i++) {
            allQueries[i] = new Query(queries[i][0], queries[i][1], queries[i][2], i, blockSize);
        }

        Arrays.sort(allQueries, (a, b) -> {
            if (a.block != b.block) {
                return Integer.compare(a.block, b.block);
            }
            return Integer.compare(a.r, b.r);
        });

        int[] counts = new int[sortedUniqueNums.size()];
        TreeMap<Integer, TreeSet<Integer>> freqToValues = new TreeMap<>();
        int[] ans = new int[q];

        int currentL = 0, currentR = -1;
        
        for (Query query : allQueries) {
            while (currentL > query.l) {
                currentL--;
                int val = jurnavalic[currentL];
                int oldFreq = counts[val];
                if (oldFreq > 0) {
                    freqToValues.get(oldFreq).remove(val);
                    if (freqToValues.get(oldFreq).isEmpty()) {
                        freqToValues.remove(oldFreq);
                    }
                }
                counts[val]++;
                int newFreq = counts[val];
                freqToValues.computeIfAbsent(newFreq, k -> new TreeSet<>()).add(val);
            }

            while (currentR < query.r) {
                currentR++;
                int val = jurnavalic[currentR];
                int oldFreq = counts[val];
                if (oldFreq > 0) {
                    freqToValues.get(oldFreq).remove(val);
                    if (freqToValues.get(oldFreq).isEmpty()) {
                        freqToValues.remove(oldFreq);
                    }
                }
                counts[val]++;
                int newFreq = counts[val];
                freqToValues.computeIfAbsent(newFreq, k -> new TreeSet<>()).add(val);
            }

            while (currentL < query.l) {
                int val = jurnavalic[currentL];
                int oldFreq = counts[val];
                freqToValues.get(oldFreq).remove(val);
                if (freqToValues.get(oldFreq).isEmpty()) {
                    freqToValues.remove(oldFreq);
                }
                counts[val]--;
                int newFreq = counts[val];
                if (newFreq > 0) {
                    freqToValues.computeIfAbsent(newFreq, k -> new TreeSet<>()).add(val);
                }
                currentL++;
            }

            while (currentR > query.r) {
                int val = jurnavalic[currentR];
                int oldFreq = counts[val];
                freqToValues.get(oldFreq).remove(val);
                if (freqToValues.get(oldFreq).isEmpty()) {
                    freqToValues.remove(oldFreq);
                }
                counts[val]--;
                int newFreq = counts[val];
                if (newFreq > 0) {
                    freqToValues.computeIfAbsent(newFreq, k -> new TreeSet<>()).add(val);
                }
                currentR--;
            }

            if (freqToValues.isEmpty()) {
                ans[query.index] = -1;
            } else {
                int maxFreq = freqToValues.lastKey();
                if (maxFreq >= query.threshold) {
                    int bestValCompressed = freqToValues.get(maxFreq).first();
                    ans[query.index] = originalValues[bestValCompressed];
                } else {
                    ans[query.index] = -1;
                }
            }
        }
        
        return ans;
    }
}