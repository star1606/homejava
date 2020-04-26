package example;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

import exModule.Data;
import exModule.Module1;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Button {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Button window = new Button();
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
	public Button() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 613, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(69, 0, 184, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uC704\uCE58");
		lblNewLabel.setBounds(23, 3, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		
		btnNewButton.addMouseListener(new MouseAdapter() { // ���콺 ������(���콺�����)�߰�
			@Override
			public void mouseClicked(MouseEvent e) { // ���콺�� Ŭ���Ǹ� �ݹ�
				
				Data d1 = new Data(); // �౹������ �ҷ����� ��� ��ü ����
				
				Module1 d2 = d1.getInfo(); // �౹ ������ ��������
				
				StringBuilder sb = new StringBuilder(); // �౹ ������ �ϳ��� ���� ���� ��Ʈ�� ���� ����
				
				int storeNum = d2.getStoreInfos().size(); // �ҷ��� �౹�� ��
				
				for (int i = 0; i < storeNum; i++) { // �౹�� ����ŭ �ݺ�
					
					// �ؽ�Ʈ �ʵ忡 �Է��� ����� ��ġ�ϴ� ��ġ�� �౹�� ��Ʈ�� ������ ���
					if((d2.getStoreInfos().get(i).getAddr()).contains(textField.getText())) { 
						String name = d2.getStoreInfos().get(i).getName();
						String addr = d2.getStoreInfos().get(i).getAddr();
						sb.append(name + " �� ��ġ�� " + addr + "\n");
					}	
					
				}
				
				textArea.setText(sb.toString()); // ��Ʈ�� ������ ��� ������ textArea�� ������
			}
		});
		
		btnNewButton.setBounds(69, 31, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 64, 545, 167);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}