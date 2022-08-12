package Algorithm;

import java.util.ArrayList;

public class SequentialSearch {

    private int searchFunc(ArrayList<Integer> dataList, Integer searchData){
        for(int i=0; i<dataList.size()-1; i++){
            if(dataList.get(i) == searchData){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for(int i=0; i<10; i++){
            testData.add((int)(Math.random() * 100));
        }

        SequentialSearch sequentialSearch = new SequentialSearch();

        System.out.println(testData);
        System.out.println("99 숫자 찾기 => " + sequentialSearch.searchFunc(testData, 99));
    }
}
