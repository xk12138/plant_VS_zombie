package test;

public class Child1 extends Base {
	private static int child1value;
	
	public static void setValue(int v) {
		child1value = v;
	}
	
	public static int getValue() {
		return child1value;
	}
}
