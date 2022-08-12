package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {

    private boolean searchFunc(ArrayList<Integer> dataList, Integer data){

        if(dataList.size() == 1 && dataList.get(0) == data){
            return true;
        }
        if(dataList.size() == 1 && dataList.get(0) != data){
            return false;
        }
        if(dataList.size() == 0){
            return false;
        }

        int half = dataList.size() / 2;
        if(dataList.get(half) > data){
            return searchFunc(new ArrayList<>(dataList.subList(0, half)), data);
        } else{
            return searchFunc(new ArrayList<>(dataList.subList(half, dataList.size())), data);
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> testData = new ArrayList<>();

        for(int i=0; i<30; i++){
            testData.add((int)(Math.random() * 100 + 1));
        }

        Collections.sort(testData);

        BinarySearch bs = new BinarySearch();

        System.out.println(testData);
        System.out.println("99 숫자 찾기 => " + bs.searchFunc(testData, 99));
    }
}
