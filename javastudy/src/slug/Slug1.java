package slug;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import slug.SlugMain.Jp1;

import java.awt.BorderLayout;

public class Slug1 {

	private JFrame frame;
	private int frameX = 800;
	private int frameY = 600;
	
	private MyJp panel;
	
	private ImageIcon stage1 = new ImageIcon("img/bgtest.png");
	
	private ImageIcon icon1 = new ImageIcon("img/shot.png");
	private ImageIcon icon2 = new ImageIcon("img/shotR.png");
	Image img = icon1.getImage();
	
	private int fieldY = frameY - (150+icon1.getImage().getHeight(panel));
	
	private int p1X = 50;
	private int p1Y = fieldY;
	private int p1W = 0;
	private int p1H = 0;
	private boolean p1JumpOver = true;
	
	private int p1Left;
	private int p1Right;
	private int p1SpaceKey;
	private int p1XKey;
	private int p1CKey;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Slug1 window = new Slug1();
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
	public Slug1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, frameX, frameY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new MyJp();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
	}

	class MyJp extends JPanel {
		public MyJp() {
			setFocusable(true);
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while (true) {
						if (p1Left == 1) {
							if(p1X >0) {
								if(img.equals(icon1.getImage())) {
									p1X = p1X - 70;
								}
								img = icon2.getImage();
								p1X = p1X - 5;
							}
						}else if (p1Right == 1) {
							if(p1X < (frameX/2 - p1W)) {
								if(img.equals(icon2.getImage())) {
									p1X = p1X + 70;
								}
								img = icon1.getImage();
								p1X = p1X + 5;
							} else {
								
							}
						}
						if (p1CKey == 1 && p1JumpOver) {
							new Thread(new Runnable() {
								
								@Override
								public void run() {
									jump();
								}
							}).start();
						}
						
						repaint();
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
			this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_LEFT) {
						p1Left = 1;
					}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
						p1Right = 1;
					}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
						p1SpaceKey = 1;
					}else if(e.getKeyCode() == KeyEvent.VK_X) {
						p1XKey = 1;
					}else if(e.getKeyCode() == KeyEvent.VK_C) {
						p1CKey = 1;
					}
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_LEFT) {
						p1Left = 0;
					}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
						p1Right = 0;
					}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
						p1SpaceKey = 0;
					}else if(e.getKeyCode() == KeyEvent.VK_X) {
						p1XKey = 0;
					}else if(e.getKeyCode() == KeyEvent.VK_C) {
						p1CKey = 0;
					}

				}
			});
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Image bg = stage1.getImage();
			g.drawImage(bg, 0, 0, (int)(bg.getWidth(this)*2.5), (int)(bg.getHeight(this)*2.5), this);
			
			p1W = img.getWidth(this);
			p1H = img.getHeight(this);
			g.drawImage(img, p1X, p1Y, (int)(p1W*2.5), (int)(p1H*2.5), this);
		}
	}
	
	// 현재시간을 롱값으로 받는다
	long getTime() {
		return Timestamp.valueOf(LocalDateTime.now()).getTime();
	}
	
	
	// 점프 메서드
	void jump() {
		System.out.println("점프시작");
		p1JumpOver = false;
		
		long t1 = getTime();
		long t2;
		while (true) {
			t2 = getTime() - t1;
			p1Y = p1Y - (6 - (int)((t2)/40));
			if(p1Y >= fieldY) {
				p1Y = fieldY;
				break;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		p1JumpOver = true;
	}
}
