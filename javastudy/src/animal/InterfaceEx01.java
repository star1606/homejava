package animal;

// �������̽��� ������ �Լ�
// 1. ���� : public static final ����
// 2. �Լ� : public abstract ����
// 3. ����� ���� - ���� ���ε�
// 4. ������ �߻�޼��常 ���簡�� -> �������ο�
// 5. new �� �� ����

public enum LoginResult
}

// ������ ������ ���� �ִ� ���� [������]�� �شٰ� �Ѵ�
interface �μ� {
	int �ѹ��� = 10; // �����ڵ�
	int ������ = 20; // �����ڵ�
	int �λ�� = 30; // �����ڵ�
	int ������ = 40; // �����ڵ�
}

interface Cal {
	int num = 10; // �������̽��� ������ ������ public static final �̴�.
}

public class InterfaceEx01 {
	public static void main(String[] args) {
		System.out.println(Cal.num);
	}
}