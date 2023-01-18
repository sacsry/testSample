package ProJect;

import java.util.ArrayList;
import java.util.Random;

public class MapChoice {

	private String Map[] = {"투혼","써킷브레이커","신피의능선","네오벨트웨이","네오아즈텍","신태양의제국","이카루스","라만차"};
	private int num3[] = new int[5];
	private ArrayList<String> NewMap;
	
	public MapChoice() {
		
		randommap();
		NewMap = new ArrayList<String>();
		for (int i =0; i<num3.length; i++) {
				NewMap.add(Map[num3[i]]);
		}
		
		
	}
	public String[] getMap() {
		return Map;
	}
	public void setMap(String[] map) {
		Map = map;
	}
	public int[] getNum3() {
		return num3;
	}
	public void setNum3(int[] num3) {
		this.num3 = num3;
	}
	public ArrayList<String> getNewMap() {
		return NewMap;
	}
	public void setNewMap(ArrayList<String> newMap) {
		NewMap = newMap;
	}
	public void randommap() {
		Random random = new Random();

		for (int i = 0; i < num3.length; i++) {
			num3[i] = random.nextInt(8);
			for (int j = 0; j < i; j++) {
				if (num3[i] == num3[j]) {
					i--;
					break;
				}
			}
		}
	}
}
