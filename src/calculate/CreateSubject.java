package calculate;

import java.util.ArrayList;
import java.util.Random;

public class CreateSubject {
	// 四种符号
	// 2、3、4位相加
	private static final String[] OPERATORS = { "+", "-", "*", "/" };
	ArrayList<String> expression = new ArrayList<String>();// 算式字符串存储
	Random rd = new Random();

	public CreateSubject(int max) {

		String numA = randNum(max);
		String numB = null;
		int nums = rd.nextInt(3) + 2;// 几位数的运算
		String flag = null;
		expression.add(numA);
		
		for (int i = 0; i < nums - 1; i++) {
			numB = randNum(max);
			flag = OPERATORS[rd.nextInt(4)];

			switch (flag) {
			case "+":
				numA = Calculate.add(numA, numB);
				expression.add(flag);
				expression.add(numB);
				break;

			case "-":
				//若相减为负数，则重新生成一个满足条件的数
				while(Calculate.greater(numA, numB)) {
					numB = randNum(max);
				}
				numA = Calculate.sub(numA, numB);
				expression.add(flag);
				expression.add(numB);
				break;

			case "*":
				numA = Calculate.mul(numA, numB);
				expression.add(flag);
				expression.add(numB);
				break;

			case "/":
				numA = Calculate.div(numA, numB);
				expression.add(flag);
				expression.add(numB);
				break;
			}
		}
		addBrackets(expression);
		expression.add("=");

	}

	// 随机生成分数或整数
	public String randNum(int max) {
		String num;
		int flag = rd.nextInt(10) + 1;
		if (flag % 3 == 0) {
			num = Fraction.gen(max);
		} else {
			num = Integer.gen(max);
		}
		return num;
	}
	
	//生成必要的括号
	public ArrayList<String> addBrackets(ArrayList<String> expression){
		String lowlv = "+-";
		String highlv = "*/";
		if(expression.size()==5){
			if(lowlv.contains(expression.get(1)) && highlv.contains(expression.get(3))){
				expression.add(0,"(");
				expression.add(4,")");
			}
		}
		if(expression.size()==7){
			if(lowlv.contains(expression.get(1)) && highlv.contains(expression.get(3))){
				expression.add(0,"(");
				expression.add(4,")");
			}
			if(lowlv.contains(expression.get(3)) && highlv.contains(expression.get(5))){
				expression.add(0,"(");
				expression.add(6,")");
			}
		}
		return expression;
	}

	public static void main(String[] args) {

	}
}
