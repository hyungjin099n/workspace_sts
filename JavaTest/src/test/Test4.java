package test;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1~999 사이의 정수 입력 : ");
        int num = sc.nextInt();

        //132
        //백의 자리수
        int h = num / 100;
        //십의 자리수
        int t = num % 100 / 10;
        //일의 자리수
        int o = num % 10;

        int cnt = 0;
        if(h % 3 == 0 && h != 0){
            cnt++;
        }
        if(t % 3 == 0 && t != 0){
            cnt++;
        }
        if(o % 3 == 0 && o != 0){
            cnt++;
        }

        switch (cnt){
            case 0:
                System.out.println("박수 0번");
                break;
            case 1:
                System.out.println("박수 1번");
                break;
            case 2:
                System.out.println("박수 2번");
                break;
            case 3:
                System.out.println("박수 3번");

        }



    }
}
