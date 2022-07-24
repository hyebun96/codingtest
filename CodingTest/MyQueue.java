package CodingTest;

import java.lang.invoke.MutableCallSite;
import java.util.ArrayList;
import java.util.LinkedList;

public class MyQueue<T> {
    private ArrayList<T> queue = new ArrayList<T>();

    private void inQueue(T item){
        queue.add(item);
    }

    private T deQueue(){
        if(queue.isEmpty()){
            return null;
        }
        return queue.remove(0);
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
