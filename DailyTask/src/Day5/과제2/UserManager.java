package Day5.과제2;


import java.util.Arrays;
public class UserManager {
	private int size = 0;
	//최대 사용자 개수
	private final int MAX_SIZE = 100;
	private User[] userList = new User[MAX_SIZE];
	
	//사용자 추가
	public void add(User user) {
		//최대 사용자 개수에 도달하지 않으면 사용자 추가
		if(size<MAX_SIZE) {
			userList[size++] = user;
		} else {
			System.out.println("유저의 수가 100을 넘었습니다. 등록이 불가합니다.");
		}
		
	}
	
	//등록된 사용자 리스트 반환
	public User[] getList() {
		return userList; //Arrays.copyofRange(userList,0,size)
	}
	//사용자들의 평균 나이를 계산하여 반환
	public double getAgeAvg() {
		int sum = 0;
		for(int i=0; i<this.size; i++) {
			sum+=userList[i].getAge();
		}
		return sum/size;
		
	}
	//일반 사용자만 반환
	public User[] getUsers() {
		int cnt = 0;
		
		for(int i=0; i<this.size; i++) {
			//리스트 안의 객체가 vipUser 클래스의 인스턴스인지 검사
			if(!(userList[i] instanceof VipUser)) {
				cnt++;
			}
		}
		if(cnt == 0) return null;
		
		User[] res = new User[cnt++];
		
		for(int i=0, index=0; i<this.size; i++) {
			//리스트 안의 객체가 vip 클래스의 인스턴스인지 검사
			if(!(userList[i] instanceof VipUser)){
				res[index++] = userList[i];
			}
		}
		return res;
	}
	//VipUser만 반환
	public VipUser[] getVipUsers() {
		int cnt = 0;
		
		for(int i=0; i<this.size; i++) {
			if(userList[i] instanceof VipUser) {
				cnt++;
			}
		}
		if(cnt==0) return null;
		
		VipUser[] res = new VipUser[cnt];
		
		for(int i=0, index=0; i<this.size; i++) {
			if(userList[i] instanceof VipUser) {
				res[index++] = (VipUser)userList[i];
			}
		}
		return res;
	}
	
	//제공된 name과 일치하는 이름을 가진 사용자 객체 반환
	public User[] searchByName(String name) {
		
		int cnt = 0;
		
		for(int i=0; i<this.size; i++) {
			//주어진 이름을 포함하는 사용자인지 검사.
			if(userList[i].getName().contains(name)) {
				cnt++;
			}
		}
		if(cnt==0) return null;
		
		User[] result = new User[cnt];
		
		for(int i=0, index =0; i<this.size; i++) {
			if(userList[i].getName().contains(name)) {
				result[index++] = userList[i];
			}
		}
		
		return result;
	}
	
}
