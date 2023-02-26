import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Q7087_문제제목붙이기_D3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt(); // 몇줄? 5
            Set<Integer> titles = new HashSet<>();
            for (int n = 0; n < N; n++) { // 각 단어마다
                char[] chararr = in.next().toCharArray();
                int first = chararr[0]; // 첫번째 캐릭터의 숫자를 저장!
                titles.add(first);
            }
            Object[] titleArr = titles.toArray();
            // System.out.println(Arrays.toString(titleArr));
            int start = (int) titleArr[0]; // 첫 원소 65

            // System.out.println(start);
            int end = 0;
            boolean isA = true;
            boolean isOne = false;
            if (start != 65) { // A가 없으면 그냥 0리턴!
                isA = false;
            } else if (titleArr.length == 1) { // 길이가 1이면 1 리턴
                isOne = true;
            } else {
                for (int i = 0; i < titleArr.length; i++) {
                    int compare = start + i; // 65 66 67
                    if ((int) titleArr[i] != compare) { // 정렬된 순서대로 올라가야 하는데 (compare) 아닌경우
                        end = compare; // 67 전까지 쓸 수 있음!
                        break;
                    }
                    if (i == titleArr.length - 1) {
                        end = compare + 1;
                    }
                }
            }
            if (!isA) {
                System.out.println("#" + t + " " + 0);
            } else {
                if (isOne) {
                    System.out.println("#" + t + " " + 1);
                } else {
                    System.out.println("#" + t + " " + (end - start));

                }
            }
        }
    }
}