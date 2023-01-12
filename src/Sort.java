import java.util.Arrays;

public class Sort {
	
	public static int[] arraySort(int array[]){
		Arrays.sort(array);
		return null;
	}
	public static void main(String[] args) {
		int array[] = {1,5,2,4,3};
		Sort array1 = new Sort();
		array1.arraySort(array);
		System.out.println(Arrays.toString(array));
		
		
	}
	

}
