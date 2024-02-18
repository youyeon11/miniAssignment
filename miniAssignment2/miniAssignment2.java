/*
 * 전유연
 * 미니과제2번. 결제 금액 캐시백 계산 프로그램
 * 조건: Scanner 클래스 사용, 결재 금액에서의 10%를 적립, 캐시백은 100원 단위, 300원 초과 불가
 */



import java.util.Scanner;

public class miniAssignment2 {
	public static void main(String[] args) {
		System.out.println("[캐시백 계산]");
		//입력
		Scanner sc = new Scanner(System.in);
		//금액 입력
		System.out.println("결제 금액을 입력해 주세요.(금액): ");
		int price = sc.nextInt(); //nextInt(): Integer를 입력받아 리턴
		
		int cashback = (int)(price * 0.1 / 100) * 100; //10% 적립이며 100 단위라는 조건 만족하는 캐시백 계산
		if (cashback > 300) { //캐시백의 상한선 300 설정
			cashback = 300;
		}
		
		System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원 입니다.\n", price, cashback);
	}
}