package util.vector;
// 전체에서 특정 글자 바꾸기 단축키 CTRL + A > CTRL + F
// Vector은 elementAt을 쓰고 ArrayList는 get를 쓴다
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
/*
 프로그램을 코딩하다 보면
 자료구조를 다루는데 있어서 
 CRUD 액션의 반복을 겅험하게 됩니다.
 Create : 입력, 생산
 Read : 조회, 출력
 Update : 수정 -> 저장된 값을 수정 DB
 Delete : 삭제 -> 완전삭제 DB, null 값으로 바꾸는 삭제
 */
public class GradeServiceImpl implements GradeService{
	//필드에 아래 메소드들이 공유할 자료구조를 뭘 쓸까?
	// 1. ArrayList 2. Vector 3. Stack 4. HashMap
	// 순서 O, 중복 O
	
	private List<Grade> vec = new ArrayList<Grade>(); 
	Grade grade = new Grade(); // 디폴트 생성자가 있어서 에러 제거
	
	@Override
	public void input(Grade grade) {
		// 성적표 입력
		// 만약 자료구조로 배열을 사용했다면 = vec[0] = hong;
		vec.add(grade);
	}

	@Override
	public void printList() {
		// 전체 출력
		System.out.println(vec.toString());
		
	}

	@Override
	public String searchGradeByHakbun(String hakbun) {// 학번으로 검색
		// msg = grade.toString();
		String msg = "";
		Grade grade = null; // 지변으로 인스턴스를 선언했으므로 초기화 해야함
		// List 계열의 클래스 길이는 size() 구한다.
		for (int i = 0; i <vec.size(); i++) {
			// 만약 vec 가 배열이라면
			// vec.get(i)
			String searchHakbun = vec.get(i).getHakbun();
			// 객체.메소드.메소드.메소드.메소드 이런
			// 패턴은 반드시 return 값이 있는
			// 메소드들 끼리 연결시에만 가능하다.
			// 이런 방식을 메소드 체인이라고 함
			if (hakbun.equalsIgnoreCase(searchHakbun)) {
				String name = vec.get(i).getName();
				int kor = vec.get(i).getKor();
				int eng = vec.get(i).getEng();
				int math = vec.get(i).getMath();
				grade = new Grade(searchHakbun,name,kor,eng,math);
				msg = grade.toString();
				break; // 중간이라도 학번이 일치하면 그대로 스톱
			} else {
				msg = "조회하는 학번이 없습니다.";
			}
			
		}
		return msg;
	}
	
	@Override
	public  Vector<Grade> searchGradeByName(String name) {// 이름으로 성적 조회
		Vector<Grade> temp = new Vector<Grade>();
		Grade grade = null; // 자료구조를 만들어주고 자료구조를 만들어주는 객체를 만듬
		for (int i = 0; i < vec.size(); i++) {
			String searchGradeByName = vec.get(i).getName();
			//고정값(파라미터).equals(변수값)
			if (name.equalsIgnoreCase(searchGradeByName)) {
				grade = new Grade(searchGradeByName, 
						vec.get(i).getHakbun(),
						vec.get(i).getKor(), 
						vec.get(i).getEng(),
						vec.get(i).getMath());
				temp.add(grade);
			} else {
				// temp 라는 벡터를 완전히 비워서 null 로 리턴
				temp.remove(new Grade());
			}
		}
		return temp;
	}
	
	@Override
	public void descByTotal() {// 성적 정렬
		// Java API 중에서 정렬을 담당하는 클래스 -> Comparator 
		// 인터페이스를 구현한 익명 내부 클래스 
		// anonymous inner class 
		Comparator<Grade> desc = new Comparator<Grade>() {
			
			@Override
			public int compare(Grade g1, Grade g2) {
				// 삼항 연산자
				/*
				 if(condition){
				 	--> true 면 statement 실행
				 }else{
				 	--> false 면 statement 실행
				 }
				 (condition) ? 참 : 거짓;
				
				if ((g1.getTotal()<g2.getTotal())) {
					return 1;
				} else {
					if (g1.getTotal()== g2.getTotal()) {
						temp =  0;
					}else {
						temp = -1;
					}
				}
				return temp;
				*/
				return (g1.getTotal() < g2.getTotal()) ? 1 :
						(g1.getTotal() == g2.getTotal()) ? 0 : -1;
			}
		};
		Collections.sort(vec,desc);
		System.out.println(vec.toString());
	}
		
		
	

	@Override
	public void ascByName() {// 이름 오른 차순으로 정렬
		Comparator<Grade> asc = new Comparator<Grade>() {
			
			@Override
			public int compare(Grade g1, Grade g2) {
				// 값(value) 이 int 타입이 아니고
				// String 타입의 우선 순위 결정할 때는 ....
				// compareTo() 라는 메소드를 사용해야한다.
				return g1.getName().compareTo(g2.getName());
			}
		};
		Collections.sort(vec,asc);
		System.out.println(vec.toString());
	}
}
