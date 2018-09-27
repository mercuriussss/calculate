package calculate;

import java.util.Random;

public class Fraction {

	public static String gen(int max) {
		String fraction = null;
		Random rd = new Random();
		int numerator = rd.nextInt(max) + 1;
		int denominator = rd.nextInt(max) + 1;
		int overnum = 0;

		// 检验是否为整数
		if (numerator == denominator || numerator % denominator == 0) {
			fraction = numerator / denominator + "";
			return fraction;
		}

		// 该数不能超过max
		while (numerator / denominator >= max) {
			numerator = rd.nextInt(max) + 1;
			denominator = rd.nextInt(max) + 1;
		}
		
		//约分
		numerator /= getFactor(numerator,denominator);
		denominator /= getFactor(numerator,denominator);
		
		if (numerator > denominator) {
			overnum = numerator / denominator;
			numerator -= overnum * denominator;
			fraction = overnum + "'" + numerator + "/" + denominator;
		} else {
			fraction = numerator + "/" + denominator;
		}

		return fraction;
	}
	
	//求公因数
	public static int getFactor(int numerator, int denominator) {
		int small = numerator < denominator ? numerator : denominator;
		int factor = 1;
		for (int i = 1; i <= small; i++) {
			if (numerator % i == 0 && denominator % i == 0) {
				factor = i;
			}
		}
		return factor;
	}
}
