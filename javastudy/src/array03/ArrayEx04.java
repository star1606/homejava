package array03;

public class ArrayEx04 {
	public static void main(String[] args) {
		// ���� 100������ �� �߿��� 3�� ����� ���� ���Ͻÿ�.
		int sum = 0;
		for (int i = 3; i <= 100; i = i + 3) {
			sum = sum + i;
		}
		System.out.println(sum);
	}
}