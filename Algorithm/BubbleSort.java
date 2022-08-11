package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSort {
    private ArrayList<Integer> dataList;

    private BubbleSort() {
        this.dataList = new ArrayList<>();
    }

    private void insert(Integer data){
        if (this.dataList == null) {
            this.dataList = new ArrayList<>();
            this.dataList.add(data);
        } else {
            this.dataList.add(data);
        }
    }


    private void bubbleSort(List<Integer> dataList) {

        for(int i = dataList.size() - 1; i > 0; i--){
            boolean swap = false;
            for (int j = 0; j < i; j++) {
                if (dataList.get(j) > dataList.get(j + 1)) {
                    Collections.swap(dataList, j, j + 1);
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }
    }


    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();

        for (int i = 0; i < 100; i++) {
            bs.insert((int)(Math.random() * 100));
        }


        System.out.println("----------------- 정렬 전 ");
        System.out.println(bs.dataList);

        System.out.println("----------------- 정렬 후");
        bs.bubbleSort(bs.dataList);
        System.out.println(bs.dataList);

    }
}
