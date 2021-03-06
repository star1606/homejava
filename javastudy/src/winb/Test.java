package winb;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;


public class Test extends JLabel {
	
	private JFrame frame;
	private JLabel lblNewLabel;
	private boolean moveTF;
	HashSet<Integer> hs;
	int integer1 = 0;
	int integer2 = 0;
	int integer3 = 0;
	int integer4 = 0;
	JLabel bomb;
	private Thread t1 = new Thread(new Runnable() {

		@Override
		public void run() {
			while (true) {
				if (integer1 == 1) {
					lblNewLabel.setBounds(lblNewLabel.getBounds().x - 5, lblNewLabel.getBounds().y,
							lblNewLabel.getBounds().width, lblNewLabel.getBounds().height);
				}
				if (integer2 == 1) {
					lblNewLabel.setBounds(lblNewLabel.getBounds().x + 5, lblNewLabel.getBounds().y,
							lblNewLabel.getBounds().width, lblNewLabel.getBounds().height);
				}
				if (integer3 == 1) {
					lblNewLabel.setBounds(lblNewLabel.getBounds().x, lblNewLabel.getBounds().y - 5,
							lblNewLabel.getBounds().width, lblNewLabel.getBounds().height);
				}
				if (integer4 == 1) {
					lblNewLabel.setBounds(lblNewLabel.getBounds().x, lblNewLabel.getBounds().y + 5,
							lblNewLabel.getBounds().width, lblNewLabel.getBounds().height);
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
					Test window = new Test();
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
	public Test() {
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
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					bomb = new JLabel("bomb");
					//lblNewLabel.getX()
					bomb.setBounds(lblNewLabel.getX(), lblNewLabel.getY(), 50, 15);
					frame.getContentPane().add(bomb);
				}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					integer1 = 1;
				}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					integer2 = 1;
				}else if(e.getKeyCode() == KeyEvent.VK_UP) {
					integer3 = 1;
				}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					integer4 = 1;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					integer1 = 0;
				}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					integer2 = 0;
				}else if(e.getKeyCode() == KeyEvent.VK_UP) {
					integer3 = 0;
				}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					integer4 = 0;
				}
			}
		});

		lblNewLabel = new JLabel("ĳ����");
		lblNewLabel.setBounds(144, 94, 57, 15);
		frame.getContentPane().add(lblNewLabel);

	}
}
