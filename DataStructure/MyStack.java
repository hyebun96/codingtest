package DataStructure;

import java.util.ArrayList;

public class MyStack<T> {   // 객체를 생성할 때, 원하는 변수를 받을 수 있도록 제너릭 처리
    private ArrayList<T> stack = new ArrayList<T>();

    private void push(T item){
        stack.add(item);
    }   // Stack 값을 넣을 경우, ArrayList에서 add

    private T pop(){            // Stack 값을 뺄 경우,
        if(stack.isEmpty()){    // ArrayList의 element가 존재하는지 검사
            return null;        // 1. 값이 없다면 null 반환
        }
        return stack.remove(stack.size()-1);    // 2. 값이 없다면, 맨 뒤 element 삭제(Stack FILO)
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
