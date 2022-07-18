package coplit.stack_and_queue;

import java.util.ArrayList;
import java.util.Stack;

public class BrowserStack {
    public static void main(String[] args) {
        String[] actions = new String[]{"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"};
        String start = "A";
        //System.out.println(browserStack(actions, start).toString());
/*
        for(int i=0; i<actions.length; i++){
            if(actions[i].equals("-1")){
                System.out.println(actions[i]);
            }
        }*/

        Stack<String> current = new Stack<>();
        current.push("1");
        current.push("2");
        System.out.println(current.pop());



    }
    static ArrayList<Stack> browserStack(String[] actions, String start){
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();

        //start가 대문자가 아닌 경우
        //대문자: 65~90

        /*
        if(start.charAt(0)<=65 && start.charAt(0)>=90) {
            return null;
        }
*/
        current.push(start);

        for (int i=0; i<actions.length; i++) {

            if(actions[i].charAt(0)>=65 && actions[i].charAt(0)<=90){
                if(!current.isEmpty()){
                    prevStack.push(current.peek());
                    current.clear();
                    nextStack.clear();
                    current.push(actions[i]);
                }
            }

            else if (actions[i].equals("-1")) {
                if (prevStack.empty()) continue;
                nextStack.push(current.pop());
                current.push(prevStack.pop());

            } else if (actions[i].equals("1")) {
                if (nextStack.empty()) continue;
                prevStack.push(current.pop());
                current.push(nextStack.pop());
            }
        }


        result.add(prevStack);
        result.add(current);
        result.add(nextStack);
        return result;
    }
}