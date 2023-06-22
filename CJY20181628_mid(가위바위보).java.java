package gwaje;

import java.util.Scanner;

public class Gawibawibo {

	public static void main(String[] args) {
		System.out.println("가위바위보 게임을 시작하겠습니다\n"
				+ "게임을 종료하시려면 '종료'라고 입력해주세요");
		boolean outBreak = true;
		while(outBreak) {
			int regame = 0; // 게임을 다시 시작하기 위한 변수
			int result=0; // 게임을 끝내기 위한 변수
			int game = (int)(Math.random()*3);
			String[] com = {"가위","바위","보"};
			Scanner scan = new Scanner(System.in);
			System.out.println("'가위' '바위' '보' 중에 하나를 입력해주세요\n");
			String input = scan.nextLine();
			System.out.println("플레이어 :"+input);
			if(input.equals("종료")) {
				System.out.println("종료되었습니다.");
				outBreak = false;break;
			}
			System.out.println("컴퓨터 : "+com[game]);
			
			if(input.equals("가위")) {
				if(game==0) {
					System.out.println("비겼습니다.");
				}else if(game==1) {
					System.out.println("졌습니다.");
					result = 1;
				}else if(game==2) {
					System.out.println("이겼습니다.");
					result = 1;
				}
			}
			else if(input.equals("바위")) {
				if(game==0) {
					System.out.println("이겼습니다.");
					result = 1;
				}else if(game==1) {
					System.out.println("비겼습니다.");
				}else if(game==2) {
					System.out.println("졌습니다.");
					result = 1;
				}
			}
			else if(input.equals("보")) {
				if(game==0) {
					System.out.println("졌습니다.");
					result = 1;
				}else if(game==1) {
					System.out.println("이겼습니다.");
					result = 1;
				}else if(game==2) {
					System.out.println("비겼습니다.");
				}
			}else {
				System.out.println("똑바로 입력하세요");
			}
			while(result==1) {
				System.out.println("한번 더 하시겠습니까?\n"
						+ "예(1), 아니오(2)");
				regame = scan.nextInt();
				if(regame==1) { // 다시 할것인지 플레이어에게서 의견을 받아옴
					result=0;
					continue;
				}else{
					result=0;
					outBreak = false;
				}
			}
			
		
	}System.out.println("\n종료되었습니다.");

}
}