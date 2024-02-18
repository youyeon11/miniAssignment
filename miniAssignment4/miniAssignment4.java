/* 
 * 전유연
 * 미니과제4번. 주민등록번호 생성 프로그램
 * 조건: Scanner 클래스 사용, Random 클래스 사용, 입력값으로 생년, 월, 일, 성별, 임의번호는 Random의 nextInt()이용
 */


import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;


public class miniAssignment4 {
    public static void main(String[] args) {
    	//값 입력 받기
        Scanner sc = new Scanner(System.in);
        miniAssignment4 main = new miniAssignment4();
        HashMap <String, String> user = new HashMap <String, String>();
        //Random 클래스 사용
        Random random = new Random();
        
        
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        user.put("year", sc.next());
        System.out.print("출생월을 입력해 주세요.(mm):");
        user.put("month", sc.next());
        System.out.print("출생일을 입력해 주세요.(dd)");
        user.put("day", sc.next());
        System.out.print("성별을 입력해 주세요.(m/f)");
        user.put("gender", sc.next());

        main.getUserNumber(user);
    }


    public String prefixUserNumber(HashMap user) {
        return user.get("year").toString().substring(2) + user.get("month") + user.get("day");
    }

    
    public String suffixUserNumber(HashMap user) {
        StringBuffer result = new StringBuffer();
        Random random = new Random();

        int yearInt = Integer.valueOf((String) user.get("year"));

        if(yearInt < 1900) {            // 1800 년대 및 이전
            result.append( "m".equals(user.get("gender")) ? "9" : "0" );
        } else if (yearInt < 2000) {    // 1900 년대
            result.append( "m".equals(user.get("gender")) ? "1" : "2" );
        } else {                        // 2000 년대
            result.append( "m".equals(user.get("gender")) ? "3" : "4" );
        }

        for(int i = 0 ; i < 6 ; i++) {
            result.append( random.nextInt(10) );
        }

        return result.toString();
    }


    public void getUserNumber(HashMap user) {
        System.out.println(prefixUserNumber(user) + "-" + suffixUserNumber(user));
    }

}