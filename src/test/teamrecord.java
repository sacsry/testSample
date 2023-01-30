package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class teamrecord {

	String teamname;
	
	public ArrayList<Integer> getAdvantagearray() {
		return advantagearray;
	}


	public void setAdvantagearray(ArrayList<Integer> advantagearray) {
		this.advantagearray = advantagearray;
	}


	int win;
	int lose;
	int setwin;
	int setlose;
	int advantage;
	
	ArrayList<String> teamarray = new ArrayList<String>();
	ArrayList<Integer> winarray = new ArrayList<Integer>();
	ArrayList<Integer> losearray = new ArrayList<Integer>();
	ArrayList<Integer> advantagearray = new ArrayList<Integer>();
	
	
	Connection conn = null;
	Statement stmt = null;
	String url = "jdbc:mysql://localhost:3306/sampledb";
	String user = "root";
	String password = "test123";
	public teamrecord() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // MySQL 드라이버 로드
			conn = DriverManager.getConnection(url, user, password); // JDBC 연결
			stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
//			ResultSet srs = stmt.executeQuery("SELECT * FROM teamrecord"); // 테이블의 모든 데이터 검색

			

		} catch (ClassNotFoundException e1) {
			System.out.println("JDBC 드라이버 로드 오류");
		} catch (SQLException e2) {
			System.out.println("SQL 실행오류3");
		}
	}
	
	
	public void data(String name){
		
		try {
			
			ResultSet srs = stmt.executeQuery("SELECT * FROM teamrecord where 팀이름 = '" + name + "'");// 테이블의 특정 선수 데이터 검색
			while(srs.next()) {
				teamname = srs.getString("팀이름");
				win = Integer.parseInt(srs.getString("팀승수"));
				lose = Integer.parseInt(srs.getString("팀패배"));
				setwin = Integer.parseInt(srs.getString("세트승"));
				setlose = Integer.parseInt(srs.getString("세트패"));
				advantage = Integer.parseInt(srs.getString("득실차"));
				
			}
		} catch (Exception e1) {
			System.out.println("JDBC 드라이버 로드 오류");
		} 
	}
	
