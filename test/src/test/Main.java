package test;

public class Main {
	public static void main(String[] argvs) {
		Child1.setValue(5);
		Child2.setValue(10);

		for(int i=0;i<20;i++) {
			Child1 child = new Child1();
			System.out.println(child.getValue());
		}
	}
}
