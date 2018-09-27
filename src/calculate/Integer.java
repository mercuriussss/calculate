package calculate;

import java.util.Random;

public class Integer {

	public static String gen(int max) {
		Random rd = new Random();
		int integer = 0;
		while (integer == 0 || integer >= max) {
			integer = rd.nextInt(max) + 1;
		}
		return String.valueOf(integer);
	}
}
