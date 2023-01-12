
public class Student extends Human {
	int stuNum;
	Student(int stuNum,String name,int age){
		super(name,age);
		this.stuNum = stuNum;
	}
	public String study(){
		return "학번 "+stuNum+" 학생 공부중";
	}
	
	public String toString() {
		return "이름은 " + getName() + " 나이는 " + getAge() + " 학번은 " + stuNum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student hong = new Student(20140643,"홍길동",30);
		
		System.out.println(hong.study());
		System.out.println(hong.toString());

	}

}
