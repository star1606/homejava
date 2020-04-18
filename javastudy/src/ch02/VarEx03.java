package ch02;

public class VarEx03 {

	public static void main(String[] args) {
		char s1 = '가'; // 2바이트
		System.out.println(s1);

		s1 = '나';
		System.out.println(s1);

		char c1 = '가';
		char c2 = '나';
		char c3 = '다';
		// 하나씩 저장하면 연속되지 않은 공간에 저장 될 수있다.(램에서 데이터 검색이 오래걸림)

		System.out.print(c1);
		System.out.print(c2);
		System.out.print(c3);
		// 자료형 뒤에 []를 넣어 배열을 만듬.

		System.out.println();

		char[] str = { '가', '나', '다' };
		// 배열로 저장하면 연속된 공간에 저장되어 빠르게 램에서 읽어올 수 있다.

		System.out.print(str[0]);
		System.out.print(str[1]);
		System.out.print(str[2]);
		// str[3] = '라'; 런타임 오류(실행시 오류발생)
		System.out.println();

		str[0] = '라';
		System.out.println(str[0]);

	}
}
