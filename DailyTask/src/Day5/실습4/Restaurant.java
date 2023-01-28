package Day5.실습4;

public class Restaurant {
	//코드를 작성해주세요.
	int resid;
	String name;
	String address;
	String signatureMenu;
	int rate;
	
	public Restaurant() {
	}
	public Restaurant(int resid, String name, String address, String signatureMenu, int rate) {
		this.resid = resid;
		this.name = name;
		this.address = address;
		this.signatureMenu = signatureMenu;
		this.rate = rate;
	}
	public String toString() {	
		String str = String.format("Restaurant [resId = %s, name = %s, address=%s, signatureMenu=%s, rate=%s", this.resid, this.name, this.address, this.signatureMenu, this.rate);
		
		return str;
		
	}
	public int getResid() {
		return resid;
	}
	public void setResid(int resid) {
		this.resid = resid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSignatureMenu() {
		return signatureMenu;
	}
	public void setSignatureMenu(String signatureMenu) {
		this.signatureMenu = signatureMenu;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
 
}
