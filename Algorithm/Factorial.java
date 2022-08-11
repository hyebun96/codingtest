package Algorithm;

import java.util.ArrayList;

public class Factorial {
    private int factorialFunc(int data){
        if(data > 1){
           return data * this.factorialFunc(data-1);
        } else {
            return 1;
        }
    }

    private int factorialSum(ArrayList<Integer> dataList, int size){
        if(size ==0 ){
            return 0;
        } else {
            int data = dataList.get(size);
            dataList.remove(size);
           return data + this.factorialSum(dataList, size-1);
        }
    }

    private  int factorial123(int data){
        if(data == 1){
            return 1;
        } else if(data == 2){
            return 2;
        } else if(data == 3){
            return 4;
        }
        return this.factorial123(data - 1) + this.factorial123(data - 2) + this.factorial123(data - 3);
    }

    public static void main(String[] args) {

        Factorial factorial = new Factorial();

        System.out.println("------------------------ 팩토리얼 곱");
        System.out.println(factorial.factorialFunc(5));

        System.out.println("------------------------ 팩토리얼 합");
        ArrayList<Integer> dataList = new ArrayList<>();
        for(int i=0; i<10; i++){
            dataList.add(i);
        }
        System.out.println(factorial.factorialSum(dataList, dataList.size()-1));


        System.out.println("------------------------ 1,2,3 조합으로 임의의 정수를 나타낼 수 있는 방법의 갯수");
        System.out.println(factorial.factorial123(5));
        System.out.println(factorial.factorial123(4));

    }
}
