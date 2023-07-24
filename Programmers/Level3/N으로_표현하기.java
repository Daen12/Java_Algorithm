import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class N으로_표현하기 {
    public static void main(String[] args) {
        // N과 괄호, 사칙연산만 사용해서 표현 할 수 있는 방법 중 N의 사용횟수의 최솟값.
        int N = 5;
        int number = 12;
        System.out.println(solution(N, number));
    }

    public static int solution(int N, int number) {
        List<Set<Integer>> setList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            setList.add(new HashSet<>());
        }
        setList.get(1).add(N);
        // N으로 N만들기 = 한개필요
        if (number == N)
            return 1;

        for (int i = 2; i < 9; i++) { // 234..8
            for (int j = 1; j <= i / 2; j++) { // 1,1,12,12,123,123,
                unionSet(setList.get(i), setList.get(i - j), setList.get(j));
                unionSet(setList.get(i), setList.get(j), setList.get(i - j));
            }
            String n = Integer.toString(N);// "5"
            setList.get(i).add(Integer.parseInt(n.repeat(i)));// i번 연속된 숫자
            // validation (number와 일치하는 수 있는지 확인하기)
            for (int num : setList.get(i)) {
                if (num == number) {
                    // i가 오름차순으로 반복문을 도니까 처음 만나는 i가 최솟값!
                    return i;
                }
            }
        }
        // 위에서 리턴 못하면 -1 리턴
        return -1;
    }

    public static void unionSet(Set<Integer> union, Set<Integer> A, Set<Integer> B) {
        for (int a : A) {
            for (int b : B) {
                union.add(a + b);
                union.add(a - b);
                union.add(a * b);
                if (b != 0) {
                    union.add(a / b);
                }
            }
        }
    }
}
