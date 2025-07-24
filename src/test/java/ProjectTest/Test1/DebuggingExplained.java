package ProjectTest.Test1;

public class DebuggingExplained {

	public static void main(String[] args) {
		int a = 20;
		int b = 7;
		
		int sum = add(a, b);
		
		System.out.println("La suma es: " + sum);

	}

	private static int add(int a, int b) {
		int sum = a + b;
		return sum;
	}

}
