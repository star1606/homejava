package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

class Info {
	String name;
	String loc;
	
	public Info(String name, String loc) {
		this.name = name;
		this.loc = loc;
	}
	
	
}

public class TestDB {

	// 전역 공간에 쿼리에 필요한 레퍼런스를 준비
	Connection con; // 디비 연결
	String query; // 쿼리문 내용
	Statement stmt; // 워크시트 (쿼리문 입력 공간)
	ResultSet rs; // 결과
	ArrayList<Info> storeInfos = new ArrayList<>(); // 결과를 어레이리스트에 저장

	void openCon() throws Exception { // 연결 하기

		// 오라클 주소, 아이디 비밀번호
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userid = "test1";
		String pwd = "test1";

		// 자바 라이브러리 파일 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로드 성공");

		// 네트워크 입출력 객체 생성
		System.out.println("데이터베이스 연결 준비...");
		con = DriverManager.getConnection(url, userid, pwd);
		System.out.println("데이터베이스 연결 성공");
		
		// 워크시트 생성
		stmt = con.createStatement();
		System.out.println("워크시트 생성");

	}

	void closeCon() throws Exception {
		
		// 연결 끊기
		con.close();
		System.out.println("데이터베이스 연결 해제");

	}

	void insertData(String name, String loc) throws Exception { // 데이터 넣기
		
		query = "INSERT INTO drugstore(name, loc) VALUES('" + name + "', '" + loc + "')";
		
		stmt.executeUpdate(query); // 워크시트에 쿼리문 입력하기
		
		System.out.println(query);

	}

	// 매개변수 - SELECT는 여러가지를 받을 수 있기때문에 배열로 받고, 테이블은 하나를 선택
	void selectData() throws Exception { 

		query = "SELECT name, loc FROM drugstore";
		
		System.out.println(query);
		
		rs = stmt.executeQuery(query); // 워크시트에 쿼리문 입력하고 데이터 받기
		while (rs.next()) {
			
			Info temp = new Info(rs.getString(1), rs.getString(2)); // 약국이름과  위치를 가진 객체 생성
			storeInfos.add(temp); //어레이리스트에 객체 추가
		}
		
		for (int i = 0; i < storeInfos.size(); i++) {
			System.out.println(storeInfos.get(i).name + " : " + storeInfos.get(i).loc);
		}
		
	}
	
	void deleteData(String name) throws Exception {
		query = "DELETE drugstore WHERE name like '" + name + "'";
		
		stmt.executeUpdate(query);
		
		System.out.println(query);
	}

	public static void main(String[] args) {
		TestDB td = new TestDB();
		
		try {
			td.openCon();
			td.deleteData("자바약국");
			td.closeCon();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
