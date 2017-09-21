package assignment1;

public class main {

	public static void main(String[] args) {
		RandomList theList = new RandomList(10);
		for (int i = 0; i < 10; i++) {
			System.out.println(theList.getList()[i]);
		}
	}

}
