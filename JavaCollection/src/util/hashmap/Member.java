package util.hashmap;

public class Member {
	/*=====필드======*/
	private String userid,name,address,password;
	private int age;
	
	/*===== 생성자 =====*/
	public Member() {}
		
	
	
	/*===== 멤버 메소드 =====*/
	public String getUserid() {
		return userid;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPassword() {
		return password;
	}

	public int getAge() {
		return age;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
