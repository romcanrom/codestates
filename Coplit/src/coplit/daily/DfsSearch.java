package coplit.daily;

import java.util.ArrayList;
import java.util.Stack;

public class DfsSearch {
    public static void main(String[] args) {
        Tree root = new Tree("1");
        Tree rootChild1 = root.addChildNode(new Tree("2"));
        Tree rootChild2 = root.addChildNode(new Tree("3"));
        Tree leaf1 = rootChild1.addChildNode(new Tree("4"));
        Tree leaf2 = rootChild1.addChildNode(new Tree("5"));
        ArrayList<String> output = dfs(root);
        System.out.println(output); // 1, 2, 4, 5, 3

        leaf1.addChildNode(new Tree("6"));
        rootChild2.addChildNode(new Tree("7"));
        output = dfs(root);
        System.out.println(output); // 1, 2, 4, 6, 5, 3, 7
    }
    public static class Tree {
        private String value;
        private ArrayList<Tree> children;

        public Tree(String data) {
            this.value = data;
            this.children = null;
        }

        public Tree addChildNode(Tree node) {
            if(children == null) children = new ArrayList<>();
            children.add(node);
            return children.get(children.size() - 1);
        }

        public String getValue() {
            return value;
        }

        public ArrayList<Tree> getChildrenNode() {
            return children;
        }
    }


    //stack 사용
    public static ArrayList<String> dfs(Tree node) {
        ArrayList<String> result = new ArrayList<>();

        Stack<Tree> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()) {
            Tree now = stack.pop();
            result.add(now.getValue());

            if(now.getChildrenNode() != null) {
                for(int i=now.getChildrenNode().size()-1; i>=0; i--) {
                    if(!result.contains(now.getChildrenNode().get(i).getValue())) {
                        stack.push(now.getChildrenNode().get(i));
                    }
                }
            }
        }

        return result;
    }

    //재귀 사용
    public static ArrayList<String> dfs2(Tree node) {
        ArrayList<String> result = new ArrayList<>();
        result.add(node.getValue());

        if(node.getChildrenNode() != null) {
            for(int i=0; i<node.getChildrenNode().size(); i++) {
                ArrayList<String> list = dfs2(node.getChildrenNode().get(i));
                result.addAll(list);
            }
        }
        return result;
    }
}