//	public void insertRecorddata(String teamname, int win, int lose, int setwin,int setlose,int advantage){
		
	
	public void record(String teamname, boolean record, int winset, int loseset) {
		try {
			
			ResultSet srs = stmt.executeQuery("SELECT * FROM teamrecord where 팀이름 = '" + teamname + "'");// 테이블의 특정 선수 데이터 검색
			System.out.println("팀이름 :"+teamname);
			int win1 = 0;
			int lose1 = 0;
			int setwin1 = 0;
			int setlose1 = 0;
			int advantage1 = 0;
			
			while(srs.next()) {
				teamname = srs.getString("팀이름");
				win1 = Integer.parseInt(srs.getString("팀승수"));
				lose1 = Integer.parseInt(srs.getString("팀패배"));
				setwin1 = Integer.parseInt(srs.getString("세트승"));
				setlose1 = Integer.parseInt(srs.getString("세트패"));
				advantage1 = Integer.parseInt(srs.getString("득실차"));
				
			}
			if(record == true) {
				win1++;
				setwin1 +=winset;
				setlose1 +=loseset;
				advantage1 = setwin1-setlose1;
				stmt.executeUpdate("update teamrecord set 팀승수 = "+ win1 +" where 팀이름 = '"+teamname+"'");
				stmt.executeUpdate("update teamrecord set 팀패배 = "+ lose1 +" where 팀이름 = '"+teamname+"'");
				stmt.executeUpdate("update teamrecord set 세트승 = "+ setwin1 +" where 팀이름 = '"+teamname+"'");
				stmt.executeUpdate("update teamrecord set 세트패 = "+ setlose1 +" where 팀이름 = '"+teamname+"'");
				stmt.executeUpdate("update teamrecord set 득실차 = "+ advantage1 +" where 팀이름 = '"+teamname+"'");
				System.out.println(teamname+" "+ win1);
			}
			else if(record == false){
				lose1++;
				setwin1 +=winset;
				setlose1 +=loseset;
				advantage1 = setwin1-setlose1;
				stmt.executeUpdate("update teamrecord set 팀승수 = "+ win1 +" where 팀이름 = '"+teamname+"'");
				stmt.executeUpdate("update teamrecord set 팀패배 = "+ lose1 +" where 팀이름 = '"+teamname+"'");
				stmt.executeUpdate("update teamrecord set 세트승 = "+ setwin1 +" where 팀이름 = '"+teamname+"'");
				stmt.executeUpdate("update teamrecord set 세트패 = "+ setlose1 +" where 팀이름 = '"+teamname+"'");
				stmt.executeUpdate("update teamrecord set 득실차 = "+ advantage1 +" where 팀이름 = '"+teamname+"'");
				System.out.println(false);
				System.out.println(teamname+" "+ lose1);
			}
			
			
			
		} catch (Exception e1) {
			System.out.println("JDBC 드라이버 로드 오류");
		} 
		
	}
	
	public void recordreset() {
		try {
			
			ResultSet srs = stmt.executeQuery("SELECT * FROM teamrecord");// 테이블의 특정 선수 데이터 검색
			
			while(srs.next()) {
			
			stmt.executeUpdate("update teamrecord set 팀승수 = "+0+"");
			stmt.executeUpdate("update teamrecord set 팀패배 = "+0+"");
			stmt.executeUpdate("update teamrecord set 세트승 = "+0+"");
			stmt.executeUpdate("update teamrecord set 세트패 = "+0+"");
			stmt.executeUpdate("update teamrecord set 득실차 = "+0+"");
			
			}
		} catch (Exception e1) {
			System.out.println("JDBC 드라이버 로드 오류");
		} 
	}
	
	public void array() {
		try {
			
			ResultSet srs = stmt.executeQuery("select * from teamrecord order by 팀승수 desc ,득실차 desc");// 테이블의 특정 선수 데이터 검색
			teamarray = new ArrayList<String>();
			winarray = new ArrayList<Integer>();
			losearray = new ArrayList<Integer>();
			advantagearray = new ArrayList<Integer>();
			while(srs.next()) {
			teamarray.add(srs.getString("팀이름"));
			winarray.add(Integer.parseInt(srs.getString("팀승수")));
			losearray.add(Integer.parseInt(srs.getString("팀패배")));
			advantagearray.add(Integer.parseInt(srs.getString("득실차")));
			
			}
			
		} catch (Exception e1) {
			System.out.println("JDBC 드라이버 로드 오류");
		} 
	}


	public ArrayList<String> getTeamarray() {
		return teamarray;
	}


	public void setTeamarray(ArrayList<String> teamarray) {
		this.teamarray = teamarray;
	}


	public ArrayList<Integer> getWinarray() {
		return winarray;
	}


	public void setWinarray(ArrayList<Integer> winarray) {
		this.winarray = winarray;
	}


	public ArrayList<Integer> getLosearray() {
		return losearray;
	}


	public void setLosearray(ArrayList<Integer> losearray) {
		this.losearray = losearray;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getTeamname() {
		return teamname;
	}


	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}


	public int getWin() {
		return win;
	}


	public void setWin(int win) {
		this.win = win;
	}


	public int getLose() {
		return lose;
	}


	public void setLose(int lose) {
		this.lose = lose;
	}


	public int getSetwin() {
		return setwin;
	}


	public void setSetwin(int setwin) {
		this.setwin = setwin;
	}


	public int getSetlose() {
		return setlose;
	}


	public void setSetlose(int setlose) {
		this.setlose = setlose;
	}


	public int getAdvantage() {
		return advantage;
	}


	public void setAdvantage(int advantage) {
		this.advantage = advantage;
	}
	
}
