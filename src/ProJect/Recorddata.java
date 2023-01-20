package ProJect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Recorddata {

//	String winner;
//	String loser;
//	String map;
	ArrayList<String> anotherplayer; 
	ArrayList<String> result;
	ArrayList<String> Map ;
	String sunsu;
	
	
	public Recorddata() {
		
	}
	public Recorddata(String sunsu) {
		this.sunsu = sunsu;
	}
	
	public void insertRecorddata(String winner,String loser,String map){
		Connection conn;
		Statement stmt = null;
		try {
				Class.forName("com.mysql.jdbc.Driver"); // MySQL 드라이버 로드
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "test123"); // JDBC 연결
				stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
//				ResultSet srs = stmt.executeQuery("SELECT * FROM sunsu_data"); // 테이블의 모든 데이터 검색

				
				stmt.executeUpdate("insert into recorddata12 (검색선수, 상대선수, 맵,결과) values (" + "'" + winner + "','" + loser + "','" + map + "','승');");
				stmt.executeUpdate("insert into recorddata12 (검색선수, 상대선수, 맵,결과) values (" + "'" + loser + "','" + winner + "','" + map + "','패');");// 테이블의 특정 선수 데이터 검색
				
//				while(srs.next()) {
//					
//				}
			} catch (ClassNotFoundException e1) {
				System.out.println("JDBC 드라이버 로드 오류");
			} catch (SQLException e2) {
				System.out.println("SQL 실행오류3");
			}
	}
	
	public void deleteRecorddata(){
		Connection conn;
		Statement stmt = null;
		try {
				Class.forName("com.mysql.jdbc.Driver"); // MySQL 드라이버 로드
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "test123"); // JDBC 연결
				stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
//				ResultSet srs = stmt.executeQuery("SELECT * FROM sunsu_data"); // 테이블의 모든 데이터 검색

				
				stmt.executeUpdate("delete from recorddata12;");// 테이블의 특정 선수 데이터 검색
				
//				while(srs.next()) {
//					
//				}
			} catch (ClassNotFoundException e1) {
				System.out.println("JDBC 드라이버 로드 오류");
			} catch (SQLException e2) {
				System.out.println("SQL 실행오류3");
			}
	}
	
	public void searchRecorddata(){
		Connection conn;
		Statement stmt = null;
		
		
		try {
				Class.forName("com.mysql.jdbc.Driver"); // MySQL 드라이버 로드
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "test123"); // JDBC 연결
				stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
				new Recorddata(sunsu);
				ResultSet srs = stmt.executeQuery("SELECT * FROM recorddata12 where 검색선수 = '"+ sunsu + "'"); // 테이블의 모든 데이터 검색
//				while(srs.next()){
//					anotherplayer.add(srs.getString("상대선수"));
//					Map.add(srs.getString("맵"));
//					result.add(srs.getString("결과"));
//				}
				while(srs.next()) {
				System.out.println(srs.getString("상대선수"));
				}
			} catch (ClassNotFoundException e1) {
				System.out.println("JDBC 드라이버 로드 오류");
			} catch (SQLException e2) {
				System.out.println("SQL 실행오류3");
			}
	}
	public ArrayList<String> getAnotherplayer() {
		return anotherplayer;
	}
	public void setAnotherplayer(ArrayList<String> anotherplayer) {
		this.anotherplayer = anotherplayer;
	}
	public ArrayList<String> getResult() {
		return result;
	}
	public void setResult(ArrayList<String> result) {
		this.result = result;
	}
	public ArrayList<String> getMap() {
		return Map;
	}
	public void setMap(ArrayList<String> map) {
		Map = map;
	}

	
	
}
