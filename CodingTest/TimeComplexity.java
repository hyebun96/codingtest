package CodingTest;

public class TimeComplexity {
    // 시간 복잡도의 이해를 위해 간단한 Test 코드 작성해보기

    public int sum1(int n){     // 시간복잡도 O(n)
        int total = 0;
        for(int i=1; i<=n; i++){
            total += i;
        }
        return total;
    }

    public int sum2(int n){     // 시간복잡도 O(1)
        return n*(n +1)/2;
    }

    public static void main(String[] args) {
        TimeComplexity timeComplexity = new TimeComplexity();
        System.out.println(timeComplexity.sum1(10));
        System.out.println(timeComplexity.sum2(10));
    }
}
