package test;

public class Child2 extends Base {
	private static int child2value;
	
	public static void setValue(int v) {
		child2value = v;
	}
	
	public static int getValue() {
		return child2value;
	}
}
