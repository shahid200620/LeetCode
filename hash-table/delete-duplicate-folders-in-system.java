import java.util.*;

class Solution {
    class TrieNode {
        Map<String, TrieNode> children;
        String name;
        boolean toDelete;

        public TrieNode(String name) {
            this.name = name;
            this.children = new HashMap<>();
            this.toDelete = false;
        }
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode("");

        for (List<String> path : paths) {
            TrieNode current = root;
            for (String folder : path) {
                current.children.putIfAbsent(folder, new TrieNode(folder));
                current = current.children.get(folder);
            }
        }

        Map<String, List<TrieNode>> signatures = new HashMap<>();
        postOrderDFS(root, signatures);

        for (List<TrieNode> nodes : signatures.values()) {
            if (nodes.size() > 1) {
                for (TrieNode node : nodes) {
                    node.toDelete = true;
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        preOrderDFS(root, new ArrayList<>(), result);

        return result;
    }

    private String postOrderDFS(TrieNode node, Map<String, List<TrieNode>> signatures) {
        if (node.children.isEmpty()) {
            return "(";
        }

        StringBuilder sb = new StringBuilder("(");
        List<String> sortedChildNames = new ArrayList<>(node.children.keySet());
        Collections.sort(sortedChildNames);

        for (String childName : sortedChildNames) {
            TrieNode child = node.children.get(childName);
            sb.append(childName).append(postOrderDFS(child, signatures));
        }
        sb.append(")");

        String signature = sb.toString();
        if (!signature.equals("()")) { // Don't consider empty folders for duplication
            signatures.computeIfAbsent(signature, k -> new ArrayList<>()).add(node);
        }
        return signature;
    }

    private void preOrderDFS(TrieNode node, List<String> currentPath, List<List<String>> result) {
        if (node.toDelete) {
            return;
        }

        if (!currentPath.isEmpty()) {
            result.add(new ArrayList<>(currentPath));
        }

        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            TrieNode child = entry.getValue();
            currentPath.add(child.name);
            preOrderDFS(child, currentPath, result);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}