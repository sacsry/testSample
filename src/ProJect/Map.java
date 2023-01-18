package ProJect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Map {

	String Mapname;
	int MyTerranwinrate;
	int MyZergwinrate;
	int MyProtosswinrate;
	int YourTerranwinrate;
	int YourZergwinrate;
	int YourProtosswinrate;
	
	
	public void data() {
		Connection conn;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // MySQL 드라이버 로드
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "test123"); // JDBC
																											// 연결
			
			stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
			ResultSet srs = stmt.executeQuery("SELECT * FROM map"); // 테이블의 모든 데이터 검색
			new Map(Mapname);
			srs = stmt.executeQuery("SELECT * FROM map where 맵이름 = '" + Mapname + "'");// 테이블의 모든 데이터 검색
			while(srs.next()) {
				Mapname = srs.getString("맵이름");
				MyTerranwinrate = Integer.parseInt(srs.getString("Terran"));
				MyZergwinrate = Integer.parseInt(srs.getString("Zerg"));
				MyProtosswinrate = Integer.parseInt(srs.getString("Protoss"));
				YourProtosswinrate = Integer.parseInt(srs.getString("P1"));
				YourTerranwinrate = Integer.parseInt(srs.getString("T1"));
				YourZergwinrate = Integer.parseInt(srs.getString("Z1"));
				}
			
		} catch (ClassNotFoundException e1) {
			System.out.println("JDBC 드라이버 로드 오류");
		} catch (SQLException e2) {
			System.out.println("SQL 실행오류");
		}
	}
	public String getMapname() {
		return Mapname;
	}
	public void setMapname(String mapname) {
		Mapname = mapname;
	}
	public int getMyTerranwinrate() {
		return MyTerranwinrate;
	}
	public void setMyTerranwinrate(int myTerranwinrate) {
		MyTerranwinrate = myTerranwinrate;
	}
	public int getMyZergwinrate() {
		return MyZergwinrate;
	}
	public void setMyZergwinrate(int myZergwinrate) {
		MyZergwinrate = myZergwinrate;
	}
	public int getMyProtosswinrate() {
		return MyProtosswinrate;
	}
	public void setMyProtosswinrate(int myProtosswinrate) {
		MyProtosswinrate = myProtosswinrate;
	}
	public int getYourTerranwinrate() {
		return YourTerranwinrate;
	}
	public void setYourTerranwinrate(int yourTerranwinrate) {
		YourTerranwinrate = yourTerranwinrate;
	}
	public int getYourZergwinrate() {
		return YourZergwinrate;
	}
	public void setYourZergwinrate(int yourZergwinrate) {
		YourZergwinrate = yourZergwinrate;
	}
	public int getYourProtosswinrate() {
		return YourProtosswinrate;
	}
	public void setYourProtosswinrate(int yourProtosswinrate) {
		YourProtosswinrate = yourProtosswinrate;
	}
	public Map() {
		
	}
	public Map(String Mapname) {
		this.Mapname = Mapname;
	}
}
