import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q1941_소문난칠공주_gold3 {
	// 좌표 7개를 뽑고
	// 만약 지금까지 뽑은 케이스가 인접해있지 않으면 return
	// depth 7을 달성하면 Y가 4명 이상 있는지 확인
	// 맞으면 count up
	// https://code-lab1.tistory.com/218
	static int[][] seats = new int[5][5];
	static boolean[] visited;
	static int n, ans;
	static List<Person> students;

	static class Person {
		int r, c, val;

		public Person(int r, int c, int val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		students = new ArrayList<>();
		for (int r = 0; r < 5; r++) {
			String[] line = in.next().split("");
			for (int c = 0; c < 5; c++) {
				int val = -1;
				if (line[c].equals("Y")) {
					seats[r][c] = val = 1;// 임도연파(Y)
				} else {
					seats[r][c] = val = 0;// 이다솜파(S)
				}
				students.add(new Person(r, c, val));// students 리스트에 각 학생의 정보 입력
			}
		} // 자리 입력 완료
			// for (int[] line : seats) {
			// System.out.println(Arrays.toString(line));
			// }
			// for (Person person : students) {
			// System.out.print(person.val + " ");
			// }
			// 25명 중 7명 조합 구하기
		n = 7;
		ans = 0;
		visited = new boolean[25];
		Combination(0, 0, 0);

		System.out.println(ans);

	}

	public static void Combination(int depth, int idx, int Lims) {
		if (Lims > 3)
			return; // 임도연파 3명 초과하면 리턴

		if (depth == n) {// 7명 뽑으면
			int[] selected = new int[n];
			int j = 0;
			for (int i = 0; i < 25; i++) {
				if (visited[i]) {// 뽑힌 학생에 대해서
					selected[j++] = i;
				}
			} // 뽑힌 학생들의 번호 저장 (0-24)
			boolean[] checked = new boolean[n];// 방문처리배열 초기화
			if (isAdjacent(selected, checked))
				ans++;
		}

		for (int i = idx; i < 25; i++) {
			visited[i] = true;
			Combination(depth + 1, i + 1, Lims + students.get(i).val);
			visited[i] = false;
		}
	}

	public static boolean isAdjacent(int[] selected, boolean[] checked) {// 선택학생 배열 + 이들을 방문체크하는 배열
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		Queue<Person> queue = new LinkedList<>();
		queue.offer(students.get(selected[0]));
		checked[0] = true;

		while (!queue.isEmpty()) {
			Person root = queue.poll();

			for (int i = 0; i < 4; i++) { // 선택된 학생 주변 4방탐색
				int nr = root.r + dr[i];
				int nc = root.c + dc[i];
				if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5)
					continue;
				for (int j = 0; j < n; j++) {// j번째 선택된 학생에 대해서
					if (students.get(selected[j]).r == nr && students.get(selected[j]).c == nc && !checked[j]) {
						queue.offer(students.get(selected[j]));// 큐에 넣고
						checked[j] = true;// 방문처리
					}
				}
			}
		}
		// while loop 빠져나오면 큐가 비어있다는 뜻 = 인접학생 다 돌았음!
		// visit안된 학생 있으면 모두 인접하지 않음.
		for (int i = 0; i < n; i++) {
			if (checked[i] == false) {
				return false;
			}
		}
		return true;
	}
}
