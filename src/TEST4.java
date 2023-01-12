
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TEST4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		FileWriter fin = null;
		int c;
		try {
			fin = new FileWriter("C:\\temp\\testFile.txt");
			
			while (true) {
				System.out.print("입력>>");
				String line = s.nextLine();
				if (line.equals("그만")) {
					break;
				} else {
					fin.write(line, 0, line.length());
					fin.write("\r\n",0,2);
				}
				fin.close();
			}
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("입출력 오류");
		}

	}

}