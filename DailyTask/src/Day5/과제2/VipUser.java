package Day5.과제2;

public class VipUser extends User {
	private String grade;
	private int point;

	public VipUser() {

	}

	public VipUser(String id, String password, String name, String email, int age, String grade, int point) {
		super(id, password, name, email, age);
		this.grade = grade;
		this.point = point;

	}

	// getter and setters
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override // this.안붙인 변수 있는데 나중에 확인!
	public String toString() {
		return "VipUser [grade=" + grade + ", point=" + point + ", id=" + this.getId() + ", password=" + this.getPassword()
				+ ", name()=" + this.getName() + ", email()=" + this.getEmail() + ", age=" + this.getAge() + "]";
	}

}
