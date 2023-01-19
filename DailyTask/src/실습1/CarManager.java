package 실습1;

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
		Car[] result = new Car[size];
		for (int i = 0; i < size; i++) {
			result[i] = carList[i];
		}
		return result;
	}

	// 해당 인자를 가진 자동차 배열 반환
	public Car[] searchByModelName(String modelName) {
		int cnt = 0;
		// this.size는 위에서 정의한size를 의미함.
		// 아래 코드에서는 carList를 돌면서 찾는 문자 포함하는 모델의 차가 몇개있는지 카운트함.
		for (int i = 0; i < this.size; i++) {
			if (carList[i].getModelName().contains(modelName))
			cnt++;
		}

		Car[] result = new Car[cnt];
		int idx = 0;
		for (int i = 0; i < this.size; i++) {
			if (carList[i].getModelName().contains(modelName)) {
				result[idx] = carList[i];
				idx++;
			}
		}
		return result;

	}
}
