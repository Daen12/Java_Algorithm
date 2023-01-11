import java.util.Scanner;

public class Q1244_silver4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 입력
//	        8 : 스위치 개수
//	        0 1 0 1 0 0 0 1 : 스위치 상태
//	        2 : 학생수
//	        1 3 : 학생의 성별 + 스위치 번호
//	        2 3 : 위와 동일
		Scanner sc = new Scanner(System.in);

		// 스위치 갯수
		int N = sc.nextInt();

		// 스위치 상태
		int[] switchstatus = new int[N + 1];
		for (int i = 1; i <= N; i++) { // 0번째 인덱스에는 암것도 안쓴다.
			switchstatus[i] = sc.nextInt();
		}

		// 학생 수 
		int student = sc.nextInt();
		for (int i = 1; i <= student; i++) {
			// 학생의 성별
			int gender = sc.nextInt();
			// 스위치 번호
			int switchnumber = sc.nextInt();

			// 처리
			// 남학생의 경우 입력받은 수의 배수일 경우 스위치를 바꿔라
			if (gender == 1) {
				for (int j = switchnumber; j <= N; j += switchnumber) {
					if (switchstatus[j] == 0) {
						switchstatus[j] = 1;
					} else {
						switchstatus[j] = 0;
					}
				}
			} else if (gender == 2) { // 여학생의 경우 좌우가 대칭인 최대범위만큼 스위치 바꿔라 = 홀수여야 한다.??
				int left = switchnumber; //3
				int right = switchnumber; //3
				
				//처음에 선택된 인덱스 넘버의 스위치를 바꿔준다.
				if (switchstatus[switchnumber] == 0) {
					switchstatus[switchnumber] = 1;
				} else {
					switchstatus[switchnumber] = 0;
				}

				while (true) {
					left--; //2
					right++; //4

					if (left < 0 || right > N )
						break; // 왼쪽과 오른쪽 인덱스 벗어나면 스톱.

					if (switchstatus[left] == switchstatus[right]) {
						if (switchstatus[left] == 0) {
							switchstatus[left] = 1;
						} else {
							switchstatus[left] = 0;
						}

						if (switchstatus[right] == 0) {
							switchstatus[right] = 1;
						} else {
							switchstatus[right] = 0;
						}
					} else { // 대칭이 아닐 경우
						break;
					}
				}

			}

		}
		// 출력
		for (int i = 1; i <= N; i++) {
			System.out.print(switchstatus[i] + " ");
			if (i % 20 == 0)
				System.out.println(); // 한줄에 20개씩 입력 후 줄바
		}
		
		sc.close();

	}

}
