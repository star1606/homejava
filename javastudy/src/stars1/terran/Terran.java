package stars1.terran;

import stars1.Behavior;

public abstract class Terran implements Behavior {

	// �����Ӱ� ���� ġ��� �����佺 ���� �����̱� ������ �߻� Ŭ������ �ٷ� ������ش�

	public void move() {
		System.out.println("�̵�");
	}

	public void repair() {
		System.out.println("SCV ġ��");
	}

	// ������ �ٰŸ� ���Ÿ� �� �ٸ��⶧���� �߻� �޼���θ� ����
	// public abstract void attack();

	public static void upgrade() {
		Marine.attack++;
		Tank.attack++;
		System.out.println("�����佺 ���׷��̵� �Ϸ�");
	}
}