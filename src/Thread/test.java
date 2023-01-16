package Thread;

import java.awt.*;
import javax.swing.*;

public class test extends JFrame {
	private JLabel imageLabel; // 이미지 레이블
	 // 이미지 객체 배열
	int currentId; // 현재 선택된 이미지 번호(0~3).

	public test() {
		setTitle("test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane(); // 컨텐트팬 얻기
		c.setLayout(new BorderLayout()); // 컨텐트팬에 BorderLayout 설정

	
		
		// 이미지 파일 로딩.
		// 프로젝트의 images 폴터의 images0.jpg, image1.jpg, image2.jpg, image3.jpg
		
		String item = "김대엽               ";
		String item1 = item.trim();

		ImageIcon images = new ImageIcon("images/"+item1+".gif");
		System.out.print("images/"+item1+".gif");
		currentId = 0; // 현재 선택된 이미지 번호
		imageLabel = new JLabel();
		imageLabel.setIcon(images);// 현재 선택된 이미지를 레이블에 출력
		c.add(imageLabel, BorderLayout.CENTER); // 이미지 레이블을 CENTER에 부착
		 // 2 개의 화살표 버튼을 가진 MenuPanel 부착
		
		setSize(300,400);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test();
		
	}

}


