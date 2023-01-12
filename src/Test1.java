import java.util.Random;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random ra = new Random();
		Scanner s = new Scanner(System.in);
		int count = 0;

		for(int i = 0 ; i <5 ;i++) {
			int r1 = ra.nextInt(8)+2;
			int r2 = ra.nextInt(9)+1;
			System.out.print( r1+" * "+ r2 + " = ");
			int a = s.nextInt();
			
			if ( a == r1*r2) {
				System.out.println("[정답입니다.]");
				count++;
			}
			else {
				System.out.println("[오답입니다.]");
			}
			
		}System.out.println("[총 " + count*20 + " 점입니다.]");
	}

}
