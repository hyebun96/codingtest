package Algorithm;

import java.util.ArrayList;

public class QuickSort {

    public ArrayList<Integer> sort (ArrayList<Integer> dataList){
        if(dataList.size() <= 1){
            return dataList;
        }
        int pivot = dataList.get(0);

        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        for(int i=1; i<dataList.size(); i++){
            if(dataList.get(i) < pivot){
                leftList.add(dataList.get(i));
            } else {
                rightList.add(dataList.get(i));
            }
        }

        ArrayList<Integer> mergedArr = new ArrayList<Integer>();
        mergedArr.addAll(this.sort(leftList));
        mergedArr.add(pivot);
        mergedArr.addAll(this.sort(rightList));

        return mergedArr;
    }

    public static void main(String[] args){
        QuickSort qs = new QuickSort();

        ArrayList datalist = new ArrayList();
        for(int i=0; i<10; i++){
            datalist.add((int)(Math.random() * 100));
        }

        System.out.println(qs.sort(datalist));
    }
}
