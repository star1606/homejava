package array03;

public class ArrayEx01 {

	public static void main(String[] args) {
		// �ݺ� stack
		int num = 1;
		for (long i = 2L; i <= 4000000000000000000L; i = i * 2) { // �޸��� ������ �μ��� 1��, �����ݷ��� ������
			System.out.println("2�� " + num + "�� : " + i);
			num++;
		}
	}
}