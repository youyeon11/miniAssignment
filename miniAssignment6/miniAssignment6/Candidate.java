/*
 * 전유연
 * 미니과제6번. 가상 선거 및 당선 시뮬레이션 프로그램
 * 조건: 입력으로 전체 투표수와 후보자 받음, 결과 미리 확인
 */

package miniAssignment6;

import java.util.*;


public class Candidate {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    
    public static void main(String[] args) {
    	// 투표수 입력
        System.out.print("총 진행할 투표수를 입력해 주세요.");
        int voteOfNumber = scanner.nextInt();
        // 후보자 인원 입력
        System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요.");
        int candidateOfNumber = scanner.nextInt();

        // 후보자 인원만큼 입력
        Map<Integer, String> candidateMap = new HashMap<>(); //기호번호 : 후보자 이름
        for (int i=0; i < candidateOfNumber; i++) {
            System.out.print(String.format("%d번째 후보자이름을 입력해 주세요.", i + 1));
            String candidateName = scanner.next();
            candidateMap.put(i + 1, candidateName);
        }
        System.out.println();
        
        Map<Integer, Integer> candidateVotingResult = executeRandomVote(voteOfNumber, candidateOfNumber, candidateMap);

        Integer resultNumber = getKeyOfMaxValue(candidateVotingResult);
        System.out.println(String.format("[투표결과] 당선인 : %s", candidateMap.get(resultNumber)));
    }

    private static Map<Integer, Integer> executeRandomVote(int voteOfNumber, int candidateOfNumber, Map<Integer, String> candidateMap) {
        Map<Integer, Integer> candidateVotingResult = new HashMap<>(); //기호번호 : 투표 수
        for (int i = 0; i< voteOfNumber; i++) {
            int randomVote = getRandomVote(candidateOfNumber);
            candidateVotingResult.put(randomVote, candidateVotingResult.getOrDefault(randomVote, 0) + 1); //투표 반영
            System.out.println(String.format("[투표진행률]: %.2f%%, %d명 투표 => %s", calculateRatio(i + 1, voteOfNumber), i + 1, candidateMap.get(randomVote)));
            //후보자별로 투표비율, 투표수 출력
            for (int j = 0; j< candidateOfNumber; j++) {
                Integer voteOfCurrent = candidateVotingResult.getOrDefault(j + 1, 0);
                System.out.println(String.format("[기호:%d] %s:\t%.2f%%\t(투표수: %d)", j + 1, candidateMap.get(j + 1), calculateRatio(voteOfCurrent, voteOfNumber), voteOfCurrent));
            }
            System.out.println();
        }
        return candidateVotingResult;
    }


    private static Integer getKeyOfMaxValue(Map<Integer, Integer> candidateVotingResult) {
        
        return Collections.max(candidateVotingResult.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }


    private static int getRandomVote(int candidateOfNumber) {

        return random.nextInt(1, candidateOfNumber + 1);
    }


    private static float calculateRatio(int num, int total) {

        return ((float) num / total) * 100;
    }

}