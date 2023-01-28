package Day6.실습4;

public class KoreanRestaurant extends Restaurant{
	private String number;
	private String breaktime;
	
	public KoreanRestaurant() {
		
	}

	public KoreanRestaurant(int resid, String name, String address, String signatureMenu, int rate, String number, String breaktime) {
		super(resid, name, address, signatureMenu, rate);
		this.number = number;
		this.breaktime = breaktime;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBreakTime() {
		return breaktime;
	}

	public void setBreakTime(String breakTime) {
		this.breaktime = breakTime;
	}

	@Override
	public String toString() {
		return "KoreanRestaurant [number=" + number + ", breakTime=" + breaktime + ", resid=" + resid + ", name=" + name
				+ ", address=" + address + ", signatureMenu=" + signatureMenu + ", rate=" + rate + "]";
	}
	
	
}
