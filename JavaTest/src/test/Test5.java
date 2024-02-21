package test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] baseball = new int[3];

        // 1.0 <= x < 10.0
        for(int i = 0 ; i < baseball.length ; i++){
            baseball[i] = (int)(Math.random() * 9 + 1);

            for(int j = 0 ; j < i ; j++){
                if(baseball[i] == baseball[j]){
                    i--;
                    break;
                }
            }
        }

        System.out.println("---만들어진 배열---");
        System.out.println(Arrays.toString(baseball));
        System.out.println();

        System.out.println("숫자를 정했습니다. 게임을 시작합니다~");

        int[] answer = new int[3];
        int cnt = 0;
        while(true){
            System.out.print(++cnt + " >> ");
            answer[0] = sc.nextInt();
            answer[1] = sc.nextInt();
            answer[2] = sc.nextInt();

            //스트라이크 , 볼 계산
            int strike = 0;
            int ball = 0;
            for(int j = 0 ; j < baseball.length ; j++){
                for(int i = 0 ; i < answer.length ; i++){
                    if(baseball[j] == answer[i]){
                        if(i == j){
                            strike++;
                        }
                        else{
                            ball++;
                        }
                    }
                }
            }

            System.out.println(strike + "스트라이크 " + ball + "볼");
            if(strike == 3){
                System.out.println(cnt + "회 만에 숫자를 맞췄습니다.");
                break;
            }
        }




    }
}
