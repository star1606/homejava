package array03;

import java.util.Scanner;

public class ArrayEx05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String tempNum = num + ""; // ���ڿ� ���ڿ��� ���ϸ� ���ڿ��̵ȴ�(������ ����ȯ)
		String tempNum2[] = tempNum.split("");
		System.out.println(tempNum2[0]);
		System.out.println("���� : " + tempNum2.length);
		int l3 = tempNum2.length % 3;
		for (int i = 0; i < tempNum2.length - 1; i++) {
			if (i % 3 + 1 == l3) {
				tempNum2[i] = tempNum2[i] + ",";
			}
			System.out.print(tempNum2[i]);
		}
		System.out.print(tempNum2[tempNum2.length - 1]);
	}
}