package util.hashmap;

public interface MemberService {
	/*
	 회원가입
	 */
	public void join(String userid,String password,String name,int age,String address);
	/*
	 로그인
	 */
	public String login(String userid,String password);
	
}
