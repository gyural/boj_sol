import java.util.Scanner;

public class Main {

	// 그리디 알고리즘
	public static void main(String[] args) {
		// 1개일때 2개일때 3개일때..... 가능한  경우를 완전 탐색해보기

		Scanner sn = new Scanner(System.in);
		int N = Integer.parseInt(sn.nextLine());

		int result = -1;
		for (int i=1; i<=2000; i++){
			for (int j=0; j<=i; j++){
				// j개 5Kg (i-j)개 3Kg
				int weight = (5 * j) + (3 * (i-j));

				if (weight == N){
					System.out.println(i);
					return;
				}
			}

		}
		if (result == -1) {
			System.out.println(-1);
		}
	}
}
