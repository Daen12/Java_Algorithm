import java.util.Scanner;
import java.util.*;

public class Q8979_올림픽_silver5 {
    static int N, K;
    static Country[] countries;

    static class Country {
        int num;
        int gold;
        int silver;
        int bronze;
        int ord;

        public Country(int num, int gold, int silver, int bronze, int ord) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.ord = ord;
        }
    }

    public static void main(String[] args) {
        // 금, 은, 동메달 순으로 배열 만들고
        // 국가번호-1에 해당하는 인덱스 출력하기
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        K = in.nextInt();
        countries = new Country[N];
        for (int i = 0; i < N; i++) {
            countries[i] = new Country(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), 1);
        }

        Arrays.sort(countries, (Country c1, Country c2) -> {
            // 음수면 그대로 유지
            // 앞으로 갈수록 높은 스코어. (스코어 기준 내림차순)
            if (c1.gold > c2.gold) {
                return -1;
            } else if (c1.gold == c2.gold) {
                if (c1.silver > c2.silver) {
                    return -1;
                } else if (c1.silver == c2.silver) {
                    if (c1.bronze > c2.bronze) {
                        return -1;
                    } else if (c1.bronze == c2.bronze) {
                        // 다 같으면!
                    }
                }
            }
            return 1;
        });

        for (int i = 0; i < countries.length - 1; i++) {

            if (countries[i].gold == countries[i + 1].gold &&
                    countries[i].silver == countries[i + 1].silver &&
                    countries[i].bronze == countries[i + 1].bronze) {
                countries[i + 1].ord = countries[i].ord;
            } else {
                countries[i + 1].ord = i + 1;
                System.out.println(countries[i + 1].ord);
            }
        }
        // for (Country c : countries) {
        // System.out.print(c.ord + " ");
        // }
        // System.out.println();
        // for (Country c : countries) {
        // System.out.print(c.num + " ");
        // }
        for (int i = 0; i < countries.length - 1; i++) {
            if (countries[i].num == K)
                System.out.println(i + 1);
        }

    }

}
