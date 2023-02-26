import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q7272_안경이없어_D3 {
    public static void main(String[] args) throws IOException {
        char[] ref = { 'B', 'A', 'D', 'O', 'P', 'Q', 'R' };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] A = st.nextToken().toCharArray();
            char[] B = st.nextToken().toCharArray();
            String answerA = "";
            String answerB = "";
            String result = "DIFF";
            if (A.length == B.length) { // 만약 두 문자열의 길이가 같다면

                for (int i = 0; i < A.length; i++) {
                    boolean flagA = false;
                    boolean flagB = false;
                    for (int j = 0; j < ref.length; j++) {
                        if (A[i] == ref[j]) { // ref의 j번째 인덱스와 같을때
                            if (j == 0) {
                                answerA += "2";
                            } else {
                                answerA += "1";
                            }
                            flagA = true;
                        }
                        if (B[i] == ref[j]) { // ref의 j번째 인덱스와 같을때
                            if (j == 0) {
                                answerB += "2";
                            } else {
                                answerB += "1";
                            }
                            flagB = true;
                        }
                    }
                    // j다 돌아도 없으면 0을 append한다.
                    if (!flagA) {
                        answerA += "0";
                    }
                    if (!flagB) {
                        answerB += "0";
                    }
                }
                // answerA와 answerB의 값을 비교해서 같으면 SAME
                if (answerA.equals(answerB))
                    result = "SAME";
            }
            System.out.printf("#%d %s\n", t, result);
        }
    }
}
