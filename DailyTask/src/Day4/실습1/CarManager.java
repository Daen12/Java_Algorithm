package Day4.실습1;

import java.util.Arrays;

public class CarManager {
	// Car타입의 배열??
	private final int MAX_SIZE = 100;
	private Car[] carList = new Car[MAX_SIZE];
	private int size = 0;

	// 전체 개수가 100이 아닐때 저장하고 true 반환. 넘었다면 false를 반환
	public boolean add(Car car) {
		if (size < 100) {
			carList[size] = car;
			++size;
			return true;
		} else {
			return false;
		}
	}

	// 현재 등록된 자동차 반환
	public Car[] getList() {
		return Arrays.copyOfRange(carList, 0, size);
	}

	public Car[] searchByModelName(String model) {
		int cnt = 0;
		for(int i=0; i<this.size; i++) {
			if(carList[i].getModelName().contains(model)) {
				cnt++;
			}
		}
		if(cnt==0) return null;
		
		int idx = 0;
		Car[] result = new Car[cnt];
		for(int i=0; i<this.size; i++) {
			if(carList[i].getModelName().contains(model)) {
				result[idx++] = carList[i];
			}
		}
		return result;
	}
	
}

