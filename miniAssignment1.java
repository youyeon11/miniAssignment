/*
 * 전유연
 * 미니과제1번. 구구단 출력하기
 * 조건: 다중 반복문 이용, String.format 사용
 */


public class miniAssignment1 {
	public static void main(String[] args) {
		System.out.println("[구구단 출력]");
		//for문 중첩을 통한 구구단 출력
		for (int i = 1; i <10; i++) {
			System.out.println();
			for (int j =1; j<10; j++) {
				System.out.print(String.format("%02d", i)+" x "+String.format("%02d", j)+" = "+ String.format("%02d", (i*j))+"\t");
			}
		}
	}
}