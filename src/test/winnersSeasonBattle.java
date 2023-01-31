package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;

public class winnersSeasonBattle extends JFrame{
	int sum1;
	int sum2;
	int sum3;
	int mapwinrate;
	int winrate;
	String sunsu1;
	String sunsu2;
	String map;

	winnersSeasonBattle(JFrame f, String Myteam) {

		ProjectMain s = (ProjectMain) f;

		for (int j = 1; j < 6; j++) {

			try {
				String str;
				BufferedReader br = new BufferedReader(
						new FileReader("src/" + s.array[s.week][j][0] + ".txt")); // 불러올
																										// 파일이름
				s.v.clear();
				while ((str = br.readLine()) != null) {

					s.v.add(str + "\n");

				}

				br.close();

			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				String str;
				BufferedReader br = new BufferedReader(
						new FileReader("src/" + s.array[s.week][j][1] + ".txt")); // 불러올
																									// 파일이름
				s.v1.clear();
				while ((str = br.readLine()) != null) {

					s.v1.add(str + "\n");

				}

				br.close();

			} catch (IOException e2) {
				e2.printStackTrace();
			}
//			s.randomentry();
//			s.randomentry1();

			int average = 0;

			while (average < 21300) {
				average = 0;
				s.randomentry1();
				for (int i = 0; i < 4; i++) {

					sunsu1 = s.v.get(s.num3[i]).trim();

					s.sunsudb.data(sunsu1);
					average += s.sunsudb.getSum();

				}

			}
			average = 0;
			while (average < 21300) {
				average = 0;
				s.randomentry();
				for (int i = 0; i < 4; i++) {

					sunsu2 = s.v1.get(s.num2[i]).trim();

					s.sunsudb.data(sunsu2);
					average += s.sunsudb.getSum();

				}

			}
			MapChoice choice = new MapChoice();
			s.NewMap = choice.getWinnersMap();
			s.team1wincount = 0;
			s.team2wincount = 0;
			s.Computerset = 0;

			for (int i = 0; i < 7; i++) {

				sunsu1 = s.v.get(s.team2wincount).trim();
				sunsu2 = s.v1.get(s.team1wincount).trim();

				map = s.NewMap.get(i);

				System.out.println(sunsu1 + map + sunsu2);

				s.sunsudb.data(sunsu1);
				s.atk1 = s.sunsudb.getAtk();
				s.def1 = s.sunsudb.getDef();
				s.tectics1 = s.sunsudb.getTectics();
				s.sense1 = s.sunsudb.getSense();
				s.supply1 = s.sunsudb.getSupply();
				s.control1 = s.sunsudb.getControl();
				s.type1 = s.sunsudb.getType();
				s.recon1 = s.sunsudb.getRecon();
				s.keep1 = s.sunsudb.getKeep();
				s.grade1 = s.sunsudb.getGrade();
				s.sum1 = s.atk1 + s.def1 + s.control1 + s.tectics1 + s.sense1 + s.supply1 + s.recon1 + s.keep1;
				sum1 = s.sum1;

				s.sunsudb.data(sunsu2);
				s.atk2 = s.sunsudb.getAtk();
				s.def2 = s.sunsudb.getDef();
				s.tectics2 = s.sunsudb.getTectics();
				s.sense2 = s.sunsudb.getSense();
				s.supply2 = s.sunsudb.getSupply();
				s.control2 = s.sunsudb.getControl();
				s.type2 = s.sunsudb.getType();
				s.recon2 = s.sunsudb.getRecon();
				s.keep2 = s.sunsudb.getKeep();
				s.grade2 = s.sunsudb.getGrade();

				s.sum2 = s.atk2 + s.def2 + s.control2 + s.tectics2 + s.sense2 + s.supply2 + s.keep2 + s.recon2;
				sum2 = s.sum2;

				s.sum3 = s.sum1 + s.sum2;
				sum3 = s.sum3;

				Map currentMap = new Map();
				currentMap.data(map);

				if (s.type1.equals("Terran") && s.type2.equals("Zerg")) {
					mapwinrate = currentMap.getMyTerranwinrate() - currentMap.getYourZergwinrate();
				}
				if (s.type1.equals("Zerg") && s.type2.equals("Protoss")) {
					mapwinrate = currentMap.getMyZergwinrate() - currentMap.getYourProtosswinrate();
				}
				if (s.type1.equals("Protoss") && s.type2.equals("Terran")) {
					mapwinrate = currentMap.getMyProtosswinrate() - currentMap.getYourTerranwinrate();
				}
				if (s.type1.equals("Zerg") && s.type2.equals("Terran")) {
					mapwinrate = currentMap.getYourZergwinrate() - currentMap.getMyTerranwinrate();
				}
				if (s.type1.equals("Protoss") && s.type2.equals("Zerg")) {
					mapwinrate = currentMap.getYourProtosswinrate() - currentMap.getMyZergwinrate();
				}
				if (s.type1.equals("Terran") && s.type2.equals("Protoss")) {
					mapwinrate = currentMap.getYourTerranwinrate() - currentMap.getMyProtosswinrate();
				}

				winrate = (int) ((double) ((sum1 + sum1 - sum2 + +(mapwinrate * 50)) * 100) / ((double) sum3));
				Random random = new Random();
				int winrate1 = random.nextInt(100) + 1;

				if (winrate1 <= winrate) {
					System.out.println((s.Computerset + 1) + "세트 승리" + sunsu1);
					s.team1wincount++;
					s.Computerset++;
					s.WIN = true;
					s.Lose = false;
					s.sunsudb.record(sunsu1, s.WIN, s.type2);
					s.sunsudb.record(sunsu2, s.Lose, s.type1);
					s.recorddb.insertRecorddata(sunsu1, sunsu2, s.type1, s.type2, map);
				} else if (winrate1 > winrate) {
					System.out.println((s.Computerset + 1) + "세트 승리" + sunsu2);
					s.team2wincount++;
					s.Computerset++;
					s.Lose = true;
					s.WIN = false;
					s.sunsudb.record(sunsu1, s.WIN, s.type2);
					s.sunsudb.record(sunsu2, s.Lose, s.type1);
					s.recorddb.insertRecorddata(sunsu2, sunsu1, s.type2, s.type1, map);
				}
				

				if (s.team1wincount == 4) {
					System.out.println("승리팀:" + s.array[s.week][j][0] + " 스코어 " + s.team1wincount + ":"+ s.team2wincount);
					s.teamdb.record(s.array[s.week][j][0], true, s.team1wincount, s.team2wincount);
					s.teamdb.record(s.array[s.week][j][1], false, s.team2wincount, s.team1wincount);
					
					break;
				} else if (s.team2wincount == 4) {
					System.out.println("승리팀:" + s.array[s.week][j][1] + " 스코어 " + s.team1wincount + ":" + s.team2wincount);
					s.teamdb.record(s.array[s.week][j][0], false, s.team1wincount, s.team2wincount);
					s.teamdb.record(s.array[s.week][j][1], true, s.team2wincount, s.team1wincount);
					
					break;
				}
			}

		}

		try {
			String str;
			BufferedReader br = new BufferedReader(new FileReader("src/" + Myteam + ".txt")); // 불러올
																										// 파일이름
			s.v.clear();
			while ((str = br.readLine()) != null) {

				s.v.add(str + "\n");

			}

			br.close();

		} catch (IOException e2) {
			e2.printStackTrace();
		}
		s.v1.clear();
		s.teamdb.array();
	}


}
