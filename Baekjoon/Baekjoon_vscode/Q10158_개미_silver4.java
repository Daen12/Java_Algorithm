import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q10158_개미_silver4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 먼저 개미 위치 격자의 좌표를 r만 바꾸고 r,c순서 바꾸어 입력받기(h-r);
        // 처음에는 -1, 1 더하다가
        // 범위를 만나면 (r=0 || c = 0) 규칙대로 방향을 바꾸기.
        // 만약 r=0이거나 h인 상황이면 r이 바뀜.
        // 만약 c=0이거나 w인 상황이면 c가 바뀜.
        // 만약 (0,0), (0,w), (h,0), (h,w)이면 좌표 둘다 바뀜.
        // 이것을 t번 반복. 그후 좌표를 출력!
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st1.nextToken());
        int r = h - (Integer.parseInt(st1.nextToken()));
        int T = Integer.parseInt(br.readLine());
        int t = 0;
        int nr = -1;
        int nc = 1; // 처음 방향 = 우상향
        while (t < T) {
            // 아무 조건에도 부딪히지 않는다면 기존 방향대로 계속 더해가기
            r += nr;
            c += nc;
            t++;
            // 밑의 조건에 부딪히면 방향 바꾸기(nr. nc)
            if (r == 0 || r == h) {
                nr *= -1;
            }
            if (c == 0 || c == w) {
                nc *= -1;
            }
        }
        System.out.println(c + " " + (h - r));
    }
}
