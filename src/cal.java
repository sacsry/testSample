
public class cal implements Interface {

	
	public int add(int x, int y) {
		// TODO Auto-generated method stub
		return x + y;
	}
	
	
	public int sub(int x, int y) {
		// TODO Auto-generated method stub
		return x-y;
	}

	public double avg(int x, int y) {
		// TODO Auto-generated method stub
		return (x + y)/2;
	}
	
	public static void main(String[] args) {
		cal number = new cal();
		int a = number.add(5, 5);
		System.out.println(a);
		int b = number.sub(10, 5);
		System.out.println(b);
		double c = number.avg(10, 5);
		System.out.println(c);
	}


	
}
