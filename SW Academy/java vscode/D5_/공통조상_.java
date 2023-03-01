import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 공통조상_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int node = sc.nextInt();
            int line = sc.nextInt();
            cnt = 0;

            // x, y의 공통조상을 찾는 문제
            int x = sc.nextInt();
            int y = sc.nextInt();
            List<Integer> arrx = new ArrayList<>();
            List<Integer> arry = new ArrayList<>();

            int[][] arr = new int[node + 1][2];

            for (int i = 1; i <= line; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                if (arr[a][0] == 0) {
                    arr[a][0] = b;
                } else {
                    arr[a][1] = b;
                }

            }

            // 공통조상 찾기
            while (x != 1) {
                for (int i = 1; i <= node; i++) {
                    for (int j = 0; j <= 1; j++) {
                        if (arr[i][j] == x) {
                            arrx.add(i);
                            x = i;
                        }
                    }
                }
            }

            while (y != 1) {
                for (int i = 1; i <= node; i++) {
                    for (int j = 0; j <= 1; j++) {
                        if (arr[i][j] == y) {
                            arry.add(i);
                            y = i;
                        }
                    }
                }
            }

            // System.out.println(Arrays.toString(arrx.toArray()));
            // System.out.println(Arrays.toString(arry.toArray()));

            int result = 1;
            outer: for (int i = 0; i < arrx.size(); i++) {
                for (int j = 0; j < arry.size(); j++) {
                    if (arrx.get(i).equals(arry.get(j))) {
                        result = arrx.get(i);
                        break outer;
                    }
                }
            }

            // 자식 놈들 개수 찾기
            traverse(result, arr);
            System.out.println("#" + tc + " " + result + " " + cnt);
        }

    }

    static int cnt = 0;

    private static void traverse(int num, int[][] arr) {
        cnt++;
        if (arr[num][0] != 0) {
            traverse(arr[num][0], arr);
        }

        if (arr[num][1] != 0) {
            traverse(arr[num][1], arr);
        }
    }
}
