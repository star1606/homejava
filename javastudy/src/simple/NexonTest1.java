package simple;

import java.util.ArrayList;

public class NexonTest1 {
	public static void main(String[] args) {
		
		// 어레이 리스트 생성
		ArrayList<Integer> arr1 = new ArrayList<>();
		
		// 어레이 리스트에 1~4999 넣기
		for (int i = 1; i < 5000; i++) {
			arr1.add(i);
		}
		
		
		// 어레이 리스트에서 셀프넘버만 남기고 지우기
		for (int j = 1; j < 5000; j++) {
			int temp = j;
			int temp1 = 0;
			Integer sum = j;
			for (int i = 0; i < Integer.toString(j).length() ; i++) {
				temp1 = (int)(temp/(Math.pow(10, Integer.toString(temp).length() - 1)));
				sum = sum + temp1;
				temp =(int)(temp%(Math.pow(10, Integer.toString(temp).length() - 1)));
			}
			arr1.remove(sum);
		}
		
		// 어레이 리스트에 남은 숫자 모두 더하기
		int result = 0;
		for (Integer integer : arr1) {
			result = result + integer;
		}
		
		System.out.println(result);
		
	}
}

