package ProJect;

import java.sql.*;

public class sunsu {
	
	
	static String name = null;
	String type;
	int atk ;
	int def;
	int control;
	int tectics;
	int sense;
	int supply;
	String grade;
	
	
//	public static void main(String args[]) {
//		Connection conn;
//		Statement stmt = null;
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver"); // MySQL 드라이버 로드
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "test123"); // JDBC 연결
//			System.out.println("DB 연결 완료");
//			stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
//			ResultSet srs = stmt.executeQuery("SELECT * FROM sunsu_data"); // 테이블의 모든 데이터 검색
//			new sunsu("고강민");
//			srs = stmt.executeQuery("SELECT * FROM sunsu_data where 선수 = '"+name+"'");// 테이블의 모든 데이터 검색
//			new sunsu(name,srs);
////			printData(srs);
//		} catch (ClassNotFoundException e) {
//			System.out.println("JDBC 드라이버 로드 오류");
//		} catch (SQLException e) {
//			System.out.println("SQL 실행오류");
//		}
//	}
	public sunsu() {
		
	}
	public sunsu (String name){
		this.name = name; 
	}
	
	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		sunsu.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getControl() {
		return control;
	}

	public void setControl(int control) {
		this.control = control;
	}

	public int getTectics() {
		return tectics;
	}

	public void setTectics(int tectics) {
		this.tectics = tectics;
	}

	public int getSense() {
		return sense;
	}

	public void setSense(int sense) {
		this.sense = sense;
	}

	public int getSupply() {
		return supply;
	}

	public void setSupply(int supply) {
		this.supply = supply;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public sunsu(String name, ResultSet srs) throws SQLException{
		this.name = name;
		while(srs.next()) {
			type = srs.getString("종족");
			atk = Integer.parseInt(srs.getString("공격력"));
			def = Integer.parseInt(srs.getString("수비력"));
			control = Integer.parseInt(srs.getString("컨트롤"));
			tectics = Integer.parseInt(srs.getString("전략"));
			sense = Integer.parseInt(srs.getString("센스"));
			supply = Integer.parseInt(srs.getString("물량"));
			grade = srs.getString("등급");
		}
		
		
	}
	
}
