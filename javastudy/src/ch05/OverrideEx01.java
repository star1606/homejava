package ch05;

class A {
	
	void run() {
		System.out.println("A �޸���.");
	}
}

class B extends A {
	
	
	
	@Override
	void run() {
		System.out.println("B �޸���.");
	}
}

class C extends B {
	
	String name = "C";
	
	@Override
	void run() {
		System.out.println(name + "�޸���.");
	}
}

public class OverrideEx01 {
	public static void main(String[] args) {
		A c1 = new C();
		c1.run(); // ����Ű�� ���� A���� �ٿ�ĳ������ ���� �ʰ��� C�� ������ ã�� �� �ִ�.
		
		B c2 = new C();
		c2.run();
		
		C c3 = new C();
		c3.run();
		
		A b1 = new B();
		b1.run();
		
		B b2 = new B();
		b2.run();
		
		A a1 = new A();
		a1.run();
	}
}