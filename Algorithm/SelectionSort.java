package Algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    private final ArrayList<Integer> dataList;

    private SelectionSort(){
        this.dataList = new ArrayList<>();
    }

    private void insertData(Integer data){
        this.dataList.add(data);
    }

    private void selectionSort(ArrayList<Integer> datalist){
        int lowest;

        for(int i=0; i<datalist.size() -1; i++){
            lowest = i;
            for(int j=i+1; j<datalist.size(); j++){
                if(datalist.get(j) < datalist.get(lowest)){
                    lowest = j;
                }
            }
            Collections.swap(datalist, i, lowest);
        }

    }

    public static void main(String[] args) {

        SelectionSort ss = new SelectionSort();

        for(int i=0; i<100; i++){
            ss.insertData((int)(Math.random() * 100) + 1);
        }

        System.out.println("----------------- 정렬 전 ");
        System.out.println(ss.dataList);

        System.out.println("----------------- 정렬 후");
        ss.selectionSort(ss.dataList);
        System.out.println(ss.dataList);

    }
}
