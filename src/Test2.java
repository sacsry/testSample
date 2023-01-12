import java.util.Arrays;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = { 15,-10,3,-21,16,-30 };
		int newarray[] = new int[6];
		int count = 0;
		for (int i = 0; i<array.length; i++) {
			if(array[i]<0) {
				newarray[count]=array[i];
				count++;
			}
			
		}
		for (int i = 0; i<array.length; i++) {
			if(array[i]>0) {
				newarray[count]=array[i];
				count++;
			}
			
		}
		System.out.println(Arrays.toString(newarray));
		
	}
}
