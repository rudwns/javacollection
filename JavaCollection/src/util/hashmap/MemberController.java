package util.hashmap;

import java.util.Scanner;


public class MemberController {
	public static void main(String[] args) {
	
		MemberService service = new MemberServiceImpl();
		Scanner scan = new Scanner(System.in);
		String input = "", key = "";
		
		while (true) {
			/*메뉴판*/
			System.out.println("[join] : 회원가입, [login] : 로그인, [logout] : 로그아웃");
			 input = scan.next();
			 
			if (input.equals("logout")) {
				System.out.println("로그아웃!!");
				break;
			}else {
				switch (input) {
				case "join": /*회원가입*/
					System.out.println("아이디를 입력하세요");
					String userid = scan.next();
					System.out.println("비밀번호를 입력하세요");
					String password = scan.next();
					System.out.println("이름을 입력하세요");
					String name = scan.next();
					System.out.println("나이를 입력하세요");
					int age = scan.nextInt();
					System.out.println("주소를 입력하세요");
					String address = scan.next();
					service.join(userid,password,name,age,address);
					System.out.println("회원가입 성공");
					break;
				case "logout" :/*로그인*/
					System.out.println("아이디와 입력하세요");
					String userid2 = scan.next();
					System.out.println("비밀번호를 입력하세요");
					String password2 = scan.next();
					String result = service.login(userid2,password2);
					String flag = result.substring(0,5);
					if (flag.equals("환영합니다")) {
						System.out.println(result);
						break;
					} else if (flag.equals("비밀번호를")) {
						
					}else {
						
					}
					
				default:
					System.out.println("로그아웃");
					break;
				}
			}
		}
	}
}
