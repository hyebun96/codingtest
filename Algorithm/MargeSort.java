package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class MargeSort {

    private ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList){

        if(dataList.size() <= 1){
            return dataList;
        }

        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr = mergeSplitFunc(new ArrayList<>(dataList.subList(0, medium)));
        ArrayList<Integer> rightArr = mergeSplitFunc(new ArrayList<>(dataList.subList(medium, dataList.size())));

        return mergeFunc(leftArr, rightArr);
    }

    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr){
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        // Case1 : left/right 둘 다 있을 때
        while(leftArr.size() > leftPoint && rightArr.size() > rightPoint){
            if(leftArr.get(leftPoint) < rightArr.get(rightPoint)){
                mergedList.add(leftArr.get(leftPoint));
                leftPoint++;
            } else {
                mergedList.add(rightArr.get(rightPoint));
                rightPoint++;
            }
        }

        // Case2 : right 데이터가 없을 때
        while(leftArr.size() > leftPoint){
            mergedList.add(leftArr.get(leftPoint));
            leftPoint++;
        }

        // Case3 : left 데이터가 없을 때
        while(rightArr.size() > rightPoint){
            mergedList.add(rightArr.get(rightPoint));
            rightPoint++;
        }

        return mergedList;
    }


    public static void main(String[] args) {

        MargeSort ms = new MargeSort();
        ArrayList<Integer> dataList = new ArrayList<>();

        for(int i=0; i<100; i++){
            dataList.add ((int)(Math.random() * 100) + 1);
        }

        System.out.println(dataList);

        System.out.println("---------------");
        System.out.println(ms.mergeSplitFunc(dataList));
    }
}
