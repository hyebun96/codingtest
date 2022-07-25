package CodingTest;

import java.lang.invoke.MutableCallSite;
import java.util.ArrayList;
import java.util.LinkedList;

public class MyQueue<T> {   // 객체를 생성할 때, 원하는 변수를 받을 수 있도록 제너릭 처리
    private ArrayList<T> queue = new ArrayList<T>();

    private void inQueue(T item){
        queue.add(item);
    }   // Queue 값을 넣을 경우, ArrayList에 add

    private T deQueue(){                    // Queue 값을 뺄 경우,
        if(queue.isEmpty()){                // ArrayList의 element 존재하는지 검사
            return null;                    // 1. 값이 없다면 null 반환
        }
        return queue.remove(0);     // 2. 값이 있다면, 맨 앞의 element 삭제(Queue는 FIFO)
    }

    public static void main(String[] args) {
        MyQueue<Integer> qu = new MyQueue<Integer>();
        qu.inQueue(1);
        qu.inQueue(2);
        qu.inQueue(3);
        System.out.println(qu.deQueue());
        System.out.println(qu.deQueue());
        System.out.println(qu.deQueue());
    }
}
