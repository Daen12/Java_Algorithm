import java.util.Arrays;
import java.util.Scanner;

public class Q4047_영준이의카드카운팅_D3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) { // 각 케이스마다
            int S = 13, D = 13, H = 13, C = 13;
            char[] arr = in.next().toCharArray();
            boolean[] Sb = new boolean[13];
            boolean[] Db = new boolean[13];
            boolean[] Hb = new boolean[13];
            boolean[] Cb = new boolean[13]; // 0-12 인덱스
            boolean flag = true;
            System.out.println(Arrays.toString(arr));
            // 문자만 보고 해당 카운트에서 빼기
            // 이미 겹치는 숫자가 있다면 에러 반환
            // 앞에서부터 세개씩 자르기
            outer: for (int i = 0; i < arr.length; i += 3) {// 0 3 6
                int num = 0; // 13
                char card = ' ';
                for (int j = i; j < i + 3; j++) { // i=0이면 0,1,2
                    if (j == i) {// 세개 중 첫번째 인덱스이면
                        card = arr[j];
                    } else if (j == i + 1) { // 두번째 숫자 = 십읮라ㅣ
                        num += (arr[j] - '0') * 10;
                    } else {
                        num += (arr[j] - '0');
                    }
                }
                switch (card) {
                    case 'S': {
                        if (!Sb[num - 1]) { // 해당 불리언배열이 false이면
                            S--;
                            Sb[num - 1] = true;
                        } else { // 이미 값이 있으면
                            flag = false; // 바깥 플래그를 false로 바꾸어줌 = ERROR!
                            break outer; // 다른 카드 볼 필요 없음!
                        }
                    }
                        break;
                    case 'D': {
                        if (!Db[num - 1]) { // 해당 불리언배열이 false이면
                            D--;
                            Db[num - 1] = true;
                        } else {
                            flag = false;
                            break outer;
                        }
                    }
                        break;
                    case 'H': {
                        if (!Hb[num - 1]) { // 해당 불리언배열이 false이면
                            H--;
                            Hb[num - 1] = true;
                        } else {
                            flag = false;
                            break outer;
                        }
                    }
                        break;
                    case 'C': {
                        if (!Cb[num - 1]) { // 해당 불리언배열이 false이면
                            C--;
                            Cb[num - 1] = true;
                        } else {
                            flag = false;
                            break outer;
                        }
                    }
                        break;
                }
            }
            if (flag) {
                System.out.printf("#%d %d %d %d %d\n", t, S, D, H, C);
            } else {
                System.out.printf("#%d %s\n", t, "ERROR");
            }
        }
    }
}
