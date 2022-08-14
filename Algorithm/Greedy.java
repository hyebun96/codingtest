package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;

// 지불해야 하는 값이 4720원 일 때 1원 50원 100원, 500원 동전으로 동전의 수가 가장 적게 지불하시오.
public class Greedy {

    private void coinFunc(Integer price, ArrayList<Integer> coinList){
        Integer totalCoinCount = 0;
        ArrayList<Integer> coinCount = new ArrayList<>();

        for(int i=0; i<coinList.size(); i++){
            coinCount.add(price/coinList.get(i));
            System.out.println(coinList.get(i) + "원 : " + price / coinList.get(i));
            price = price % coinList.get(i);
            totalCoinCount += coinCount.get(i);
        }
        System.out.println("총 동전 갯수 : " + totalCoinCount);
    }

    public static void main(String[] args) {
        Greedy greedy = new Greedy();
        ArrayList<Integer> coinList = new ArrayList<>(Arrays.asList(500, 100, 50, 1));

        greedy.coinFunc(4720, coinList);

    }
}
