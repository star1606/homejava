package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class info {
	String name;
	String loc;
}

public class TestDB1 {

	// 전역 공간에 쿼리에 필요한 레퍼런스를 준비
	Connection con; // 디비 연결
	String query; // 쿼리문 내용
	Statement stmt; // 워크시트
	ResultSet rs; // 결과

	void openCon() throws Exception { // 연결 하기

		// 오라클 주소, 아이디 비밀번호
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userid = "test1";
		String pwd = "test1";

		// 파일 입출력(자바 라이브러리 파일 검색)
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로드 성공");

		// 데이터베이스를 연결하는 과정
		System.out.println("데이터베이스 연결 준비...");

		// 네트워크 입출력 + 객체 생성
		con = DriverManager.getConnection(url, userid, pwd);
		System.out.println("데이터베이스 연결 성공");

	}

	void closeCon() throws Exception { // 연결 끊기

		con.close();
		System.out.println("데이터베이스 연결 해제");

	}

	void insertData(String name, String loc) throws Exception { // 데이터 넣기
		
		query = "INSERT INTO drugstore(name, loc) VALUES('" + name + "', '" + loc + "');";
		stmt = con.createStatement(); // 워크시트 생성
		stmt.executeUpdate(query); // 워크시트에 쿼리문 입력하기
		
		System.out.println(query);

	}

	// 매개변수 - SELECT는 여러가지를 받을 수 있기때문에 배열로 받고, 테이블은 하나를 선택
	void selectData(String[] column, String table) throws Exception { 
		
		StringBuilder sb = new StringBuilder("SELECT "); //컬럼 배열을 입력하기 위한 스트링 빌더
		
		// SELECT를 위한 컬럼수 만큼 sb에 추가
		for (int i = 0; i < column.length; i++) {
			
			sb.append(column[0]);
			
			// 컬럼사이에 쉼표를 넣고 마지막에는 공백만 넣기
			if(i < column.length - 1) {
				sb.append(", ");
			} else {
				sb.append(" ");
			}
		}
		
		// 스트링빌더에 테이블 추가
		sb.append("FROM " + table + ";");
		query = sb.toString(); // 스트링 빌더의 내용을 쿼리문에 담기
		
		System.out.println(query);
		
		stmt = con.createStatement(); // 워크시트 생성
		rs = stmt.executeQuery(query); // 워크시트에 쿼리문 입력하고 데이터 받기
		
	}

	public static void main(String[] args) {
		TestDB1 td = new TestDB1();
		
		try {
			td.insertData("자바약국", "부산광역시 XXX");
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
