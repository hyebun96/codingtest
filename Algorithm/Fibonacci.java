package Algorithm;

public class Fibonacci {

    // recursive call이용한 피보나치
    private int fibonacci(int data){
        if(data <= 1){
            return data;
        } else {
            return fibonacci(data-1) + fibonacci(data-2);
        }
    }

    // 동적 계획법을 이용한 피보나치
    private int dynamicFunc(int data){
        Integer[] chche = new Integer[data+1];
        chche[0] = 0;
        chche[1] = 1;
        for(int i=2; i<data + 1; i++){
            chche[i] = chche[i-1] + chche[i-2];
        }
        return chche[data];
    }


    public static void main(String[] args) {
        Fibonacci fb = new Fibonacci();

        System.out.println(fb.fibonacci(5));
        System.out.println(fb.dynamicFunc(5));


    }
}
