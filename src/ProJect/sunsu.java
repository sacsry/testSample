package ProJect;

import java.sql.*;

public class sunsu {
	String type;
	int atk ;
	int def;
	int control;
	int tectics;
	int sense;
	int supply;
	int wincount;
	int losecount;
	int recon;
	int keep;
	int sum;
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	int vsTwincount;
	int vsZwincount;
	int vsPwincount;
	int vsTlosecount;
	int vsZlosecount;
	int vsPlosecount;
	String grade;
	Connection conn = null;
	Statement stmt = null;
	String url = "jdbc:mysql://localhost:3306/sampledb";
	String user = "root";
	String password = "test123";
	
	public sunsu() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // MySQL 드라이버 로드
			conn = DriverManager.getConnection(url, user, password); // JDBC 연결
			stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
//			ResultSet srs = stmt.executeQuery("SELECT * FROM sunsu_data"); // 테이블의 모든 데이터 검색

			

		} catch (ClassNotFoundException e1) {
			System.out.println("JDBC 드라이버 로드 오류");
		} catch (SQLException e2) {
			System.out.println("SQL 실행오류3");
		}
	}
	
	public void data(String name){
		
		try {
			
			ResultSet srs = stmt.executeQuery("SELECT * FROM sunsu_data where 이름 = '" + name + "'");// 테이블의 특정 선수 데이터 검색
			while(srs.next()) {
				type = srs.getString("종족");
				atk = Integer.parseInt(srs.getString("공격력"));
				def = Integer.parseInt(srs.getString("수비력"));
				control = Integer.parseInt(srs.getString("컨트롤"));
				tectics = Integer.parseInt(srs.getString("전략"));
				sense = Integer.parseInt(srs.getString("센스"));
				supply = Integer.parseInt(srs.getString("물량"));
				keep = Integer.parseInt(srs.getString("견제"));
				recon = Integer.parseInt(srs.getString("정찰"));
				grade = srs.getString("등급");
				sum = Integer.parseInt(srs.getString("sum"));
				wincount = Integer.parseInt(srs.getString("승"));
				losecount = Integer.parseInt(srs.getString("패"));
				vsTwincount=Integer.parseInt(srs.getString("vsT승"));;
				vsZwincount=Integer.parseInt(srs.getString("vsZ승"));;
				vsPwincount=Integer.parseInt(srs.getString("vsP승"));;
				vsTlosecount=Integer.parseInt(srs.getString("vsT패"));;
				vsZlosecount=Integer.parseInt(srs.getString("vsZ패"));;
				vsPlosecount=Integer.parseInt(srs.getString("vsP패"));;
				
				
			}
		} catch (Exception e1) {
			System.out.println("JDBC 드라이버 로드 오류");
		} 
	}
	
	public int getVsTwincount() {
		return vsTwincount;
	}

	public void setVsTwincount(int vsTwincount) {
		this.vsTwincount = vsTwincount;
	}

	public int getVsZwincount() {
		return vsZwincount;
	}

	public void setVsZwincount(int vsZwincount) {
		this.vsZwincount = vsZwincount;
	}

	public int getVsPwincount() {
		return vsPwincount;
	}

	public void setVsPwincount(int vsPwincount) {
		this.vsPwincount = vsPwincount;
	}

	public int getVsTlosecount() {
		return vsTlosecount;
	}

	public void setVsTlosecount(int vsTlosecount) {
		this.vsTlosecount = vsTlosecount;
	}

	public int getVsZlosecount() {
		return vsZlosecount;
	}

	public void setVsZlosecount(int vsZlosecount) {
		this.vsZlosecount = vsZlosecount;
	}

	public int getVsPlosecount() {
		return vsPlosecount;
	}

	public void setVsPlosecount(int vsPlosecount) {
		this.vsPlosecount = vsPlosecount;
	}

	public int getRecon() {
		return recon;
	}

	public void setRecon(int recon) {
		this.recon = recon;
	}

	public int getKeep() {
		return keep;
	}

	public void setKeep(int keep) {
		this.keep = keep;
	}

	public void record(String name,boolean record, String type) {
		try {
			
			ResultSet srs = stmt.executeQuery("SELECT * FROM sunsu_data where 이름 = '" + name + "'");// 테이블의 특정 선수 데이터 검색
			int win = 0;
			int lose = 0;
			int vsTlose=0;
			int vsZlose=0;
			int vsPlose=0;
			int vsTwin=0;
			int vsZwin=0;
			int vsPwin=0;
			while(srs.next()) {
			win = Integer.parseInt(srs.getString("승"));
			lose = Integer.parseInt(srs.getString("패"));
			vsTwin = Integer.parseInt(srs.getString("vsT승"));
			vsTlose = Integer.parseInt(srs.getString("vsT패"));
			vsZwin = Integer.parseInt(srs.getString("vsZ승"));
			vsZlose = Integer.parseInt(srs.getString("vsZ패"));
			vsPwin = Integer.parseInt(srs.getString("vsP승"));
			vsPlose = Integer.parseInt(srs.getString("vsP패"));
			}
			
			if(record == true) {
				win++;
				
				
				if(type.equals("Terran")) {
					vsTwin++;
					stmt.executeUpdate("update sunsu_data set 승 = "+win+" where 이름 = '"+name+"'");
					stmt.executeUpdate("update sunsu_data set vsT승 = "+vsTwin+" where 이름 = '"+name+"'");
				}
				if(type.equals("Zerg")) {
					vsZwin++;
					stmt.executeUpdate("update sunsu_data set 승 = "+win+" where 이름 = '"+name+"'");
					stmt.executeUpdate("update sunsu_data set vsZ승 = "+vsZwin+" where 이름 = '"+name+"'");
				}
				if(type.equals("Protoss")) {
					vsPwin++;
					stmt.executeUpdate("update sunsu_data set 승 = "+win+" where 이름 = '"+name+"'");
					stmt.executeUpdate("update sunsu_data set vsP승 = "+vsPwin+" where 이름 = '"+name+"'");
				}
				
			}
			else if(record == false){
				lose++;
				
				if(type.equals("Terran")) {
					vsTlose++;
					stmt.executeUpdate("update sunsu_data set 패 = "+lose+" where 이름 = '"+name+"'");
					stmt.executeUpdate("update sunsu_data set vsT패 = "+vsTlose+" where 이름 = '"+name+"'");
				}
				if(type.equals("Zerg")) {
					vsZlose++;
					stmt.executeUpdate("update sunsu_data set 패 = "+lose+" where 이름 = '"+name+"'");
					stmt.executeUpdate("update sunsu_data set vsZ패 = "+vsZlose+" where 이름 = '"+name+"'");
					
				}
				if(type.equals("Protoss")) {
					vsPlose++;
					stmt.executeUpdate("update sunsu_data set 패 = "+lose+" where 이름 = '"+name+"'");
					stmt.executeUpdate("update sunsu_data set vsP패 = "+vsPlose+" where 이름 = '"+name+"'");
					
				}
			}
		} catch (Exception e1) {
			System.out.println("JDBC 드라이버 로드 오류");
		} 
		
	}
	
	public void recordreset() {
		try {
			
			ResultSet srs = stmt.executeQuery("SELECT * FROM sunsu_data");// 테이블의 특정 선수 데이터 검색
			int win = 0;
			int lose = 0;
			while(srs.next()) {
			win = Integer.parseInt(srs.getString("승"));
			lose = Integer.parseInt(srs.getString("패"));
			stmt.executeUpdate("update sunsu_data set 승 = "+0+"");
			stmt.executeUpdate("update sunsu_data set 패 = "+0+"");
			stmt.executeUpdate("update sunsu_data set vsT승 = "+0+"");
			stmt.executeUpdate("update sunsu_data set vsT패 = "+0+"");
			stmt.executeUpdate("update sunsu_data set vsP승 = "+0+"");
			stmt.executeUpdate("update sunsu_data set vsP패 = "+0+"");
			stmt.executeUpdate("update sunsu_data set vsZ승 = "+0+"");
			stmt.executeUpdate("update sunsu_data set vsZ패 = "+0+"");
			}
		} catch (Exception e1) {
			System.out.println("JDBC 드라이버 로드 오류");
		} 
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
	
	public int getWincount() {
		return wincount;
	}

	public void setWincount(int wincount) {
		this.wincount = wincount;
	}

	public int getLosecount() {
		return losecount;
	}

	public void setLosecount(int losecount) {
		this.losecount = losecount;
	}

}
