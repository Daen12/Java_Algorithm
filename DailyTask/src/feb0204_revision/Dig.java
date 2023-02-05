package feb0204_revision;

public class Dig {
	String name;
	int age;
	
	Dig(){
		this("쫑");
	}
	
	Dig(String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dig [name=" + name + ", age=" + age + "]";
	}
	public void Class() {
		
	}
	public static void main(String[] args) {
		Dig d = new Dig();
		System.out.println(d.name);
	}
	
	public class Puppy{
		String name;
		int age;
		int birthday;
		
		
	}
	
	
}

 
