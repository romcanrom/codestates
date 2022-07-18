package coplit.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsSearch {
    public static void main(String[] args) {
        tree root = new tree("1");
        tree rootChild1 = root.addChildNode(new tree("2"));
        tree rootChild2 = root.addChildNode(new tree("3"));
        tree leaf1 = rootChild1.addChildNode(new tree("4"));
        tree leaf2 = rootChild1.addChildNode(new tree("5"));
        System.out.println(bfs(root)); // --> ["1", "2", "3", "4", "5"]

        leaf1.addChildNode(new tree("6"));
        rootChild2.addChildNode(new tree("7"));
        System.out.println(bfs(root)); // --> ["1", "2", "3", "4", "5", "7", "6"]

    }

    //아래 클래스의 내용은 수정하지 말아야 합니다.
    public static class tree {
        private String value;
        private ArrayList<tree> children;

        public tree(String data) {
            this.value = data;
            this.children = null;
        }

        public tree addChildNode(tree node) {
            if (children == null) children = new ArrayList<>();
            children.add(node);
            return children.get(children.size() - 1);
        }

        public String getValue() {
            return value;
        }

        public ArrayList<tree> getChildrenNode() {
            return children;
        }
    }

    public static ArrayList<String> bfs(tree node) {
        ArrayList<String> result = new ArrayList<>();
        Queue<tree> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {

            tree now = queue.poll();
            result.add(now.getValue());

            if (now.getChildrenNode() == null) continue;

            now.getChildrenNode().stream()
                    .filter(child -> !result.contains(child.getValue()))
                    .filter(child -> !queue.contains(child))
                    .forEach(queue::add);
        }

        return result;
    }

}
