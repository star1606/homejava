package array03;

//���� ������ ������ ���ϴ� ���α׷�(500, 100 , 50, 10)
//2680
public class Coin1 {
	public static void main(String[] args) {
		int money = 2680;
		int count = 0;
		System.out.println("���۱ݾ� : " + money);

		for (int i = 500; i > 9; i = i + 0) {

			count = money / i;
			money = money % i;
			System.out.println(i + "�� ���� : " + count);
			System.out.println("���� �ݾ� : " + money);
			
			// Ʈ�� ���� ����
			boolean a = true;
			
			// i�� 5�� ����� a = false
			for (int j = 10; j < 1000000000; j = j * 10) {
				if (i / j == 5) {
					a = false;
				}
			}
			
			// i�� 5�� ������� Ȯ���� ���
			if (a == true) {
				i = i / 2;
			} else {
				i = i / 5;
			}
		}
	}
}