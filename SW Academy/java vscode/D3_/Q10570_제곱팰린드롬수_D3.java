import java.util.Scanner;

class Q10570_제곱팰린드롬수_D3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int A = in.nextInt();
            int B = in.nextInt();
            // 5 이상 8 이하 = 5,6,7,8
            int count = 0;
            for (int i = A; i <= B; i++) {
                // 먼저 i가 팰린드롬인지 검사
                char[] charArr = Integer.toString(i).toCharArray();
                boolean isPal = false;
                for (int j = 0; j <= charArr.length / 2; j++) {
                    // 한쌍이라도 팰린드롬이 아니면 false, 루프 탈출
                    if (charArr[j] != charArr[charArr.length - j - 1]) {
                        isPal = false;
                        break;
                    } else {
                        isPal = true;
                    }
                }
                // 그담에 i의 제곱근이 팰린드롬인지 검사 -> isPal이 true이면 검사진행하기.
                boolean isRootPal = false;
                if (isPal) {
                    // 먼저 제곱근이 십진수인지 검사 = 형변환 원리를 이용
                    boolean isInteger = Math.sqrt(i) == (int) Math.sqrt(i);
                    if (isInteger) {
                        char[] rootCharArr = Integer.toString((int) Math.sqrt(i)).toCharArray();
                        for (int j = 0; j <= rootCharArr.length / 2; j++) {
                            if (rootCharArr[j] != rootCharArr[rootCharArr.length - 1 - j]) {
                                isRootPal = false;
                                break;
                            } else {
                                isRootPal = true;
                            }
                        }
                    }
                }

                if (isPal && isRootPal)
                    count++;
            }
            System.out.printf("#%d %d\n", t, count);
        }
    }
}