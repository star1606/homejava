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

	// ���� ������ ������ �ʿ��� ���۷����� �غ�
	Connection con; // ��� ����
	String query; // ������ ����
	Statement stmt; // ��ũ��Ʈ
	ResultSet rs; // ���

	void openCon() throws Exception { // ���� �ϱ�

		// ����Ŭ �ּ�, ���̵� ��й�ȣ
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userid = "test1";
		String pwd = "test1";

		// ���� �����(�ڹ� ���̺귯�� ���� �˻�)
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("����̹� �ε� ����");

		// �����ͺ��̽��� �����ϴ� ����
		System.out.println("�����ͺ��̽� ���� �غ�...");

		// ��Ʈ��ũ ����� + ��ü ����
		con = DriverManager.getConnection(url, userid, pwd);
		System.out.println("�����ͺ��̽� ���� ����");

	}

	void closeCon() throws Exception { // ���� ����

		con.close();
		System.out.println("�����ͺ��̽� ���� ����");

	}

	void insertData(String name, String loc) throws Exception { // ������ �ֱ�
		
		query = "INSERT INTO drugstore(name, loc) VALUES('" + name + "', '" + loc + "');";
		stmt = con.createStatement(); // ��ũ��Ʈ ����
		stmt.executeUpdate(query); // ��ũ��Ʈ�� ������ �Է��ϱ�
		
		System.out.println(query);

	}

	// �Ű����� - SELECT�� ���������� ���� �� �ֱ⶧���� �迭�� �ް�, ���̺��� �ϳ��� ����
	void selectData(String[] column, String table) throws Exception { 
		
		StringBuilder sb = new StringBuilder("SELECT "); //�÷� �迭�� �Է��ϱ� ���� ��Ʈ�� ����
		
		// SELECT�� ���� �÷��� ��ŭ sb�� �߰�
		for (int i = 0; i < column.length; i++) {
			
			sb.append(column[0]);
			
			// �÷����̿� ��ǥ�� �ְ� ���������� ���鸸 �ֱ�
			if(i < column.length - 1) {
				sb.append(", ");
			} else {
				sb.append(" ");
			}
		}
		
		// ��Ʈ�������� ���̺� �߰�
		sb.append("FROM " + table + ";");
		query = sb.toString(); // ��Ʈ�� ������ ������ �������� ���
		
		System.out.println(query);
		
		stmt = con.createStatement(); // ��ũ��Ʈ ����
		rs = stmt.executeQuery(query); // ��ũ��Ʈ�� ������ �Է��ϰ� ������ �ޱ�
		
	}

	public static void main(String[] args) {
		TestDB1 td = new TestDB1();
		
		try {
			td.insertData("�ڹپ౹", "�λ걤���� XXX");
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}