package Day5.과제2;


public class User {
	// 기본 변수 외부 접근 못하게 설정
	private String id;
	private String password;
	private String name;
	private String email;
	private int age;
	
	public User() {} //기본생성자
	
	//매개변수 등록 가능한 생성자
	public User(String id, String password, String name, String email, int age) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.age = age;
	}
	
	//직접 접근하는 대신 getter/setter 메소드로 접근 가능하도록 만들기
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	//toString 메소드 추가하기
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", age=" + age
				+ "]";
	}

}