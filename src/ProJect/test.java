package ProJect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn;
		Statement stmt = null;
		Scanner s = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver"); // MySQL 드라이버 로드
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "test123"); // JDBC 연결
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
			ResultSet srs = stmt.executeQuery("SELECT * FROM sunsu_data"); // 테이블의 모든 데이터 검색
			System.out.println("선수 이름을 입력하세요:");
			String a = s.next();
			new sunsu(a);
			srs = stmt.executeQuery("SELECT * FROM sunsu_data where 선수 = '"+a+"'");// 테이블의 모든 데이터 검색
			sunsu b = new sunsu(a,srs);
			System.out.println(b.getAtk());
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 오류");
		} catch (SQLException e) {
			System.out.println("SQL 실행오류");
		}
		
	}


	
}
