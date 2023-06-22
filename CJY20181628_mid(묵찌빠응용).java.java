package gwaje;

import java.util.Scanner;

public class RspMjjp3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // scan에다가 스캐너 기능을 넣어서 사용하겠다는 명시이다. scanner를 쓰기 위해서는 import를 꼭 해주어야 한다.
		int player = 0; // player변수에 Scanner로 받아온 값을 받아와서 넣기위해 만들었다.
		int advan = 0; //공격권을 가지고 있는 사람을 의미한다. 1이면 플레이어, 2이면 컴퓨터이다.
		int result = 0; // 게임을 끝내기 위한 변수로써 공격권이 1인 상태에서 while문이 끝나면 플레이어 승 else 는 컴퓨터 승이다.
		int computer = 0; // 컴퓨터 변수에 Math.random()을 이용한 숫자를 대입하기 위해 만들었다.
		int count = 0; // 비겼다는것을 명시하기 위해 카운트 변수를 만들어서 표현해보았다.
		int p_score = 0;//플레이어의 점수를 저장할 변수
		int c_score = 0;//컴퓨터의 점수를 저장할 변수
		int score = 0;//매판 새로운 랜덤점수를 부여하기위한 변수
		int page = 0;
		System.out.println("어서오세요 게임 개발자 Mr.Choi입니다\n" //게임 시작 전 설명선택란
				+ "게임설명을 듣고 시작하려면 1을, 게임을 바로 시작하시려면 아무 숫자나 입력해주세요");
		page = scan.nextInt();
		switch(page) {
		case 1:
			System.out.println("게임에대해서 설명해드리겠습니다.\n" //게임 설명
					+ "게임은 묵찌빠로 진행이 되고 승리시에 처음에 랜덤으로 정해지는 점수를 받게됩니다.\n"
					+ "먼저 10점 이상의 점수를 달성한 쪽이 최종승리하게 되는 게임입니다.\n");break;
		case 2:
			break;
		}
			
		
		System.out.println("묵찌빠 게임을 시작하겠습니다"//게임 시작을 알림
				+ "\n화이팅입니다.\n"); //
		while(p_score<10) { //게임 시작전 랜덤점수를 알려줌
			score = (int)(Math.random()*4+1);
			System.out.println("이번게임은"+score+"점짜리 입니다.");
			
			while(true) { //게임 시작 
				if(count>0) { // 가위바위보를 비겼을 경우를 알려주기위한 문구
					System.out.println("비겼습니다.\n 승리를 기원합니다");
				}
				
				System.out.println("'가위=1','바위=2','보=3'");
				player = scan.nextInt();//플레이어의 입력
				computer = (int)((Math.random()*2)+1); //컴퓨터의 입력
				Sangtae(player,computer);//지금 현 상태를 보여줌
				count++;//비겼을 경우를 알려주기위한 변수
				if(player!=computer) {//플레이어와 컴퓨터가 낸것이 같지않아야 공격권이 결정되기떄문에
					break;
				}
			}
			advan = Gong(player,computer); // 공격권을 정의하고 그 값을 받기위한 변수
			
			while(result==0) {//치열한 공방, 플레이어와 컴퓨터가 낸것이 같으면 결과 1을 리턴,그렇지않다면 계속 반복을 하게 된다.
				switch(advan) {
				case 1:
					System.out.println("공격권을 얻었습니다.");break;
				case 2:
					System.out.println("컴퓨터를 방어하십시오.");break;
				}
				
				System.out.println("가위=1','바위=2','보=3'");
				player = scan.nextInt();
				computer = (int)((Math.random()*3)+1);
				Sangtae(player,computer);
				
				if(player!=computer) {
					advan=Gong(player,computer);
				}else {
					result=1;
				}
			}
			if(advan==1) { // 위에 정의한것과 같이 advan이 1이면 플레이어가 공격권을 쥔 상태로 바로 위의 while문에서 결과값이 나왔기 때문에 플레이어의 승리
				System.out.println("승리하였습니다.\n");
				p_score +=score;
				System.out.println("플레이어의 점수 : "+p_score+"컴퓨터의 점수 :"+c_score+"\n");
				result =0;count=0;
			}else { // 그렇지 않다면 컴퓨터의 승리
				System.out.println("패배하셨습니다.\n");
				c_score += score;
				System.out.println("플레이어의 점수 : "+p_score+"컴퓨터의 점수 :"+c_score+"\n");
				result =0;count=0;
			}
			if(p_score>9) { // 플레이어의 최종 승리를 알리기 위한 문구
				System.out.println("\n\n최종승리하였습니다 축하드립니다!!");break;
			}else if(c_score>9) {//컴퓨터의 최종 승리를 알리기 위한 문구
				System.out.println("\n\n컴퓨터에게 최종패배 하였습니다.");break;
			}
		}
		}
	
	public static void Sangtae(int player, int computer) { //지금 플레이어와 컴퓨터의 진행상태를 반환하는 메소드
		if(player==1) {
			System.out.println("플레이어 : 가위");
		}else if(player==2) {
			System.out.println("플레이어 : 바위");
		}else if(player==3) {
			System.out.println("플레이어 : 보");
		}else {
			System.out.println("똑바로 입력하세요");
		}
		switch(computer) {
		case 1:
			System.out.println("컴퓨터 : 가위");break;
		case 2:
			System.out.println("컴퓨터 : 바위");break;
		case 3:
			System.out.println("컴퓨터 : 보");break;
		}
	}
	
	public static int Gong(int player, int computer) {//공격권을 결정하기 위한 메소드 플레이어가 이기면 1, 컴퓨터가 이기면 2,비기면 0 을 반환한다.
		
		if(player==1) {
			if(computer==3) {
				return 1;
			}else if(computer==2){
				return 2;
			}else {
				return 0;
			}
		
		}else if(player==2) {
			
			if(computer==1) {
				return 1;
			}else if(computer==3){
				return 2;
			}else {
				return 0;
			}
		
		}else if(player==3) {
			
			if(computer==2) {
				return 1;
			}else if(computer==1){
				return 2;
			}else {
				return 0;
			}
		}else {
			return 0;
		}
	}
			
			
}
		
	