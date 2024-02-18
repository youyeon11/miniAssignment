/*
 * 전유연
 * 미니과제5번. 달력 출력 프로그램
 * 조건: Scanner 클래스 사용, Calendar와 Date 클래스 사용 or LocalDate 클래스를 사용, 년도와 월을 입력받기, 3달 출력하기
 */


import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class miniAssignment5 {
	public static void main(String[] args) {
		System.out.println();

	    Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("달력의 년도를 입력 해주세요.(yyyy): ");
		int year = sc.nextInt(); //년도
		System.out.println("달력의 월을 입력 해주세요.(mm): ");
		int month = sc.nextInt(); //월
		int day = cal.get(Calendar.DATE);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		
		
		cal.set(Calendar.YEAR, year); //입력받은 년도로 세팅
		cal.set(Calendar.MONTH, month); //입력받은 월로 세팅		
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(week);
		System.out.println(lastDay);
		
		//이전달 출력
		Calendar cal2 = Calendar.getInstance();
		int year2 = year;
		int month2 = month-1;
		
		cal2.set(Calendar.YEAR, year2);
		cal2.set(Calendar.MONTH, month2);
		int day2 = cal2.get(Calendar.DATE);
		int week2 = cal2.get(Calendar.DAY_OF_WEEK);
		int lastDay2 = cal2.getActualMaximum(Calendar.DATE);
		
		System.out.println(year2);
		System.out.println(month2);
		System.out.println(day2);
		System.out.println(week2);
		System.out.println(lastDay2);
		
		//다음달 출력
		Calendar cal3 = Calendar.getInstance();
		int year3 = year;
		int month3 = month+1;
		
		cal3.set(Calendar.YEAR, year3);
		cal3.set(Calendar.MONTH, month3);
		int day3 = cal3.get(Calendar.DATE);
		int week3 = cal3.get(Calendar.DAY_OF_WEEK);
		int lastDay3 = cal3.getActualMaximum(Calendar.DATE);
		
		System.out.println(year3);
		System.out.println(month3);
		System.out.println(day3);
		System.out.println(week3);
		System.out.println(lastDay3);
		
	}
}