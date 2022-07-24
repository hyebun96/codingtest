package CodingTest;

import java.util.ArrayList;
import java.util.Stack;

public class MyStack<T> {
    private ArrayList<T> stack = new ArrayList<T>();

    private void push(T item){
        stack.add(item);
    }

    private T pop(){
        if(stack.isEmpty()){
            return null;
        }
        return stack.remove(stack.size()-1);
    }

    public static void main(String[] args) {
        MyStack<Integer> st = new MyStack<Integer>();
        st.push(1);
        st.push(2);
        System.out.println(st.pop());
        st.push(3);
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}
