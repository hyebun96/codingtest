package CodingTest;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collections;

public class MyHeap {
    private ArrayList<Integer> heapArray;

    private MyHeap(Integer data) {
        this.heapArray = new ArrayList<>();

        this.heapArray.add(null);
        this.heapArray.add(data);
    }

    private boolean move_up(Integer inserted_idx){
        if(inserted_idx <= 1){
            return false;
        } else {
            // inserted_idx / 2  : parent_idx
            return this.heapArray.get(inserted_idx / 2) < this.heapArray.get(inserted_idx);
        }
    }

    private boolean insert(Integer data){
        Integer inserted_idx, parent_idx;

        if(this.heapArray == null){
            this.heapArray = new ArrayList<Integer>();

            this.heapArray.add(null);
            this.heapArray.add(data);
        } else {
            this.heapArray.add(data);
            inserted_idx = this.heapArray.size() - 1;

            while(move_up(inserted_idx)){
                parent_idx = inserted_idx / 2;
                Collections.swap(this.heapArray, inserted_idx, parent_idx);
                inserted_idx = parent_idx;
            }
        }
        return true;
    }

    private boolean move_down(Integer popped_idx){
        Integer left_child_popped_idx = popped_idx * 2;
        Integer right_child_popped_idx = popped_idx * 2 + 1;

        // Case1 : 자식 Node 가 하나도 없을 때
        if(left_child_popped_idx >= this.heapArray.size()) {
            return false;
        } else if(right_child_popped_idx >= this.heapArray.size()){
            // Case2 : 오른 쪽 자식만 없을 때
            return  this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx);
        } else {
            // Case 3 : 왼쪽/ 오른쪽 자식 노드가 모두 있을 떄
            if(this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)){
                return this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx);
            } else {
                return this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx);
            }
        }
    }

    private Integer pop(){
        Integer returned_data, popped_idx, left_child_popped_idx, right_child_popped_idx;

        if(this.heapArray == null){
            return null;
        } else {
            returned_data = this.heapArray.get(1);
            this.heapArray.set(1, this.heapArray.get(this.heapArray.size()-1));
            this.heapArray.remove(this.heapArray.size()-1);
            popped_idx = 1;

            while(this.move_down(popped_idx)){
                left_child_popped_idx = popped_idx * 2;
                right_child_popped_idx = popped_idx * 2 + 1;

                // Case2 : 오른쪽 자식 노드만 없을 떄
                if(right_child_popped_idx >= this.heapArray.size()){
                    if(this.heapArray.get(left_child_popped_idx) >= this.heapArray.get(popped_idx)){
                        Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                        popped_idx = left_child_popped_idx;
                    }
                } else {
                    // Case3 : 왼쪽/오른쪽 자식 노드가 모두 있을 떄
                    if(this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)){
                        if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)){
                            Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                            popped_idx = left_child_popped_idx;
                        }
                    } else {
                        if(this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)){
                            Collections.swap(this.heapArray, popped_idx, right_child_popped_idx);
                            popped_idx = right_child_popped_idx;
                        }
                    }
                }
            }
            return returned_data;
        }
    }

    public static void main(String[] args) {
        MyHeap heapTest = new MyHeap(15);

        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);

        System.out.println(heapTest.heapArray);
        System.out.println("-------------------------");

        heapTest.pop();
        System.out.println(heapTest.heapArray);


    }



}