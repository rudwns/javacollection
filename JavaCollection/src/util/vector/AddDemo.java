package util.vector;

import java.util.Scanner;
import java.util.Vector;

/*
 java.util.Vector 의 메소드중에
 추가 기능을 담당하는 add()
 */
public class AddDemo {
	public static void main(String[] args) {
		Vector<String> avengers = new Vector<String>();
		//vec.add("신지수");
		
		//크기가 4인 스티링 배열으 ㅣ선언과 생성
		String[] heros = {"iron","thor","hulk","hawk"};
		for (int i = 0; i < heros.length; i++) {
			avengers.add(heros[i]);
		}
		// 자료구조는 저장과 검색이라는 기능을 위해 만들어진 클래스이다.
		// thor 가 avengers 회원인지 검색?
		Scanner scan = new Scanner(System.in);
		System.out.println("어벤져스 회원 검색 ? 이름입력");
		String thor =scan.next();
		if (avengers.contains(thor)) {
			int idx = avengers.indexOf(thor);
			System.out.println(thor+"는"+(idx+1)+"번째에 있습니다.");
		} else {
			System.out.println(thor+" 어벤저스 회원이 아닙니다.");
		}
		//첫번째 요소 삭제
		avengers.remove(0); // 인덱스값을 파라미터로 전달하면 삭제 완료
		
	}
}
