package winb;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Test2 extends JLabel {
	
	private JFrame frame;
	private JLabel lblNewLabel;
	private boolean moveTF;
	HashSet<Integer> hs;
	int integer1 = 0;
	int integer2 = 0;
	int integer3 = 0;
	int integer4 = 0;
	
	int imgX = 50;
	int imgY = 50;
	
	JLabel bomb;
	private Thread t1 = new Thread(new Runnable() {

		@Override
		public void run() {
			while (true) {
				if (integer1 == 1) {
					imgX = imgX - 5;
					lblNewLabel.setBounds(imgX, imgY, 57, 15);
				}
				if (integer2 == 1) {
					imgX = imgX + 5;
					lblNewLabel.setBounds(imgX, imgY, 57, 15);
				}
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test2 window = new Test2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		t1.start();
		hs = new HashSet<>();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					integer1 = 1;
				}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					integer2 = 1;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					integer1 = 0;
				}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					integer2 = 0;
				}
			}
		});

		lblNewLabel = new JLabel("ĳ����");
		lblNewLabel.setBounds(imgX, imgY, 57, 15);
		frame.getContentPane().add(lblNewLabel);

	}
}
