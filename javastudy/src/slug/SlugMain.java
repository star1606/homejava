package slug;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class SlugMain {

	private JFrame frame;
	
	private Jp1 jp1;
	
	private ImageIcon icon1 = new ImageIcon("img/shot.png");
	private ImageIcon icon2 = new ImageIcon("img/shotR.png");
	
	private int p1X = 0;
	private int p1Y = 0;
	private int p1W = 0;
	private int p1H = 0;
	
	private int integer1;
	private int integer2;
	private int integer3;
	private int integer4;
	private Thread moveT = new Thread(new Runnable() {

		@Override
		public void run() {
			while (true) {
				if (integer1 == 1) {
					p1X = p1X - 5;
					System.out.println("l");
				}
				if (integer2 == 1) {
					p1Y = p1Y + 5;
					System.out.println("r");
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
					SlugMain window = new SlugMain();
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
	public SlugMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		moveT.start();
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		jp1 = new Jp1();
		frame.getContentPane().add(jp1, BorderLayout.CENTER);
		jp1.setLayout(null);
		
		
	}
	
	class Jp1 extends JPanel{
		
		public Jp1() {
			setFocusable(true);
			this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_LEFT) {
						integer1 = 1;
					}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
						integer2 = 1;
					}
					repaint();
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_LEFT) {
						integer1 = 0;
					}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
						integer2 = 0;
					}
					repaint();
				}
			});
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Image img = icon1.getImage();
			p1X = 10;
			p1Y = frame.getHeight()-150;
			p1W = img.getWidth(this);
			p1H = img.getHeight(this);
			g.drawImage(img, p1X, p1Y, p1W*2, p1H*2, this);

			
			//g.drawImage(img, imgW, 100, 0, imgH, 0, 0,imgW,imgH, this);
			//g.drawImage(img, 10, jp1.getHeight()-200, img.getWidth(this)*2, img.getHeight(this)*2, this);

		}
	}
}
