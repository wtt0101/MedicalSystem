package com.briup.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;

import com.briup.pojo.Doctor;
import com.briup.service.impl.DoctorLoginImpl;


/*
 * ��¼����
 */
public class Register extends JFrame implements ActionListener {
	private JFrame frame;
	private Container containerPanel;
	// �Ϸ�ͼƬ
	private BackgroundPanel bgp;
	// �м����ݲ���
	private JPanel jpanelcenter;
	
	// ��Ϣ����
//	 * ���� dname
//	 * ���� dage
//	 * �Ա� dgender
//	 * �������� doffice
//	 * �˺�daccount
//	 * ����dpassword
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
	
	Color bg = new Color(225, 242, 241);
	Font f = new Font("����", Font.BOLD, 18);

	// ��������������ʼ��
	public Register() {
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
		containerPanel.setBackground(Color.gray);
		// ���ò��ֹ�����
		containerPanel.setLayout(new BorderLayout()); // ��һ��ˮƽ���
		initGui();
	}

	// �������ʼ������ӵ�������
	public void initGui() {
		// �Ϸ�ͼƬ
		bgp = new BackgroundPanel((new ImageIcon("./src/login.png")).getImage());
//		bgp.setBounds(0,0,400,300);
		bgp.setPreferredSize(new Dimension(450, 100));
		containerPanel.add(bgp, BorderLayout.NORTH);

		// �м����ݲ���
		jpanelcenter = new JPanel(new FlowLayout());
		jpanelcenter.setBackground(Color.white);
		FlowLayout f = (FlowLayout) jpanelcenter.getLayout();
		f.setHgap(0);// ˮƽ���
		f.setVgap(15);// �����ֱ���

		// �м����ݲ��� �˺Ų���
		jpanel = new JPanel[6] ;
		jbutton = new JButton[6] ;
		Jtextfield = new JTextField[6];
//		 * ���� dname
//		 * ���� dage
//		 * �Ա� dgender
//		 * �������� doffice
//		 * �˺�daccount
//		 * ����dpassword
		btninfo= new String[]{"����","����","�Ա�","����","�˺�","����"};
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
		jbuttonregister.setPreferredSize(new Dimension(220, 35));
		jpanelregister.add(jbuttonregister);
		jbuttonregister.addActionListener(this);
		FlowLayout fl = (FlowLayout) jpanelregister.getLayout();
		fl.setHgap(0);// ˮƽ���
		fl.setVgap(0);// �����ֱ���

		// ����
		jbuttonback = new JButton("����");
		jbuttonback.setBorder(null);
		jbuttonback.setBackground(Color.white);
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
		jbuttonicon.setPreferredSize(new Dimension(40, 40));// ���ð�ť��С
		jbuttonicon.setContentAreaFilled(false);
		jpanel.add(jbuttonicon, FlowLayout.LEFT);
		// ���벿��
		jtext.setBorder(null);
		jtext.setBackground(null);
		jtext.setPreferredSize(new Dimension(250, 40));
		jpanel.add(jtext);
		return jpanel;
	}

	// ������ʾ
	public void go() {
		setVisible(true);
	}

	public static void main(String[] args) {
		new Register().go();
	}

	// �¼�
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		if(btn == jbuttonregister) {
			if(Jtextfield[0].getText().equals("")|| Jtextfield[1].getText().equals("")||
					Jtextfield[2].getText().equals("")|| Jtextfield[3].getText().equals("")||
					Jtextfield[4].getText().equals("")|| Jtextfield[5].getText().equals("")) {
				JOptionPane.showMessageDialog(null, "��������Ϊ�գ�");
				return;
			}else {
				String d_name = Jtextfield[0].getText(); 
				int d_age = Integer.parseInt(Jtextfield[1].getText()); 
				String d_gender =Jtextfield[2].getText(); 
				String d_office = Jtextfield[3].getText(); 
				String d_account = Jtextfield[4].getText(); 
				String d_password = Jtextfield[5].getText(); 
				Doctor doctor = new Doctor( d_name, d_age, d_gender, d_office, d_account, d_password);
				DoctorLoginImpl doc = new DoctorLoginImpl();
				if(doc.register(doctor)) {
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
}
