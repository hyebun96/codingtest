package Algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {
    private final ArrayList<Integer> dataList;

    private InsertionSort(){
        this.dataList = new ArrayList<>();
    }

    private void insertData(Integer data){
        this.dataList.add(data);
    }

    private void selectionSort(ArrayList<Integer> datalist){

        for(int i=1; i<datalist.size(); i++){
            for(int j=i-1; 0<=j; j--){
                if(datalist.get(j) > datalist.get(j+1)){
                    Collections.swap(datalist, j, j+1);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        InsertionSort is = new InsertionSort();

        for(int i=0; i<100; i++){
            is.insertData((int)(Math.random() * 100));
        }

        System.out.println("----------------- 정렬 전 ");
        System.out.println(is.dataList);

        System.out.println("----------------- 정렬 후");
        is.selectionSort(is.dataList);
        System.out.println(is.dataList);

    }
}
