/*
 * 전유연
 * 미니과제3번. 놀이동산 입장권 계산 프로그램
 * 조건: 나이, 기타우대사항 등에 따라 입장권의 가격 달라짐을 반영, 조건에 맞는 로직 작성, 순서는 나이-> 입장시간->국가유공자여부->복지카드 여부
 * */


import java.util.Scanner; //Scanner 클래스를 사용
import java.util.InputMismatchException;


public class miniAssignment3 {
	public static void main(String[] args) {
		//값 입력 받기
		Scanner sc = new Scanner(System.in);
		//초기화
		int age = 0;
		int hour = 0;
		String case1 ="";
		String case2 ="";
		int[] price = {10000, 4000, 8000}; //{기본, 특별할인, 일반할인}
		
		while(true) {
			try {
				System.out.println();
				System.out.println("[입장권 계산]");
				System.out.print("나이를 입력해 주세요.(숫자) : ");
				age = sc.nextInt(); //입력받은 정수를 반환
				System.out.print("입장시간을 입력해 주세요.(숫자입력) : ");
				hour = sc.nextInt();
				//올바른 형식의 값 입력했는지 확인
				if (age < 0 || hour < 0) {
					System.out.println("0보다 큰 수를 입력해주시기 바랍니다.");
					continue; // 조건에 해당될때까지 다시 입력을 요구
				} else if (age ==0 || hour == 0) {
					System.out.println("프로그램을 종료합니다.");
					break;
				} else if ( hour > 24) {
					System.out.println("시간은 24시를 초과할 수 없습니다.");
					continue; //다시 입력을 반복
				}

			} catch (InputMismatchException e) {
				System.out.println("숫자만을 입력해주시기 바랍니다.");
				sc.nextLine();
			}
			System.out.print("국가유공자 여부를 입력해 주세요.(Y/N) : ");
			case1 = sc.next();
			System.out.print("복지카드 여부를 입력해 주세요.(Y/N) : ");
			case2 = sc.next();
			//나이에 따른 조건식을 입력
			if (age <3) { //3살보다 어리면 입장료 무료
				System.out.printf("입장료 : 무료");
			} else {
				if (age <13 || hour > 17) {
					System.out.printf("입장료 : %s", String.format("%4d", price[1]));
				} else if (case1.equalsIgnoreCase("y") || case2.equalsIgnoreCase("y")) {
					System.out.printf("입장료 : %s", String.format("%4d", price[2]));
				} else {
					System.out.printf("입장료 : %s", String.format("%4d", price[0]));
				}
			}
		} // while의 끝
	}
}