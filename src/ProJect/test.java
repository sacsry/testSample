package ProJect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class test {

	private ArrayList<String> NewMap1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		sunsu a = new sunsu("이영호");
//		a.data();
//		System.out.println(a.getAtk());
//		System.out.println(a.getType());
//		System.out.println(a.getDef());
//		System.out.println(a.getControl());
//		System.out.println(a.getTectics());
//		System.out.println(a.getSense());
//		System.out.println(a.getSupply());
//		System.out.println(a.getGrade());
//		
		
		
		Recorddata rec = new Recorddata("이영호");
		rec.searchRecorddata();
		System.out.print(rec.getAnotherplayer());
		
		

		

		
	}


	
}
