/**
 * 전유연
 * 미니과제7번. 로또 당첨 프로그램
 * 조건: Scanner class 사용, 조건문과 반복문 배열 이용, 입력값으로 구매수량 받음, 당첨번호 생성, 판단 프로그램 작성
 */

import java.util.Scanner;

import javax.sql.rowset.serial.SQLOutputImpl;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class miniAssignment7{
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    Random random = new Random();
	    
		System.out.println("[lotto 로또 프로그램]");
		System.out.println();
		//구매 수량 입력
        System.out.print("로또 개수를 입력해 주세요.(숫자 1~10): ");
        int lottoNumber = scanner.nextInt();
        //구매 수량만큼의 로또 개수 생성
        int lotto[] = new int[6];
        for (int n = 0; n < lottoNumber; n++) {
	        for (int i = 0; i < lotto.length; i++) {
	        	int num = (int)(Math.random() *45)+1;
	        	lotto[i] = num;
	        	for(int j = 0; j < i; j++) {
	        		if(lotto[i]==lotto[j]) {
	        			i--;
	        			break;
	        			}
	        		System.out.print(lotto[i]+ ", ");
	        		}
	        	}
        }
        
		
		//당첨 로또 번호 생성
        System.out.println("[로또 발표]");
		int number[] = new int[6];
		Arrays.fill(number, 0);
		int idx = 0;
		while(true) {
			int zero=0;
			for(int i = 0; i < number.length; i++) {
				if(number[i]==0) {
					zero ++;
				}
			}
			if (zero <= 0) {
				break; // 조건 만족하면 while 종료
			}
			else {
				int random_number = random.nextInt(45)+1;
				
				int check = 0;
				for (int k=0; k<number.length; k++) {
					if (number[k] ==random_number) {
						check ++;
					}
				}
				
				if (check <= 0) {
					number[idx] = random_number;
					idx++;
				}
			}
		System.out.println(number);
		} //while문 종료
		
		// 일치하는 개수 세기
		int count = 0;
		for (int j=0; j<lotto.length; j++) {
			for (int h=0; h < number.length; h++) {
				if (lotto[j] ==  number[h]) {
					count ++;
				}
			}
		}
		
		System.out.println("[내 로또 결과]");
		for (int m = 0; m < lottoNumber; m++) {
			System.out.println(lotto[m] + "맞힌 개수 : "+count);
		
			if (count == 6) {
				System.out.println("등수 : 1등입니다");
			}
			else if (count == 5) {
				System.out.println("등수 : 2등입니다");
			}
			else if ( count == 4) {
				System.out.println("등수 : 3등입니다");
			}
			else {
				System.out.println("등수 : 꽝... 입니다");
			}
		}
	}
}
