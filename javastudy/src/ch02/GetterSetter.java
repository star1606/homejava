package ch02;

class ����{
	private int num;
	private String password;
	
	public ����(int num, String password) {
		this.num = num;
		this.password = password;
	}
	
	
	public void �����ܾ�Ȯ��(String password) {
		if(this.password == password) {
			System.out.println("�ܾ��� : " + num);
		} else {
			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		}
	}
	
	public void �����Ա�(String password, int money) {
		if(this.password == password) {
			num = num + money;
			System.out.println("�ܾ��� : " + num);
		} else {
			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		}
	}
}

public class GetterSetter {
	public static void main(String[] args) {
		
		//�ű԰���
		���� my = new ����(10000, "a1234");
		
		my.�����ܾ�Ȯ��("a1234");
		
	}
}