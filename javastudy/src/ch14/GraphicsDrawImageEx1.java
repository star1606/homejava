package ch14;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawImageEx1 extends JFrame {
	
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("img/pa.png");
		private Image img = icon.getImage(); // �̹�����ü
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			// �̹����� �г��� 20, 20�� ������ ũ��� �׸���.
			g.drawImage(img, 20, 20, this);
		}
	}
	
	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawImageEx1() {
		setTitle("���� ũ��� ���ϴ� ��ġ�� �̹��� �׸���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(300, 420);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new GraphicsDrawImageEx1();
	}
}