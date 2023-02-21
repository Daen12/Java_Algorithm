import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q10158_개미ver2_silver4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st1.nextToken());
        int y = Integer.parseInt(st1.nextToken());
        int T = Integer.parseInt(br.readLine());

        // x와 y를 따로 보기!
        // 처음 x에서 가로길이 w * 2만큼 가면 제자리로 돌아옴.
        // 처음 y에서 세로길이 h * 2만큼 가면 제자리로 돌아옴.
        // 따라서 x가 기존자리에서 z만큼 움직였다고 했을때
        // z = T%(w*2), x+z = 새로운 좌표
        // 이때 x+z가 w를 넘어가면
        // 2w에서 x+z를 뺀 절댓값이 답.
        // 세로도 똑같음
        x += T % (w * 2); //12
        y += T % (h * 2);
        if (x > w)
            x = Math.abs(w * 2 - x);
        if (y > h)
            y = Math.abs(h * 2 - y);

        System.out.println(x + " " + y);
    }
}
