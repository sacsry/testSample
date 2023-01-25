package ProJect;

import java.sql.*;
import java.util.ArrayList;
public class Recorddata {
	ArrayList<String> anotherplayer; 
	ArrayList<String> result;
	ArrayList<String> Map ;
	String sunsu;
	private int win;
	private int lose;
	int vsTwin;
	int vsZwin;
	int vsPwin;
	int vsTlose;
	int vsZlose;
	int vsPlose;
	Connection conn = null;
	Statement stmt = null;
	String url = "jdbc:mysql://localhost:3306/sampledb";
	String user = "root";
	String password = "test123";
	public Recorddata() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // MySQL 드라이버 로드
			conn = DriverManager.getConnection(url, user, password); // JDBC 연결
			stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
//			ResultSet srs = stmt.executeQuery("SELECT * FROM sunsu_data"); // 테이블의 모든 데이터 검색

			

		} catch (ClassNotFoundException e1) {
			System.out.println("JDBC 드라이버 로드 오류1");
		} catch (SQLException e2) {
			System.out.println("SQL 실행오류3");
		}
	}
	
	public void insertRecorddata(String winner,String loser,String map){
		try {


			sunsu winner1 = new sunsu();
			winner1.data(winner);
			sunsu loser1 = new sunsu();
			loser1.data(loser);
			stmt.executeUpdate("insert into recorddata12 (검색선수,검색선수종족, 상대선수,상대선수종족, 맵,결과) values (" + "'" + winner + "','" + winner1.getType()+ "','" +  loser + "','"+
			loser1.getType()+ "','" + map + "','승');");
			stmt.executeUpdate("insert into recorddata12 (검색선수,검색선수종족, 상대선수,상대선수종족, 맵,결과) values (" + "'" + loser + "','"+loser1.getType()+ "','" + winner + "','" + winner1.getType()+ "','" + map + "','패');");// 테이블의 특정 선수 데이터 검색
			
//			while(srs.next()) {
//				
//			}
		} catch (Exception e1) {
			
		} 
	}
	
	public void deleteRecorddata(){
		
		try {
				
//				ResultSet srs = stmt.executeQuery("SELECT * FROM sunsu_data"); // 테이블의 모든 데이터 검색

				
				stmt.executeUpdate("delete from recorddata12;");// 테이블의 특정 선수 데이터 검색
				
//				while(srs.next()) {
//					
//				}
			} catch (Exception e1) {
				
			} 
	}
	
	public void searchRecorddata(String sunsu){
	
		anotherplayer = new ArrayList<String>();
		Map = new ArrayList<String>();
		result = new ArrayList<String>();
		
		try {
				
				
				ResultSet srs = stmt.executeQuery("SELECT * FROM recorddata12 where 검색선수 = '"+ sunsu + "'"); // 테이블의 모든 데이터 검색
				win = 0;
				lose = 0;
				vsTwin = 0;
				vsTlose = 0;
				vsPwin =0;
				
				vsPlose = 0;
				
				vsZwin = 0;
				vsZlose = 0;
				
				while(srs.next()){
					anotherplayer.add(srs.getString("상대선수"));
					Map.add(srs.getString("맵"));
					result.add(srs.getString("결과"));
					
					if(srs.getString("결과").equals("승")) {
						win++;
						lose = 0;
						
					}
					if(srs.getString("결과").equals("승") && srs.getString("상대선수종족").equals("Terran")) {
						vsTwin++;
						vsTlose =0;
					}
					if(srs.getString("결과").equals("승") && srs.getString("상대선수종족").equals("Protoss")) {
						vsPwin++;
						vsPlose =0;
					}
					if(srs.getString("결과").equals("승") && srs.getString("상대선수종족").equals("Zerg")) {
						vsZwin++;
						vsZlose =0;
					}
					else if(srs.getString("결과").equals("패")) {
						lose++;
						win =0;
						
					}
					if(srs.getString("결과").equals("패") && srs.getString("상대선수종족").equals("Terran")) {
						vsTlose++;
						vsTwin=0;
					}
					if(srs.getString("결과").equals("패") && srs.getString("상대선수종족").equals("Protoss")) {
						vsPlose++;
						vsPwin=0;
					}
					if(srs.getString("결과").equals("패") && srs.getString("상대선수종족").equals("Zerg")) {
						vsZlose++;
						vsZwin=0;
					}
					if(anotherplayer.size()>10) {
						anotherplayer.remove(0);
						Map.remove(0);
						result.remove(0);
					}
				
				}
				
			} catch (Exception e1) {
				
			}
	}
	
	public int getVsTwin() {
		return vsTwin;
	}

	public void setVsTwin(int vsTwin) {
		this.vsTwin = vsTwin;
	}

	public int getVsZwin() {
		return vsZwin;
	}

	public void setVsZwin(int vsZwin) {
		this.vsZwin = vsZwin;
	}

	public int getVsPwin() {
		return vsPwin;
	}

	public void setVsPwin(int vsPwin) {
		this.vsPwin = vsPwin;
	}

	public int getVsTlose() {
		return vsTlose;
	}

	public void setVsTlose(int vsTlose) {
		this.vsTlose = vsTlose;
	}

	public int getVsZlose() {
		return vsZlose;
	}

	public void setVsZlose(int vsZlose) {
		this.vsZlose = vsZlose;
	}

	public int getVsPlose() {
		return vsPlose;
	}

	public void setVsPlose(int vsPlose) {
		this.vsPlose = vsPlose;
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


