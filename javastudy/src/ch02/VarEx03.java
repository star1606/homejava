package ch02;

public class VarEx03 {

	public static void main(String[] args) {
		char s1 = '��'; // 2����Ʈ
		System.out.println(s1);

		s1 = '��';
		System.out.println(s1);

		char c1 = '��';
		char c2 = '��';
		char c3 = '��';
		// �ϳ��� �����ϸ� ���ӵ��� ���� ������ ���� �� ���ִ�.(������ ������ �˻��� �����ɸ�)

		System.out.print(c1);
		System.out.print(c2);
		System.out.print(c3);
		// �ڷ��� �ڿ� []�� �־� �迭�� ����.

		System.out.println();

		char[] str = { '��', '��', '��' };
		// �迭�� �����ϸ� ���ӵ� ������ ����Ǿ� ������ ������ �о�� �� �ִ�.

		System.out.print(str[0]);
		System.out.print(str[1]);
		System.out.print(str[2]);
		// str[3] = '��'; ��Ÿ�� ����(����� �����߻�)
		System.out.println();

		str[0] = '��';
		System.out.println(str[0]);

	}
}