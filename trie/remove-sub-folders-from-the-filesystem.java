import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        if (folder.length == 0) {
            return result;
        }

        result.add(folder[0]);

        for (int i = 1; i < folder.length; i++) {
            String currentFolder = folder[i];
            String lastAddedFolder = result.get(result.size() - 1);

            if (!currentFolder.startsWith(lastAddedFolder + "/")) {
                result.add(currentFolder);
            }
        }

        return result;
    }
}