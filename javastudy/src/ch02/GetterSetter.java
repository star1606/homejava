package ch02;

class 통장{
	private int num;
	private String password;
	
	public 통장(int num, String password) {
		this.num = num;
		this.password = password;
	}
	
	
	public void 통장잔액확인(String password) {
		if(this.password == password) {
			System.out.println("잔액은 : " + num);
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}
	
	public void 통장입금(String password, int money) {
		if(this.password == password) {
			num = num + money;
			System.out.println("잔액은 : " + num);
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}
}

public class GetterSetter {
	public static void main(String[] args) {
		
		//신규가입
		통장 my = new 통장(10000, "a1234");
		
		my.통장잔액확인("a1234");
		
	}
}
