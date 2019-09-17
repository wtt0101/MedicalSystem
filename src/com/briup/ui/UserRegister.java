package com.briup.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.briup.pojo.User;
import com.briup.service.impl.UserServiceImpl;

public class UserRegister extends JFrame implements ActionListener {
	private JFrame frame;
	private Container containerPanel;
	// �Ϸ�ͼƬ
	private BackgroundPanel bgp;
	// �м����ݲ���
	private JPanel jpanelcenter;
	private JPanel[] jpanel;
	private JButton[] jbutton;
	private JTextField[] Jtextfield;
//	private ImageIcon[] icon;
	private String[] btninfo;
	
	// ��¼��ť
	private JPanel jpanelregister;
	private JButton jbuttonregister;
	// ����
	private JButton jbuttonback;
	
	Color bg = new Color(200, 242, 241);
	Font f = new Font("����", Font.BOLD, 15);
	public UserRegister() {
		// �����������
		setSize(450, 600);
		// ����λ��
		setLocationRelativeTo(null);
		// ���ò��ɸı��С
		setResizable(false);
		// ���ùرհ�ť���˳�����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ñ���
		setTitle("ҽ����Ϣ����ϵͳ-ע��");
		// ��������
		containerPanel = getContentPane();
		// ���ñ���
		containerPanel.setBackground(Color.GRAY);
		// ���ò��ֹ�����
		containerPanel.setLayout(new BorderLayout()); // ��һ��ˮƽ���
		initGUI();
	}
	public void initGUI() {
		// �Ϸ�ͼƬ
	    bgp = new BackgroundPanel((new ImageIcon("./src/login.png")).getImage());
	    bgp.setPreferredSize(new Dimension(450, 100));
		containerPanel.add(bgp, BorderLayout.NORTH);

		// �м����ݲ���
		jpanelcenter = new JPanel(new FlowLayout());
		jpanelcenter.setBackground(Color.pink);
		FlowLayout f = (FlowLayout) jpanelcenter.getLayout();
		f.setHgap(0);// ˮƽ���
		f.setVgap(15);// �����ֱ���
		// �м����ݲ��� 
		jpanel = new JPanel[6] ;
		jbutton = new JButton[6] ;
		Jtextfield = new JTextField[6];
//		 * �û��� usreid
//		 * ���� password
//		 * ���� name
//		 * ���� age
//		 * �Ա� gender
//		 * �绰���� phone
		btninfo= new String[]{"�û���:","����:","����:","����:","�Ա�:","�绰����:"};
		for(int i = 0; i<6; i++) {
			jpanel[i] = new JPanel();
			jbutton[i] = new JButton() ;
			Jtextfield[i] = new JTextField();
			jbutton[i].setText(btninfo[i]);
			jpanel[i] = get(jpanel[i],jbutton[i],Jtextfield[i]);
			jpanelcenter.add(jpanel[i]);
		}
		// ע�ᰴť
		jpanelregister = new JPanel(new FlowLayout());
		jpanelregister.setBackground(Color.white);
//		jpanelregister.setPreferredSize(new Dimension(300,50));
		jbuttonregister = new JButton("ע��");
		jbuttonregister.setBackground(bg);
		jbuttonregister.setPreferredSize(new Dimension(150, 35));
		jpanelregister.add(jbuttonregister);
		jbuttonregister.addActionListener(this);
		FlowLayout fl = (FlowLayout) jpanelregister.getLayout();
		fl.setHgap(0);// ˮƽ���
		fl.setVgap(0);// �����ֱ���

		// ����
		jbuttonback = new JButton("����");
		//jbuttonback.setBorder(null);
		jbuttonback.setBackground(bg);
		jbuttonback.setPreferredSize(new Dimension(150, 35));
		jpanelregister.add(jbuttonback);
		jbuttonback.addActionListener(this);
				
		jpanelregister.add(jbuttonback);
		jpanelcenter.add(jpanelregister);
		containerPanel.add(jpanelcenter, BorderLayout.CENTER);

	}
	public JPanel get(JPanel jpanel,JButton jbuttonicon,JTextField jtext
			) {
		// �м����ݲ���
		jpanel.setPreferredSize(new Dimension(300, 50));
		jbuttonicon.setFont(f);
		jbuttonicon.setBorder(null);
		jbuttonicon.setPreferredSize(new Dimension(80, 40));// ���ð�ť��С
		jbuttonicon.setContentAreaFilled(false);
		jpanel.add(jbuttonicon, FlowLayout.LEFT);
		// ���벿��
		jtext.setBorder(null);
		jtext.setBackground(null);
		jtext.setPreferredSize(new Dimension(200, 40));
		jpanel.add(jtext);
		return jpanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if(btn == jbuttonregister) {
			if(Jtextfield[0].getText().equals("")|| Jtextfield[1].getText().equals("")||
					Jtextfield[2].getText().equals("")|| Jtextfield[3].getText().equals("")||
					Jtextfield[4].getText().equals("")|| Jtextfield[5].getText().equals("")) {
				JOptionPane.showMessageDialog(null, "��������Ϊ�գ�");
				return;
			}else {int userid = Integer.parseInt(Jtextfield[0].getText()); 
			String password = Jtextfield[1].getText(); 
			String name =Jtextfield[2].getText(); 
			int age = Integer.parseInt(Jtextfield[3].getText()); 
			String gender = Jtextfield[4].getText(); 
			String phone = Jtextfield[5].getText(); 
			User user = new User( userid, password, name, age, gender, phone);
			UserServiceImpl use = new UserServiceImpl();
			if(use.register(user)) {
				System.out.println("ע��ɹ���");
				dispose();
				new Login().go();
			}else {
				System.out.println("ע��ʧ�ܣ�");
				JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ�");
			}
		}
				
		}else if(btn==jbuttonback) {
				dispose();
				new Login().go();
			}
	}
	public void go() {
		setVisible(true);
	}
	public static void main(String[] args) {
		new UserRegister().go();
	}
	
}
