package com.briup.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.briup.pojo.Doctor;
import com.briup.pojo.User;
import com.briup.ui.PayUI;

/*
 * ������ ��¼�ɹ��������ҳ��
 */
public class Index extends JFrame implements ActionListener {
	private User user;
	private Container containerPanel;
	// �Ϸ�ͼƬ
	private BackgroundPanel bgp;
	// �м䲿��
	//
	private JPanel jpanelcenter;
	//ȡ�� ���� ��ҩ �ɷ�
	private JButton btn_getnum;
	private JButton btn_getdoctor;
	private JButton btn_getmedicine;
	private JButton btn_pay;
	
	public Index(User user) {
		this.user = user;
		System.out.println(user);
		// �����������
		setSize(450, 350);
		// ����λ��
		setLocationRelativeTo(null);
		// ���ò��ɸı��С
		setResizable(false);
		// ���ùرհ�ť���˳�����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ñ���
		setTitle("ҽ����Ϣ����ϵͳ-������,��ӭ��"+user.getName());
		// ��������
		containerPanel = getContentPane();
		// ���ñ���
		containerPanel.setBackground(Color.gray);
		// ���ò��ֹ�����
		containerPanel.setLayout(new BorderLayout()); // ��һ��ˮƽ���
		initGui();
	}

	public void initGui() {
		//�Ϸ�ͼƬ����
		bgp = new BackgroundPanel((new ImageIcon("./src/login.png")).getImage());
		bgp.setPreferredSize(new Dimension(450, 100));
		containerPanel.add(bgp, BorderLayout.NORTH);
		// �м����ݲ��� ���벿��
		jpanelcenter = new JPanel(new FlowLayout(FlowLayout.CENTER,50,30));
		jpanelcenter.setBackground(Color.white);
		jpanelcenter.setPreferredSize(new Dimension(300, 50));
		
		btn_getnum = new JButton("ȡ��");
		btn_getdoctor = new JButton("����");
		btn_getmedicine = new JButton("��ҩ");
		btn_pay = new JButton("�ɷ�");
		
		btn_getnum = getbtn(btn_getnum);
		btn_getdoctor = getbtn(btn_getdoctor);
		btn_getmedicine = getbtn(btn_getmedicine);
		btn_pay = getbtn(btn_pay);
		
		jpanelcenter.add(btn_getnum);
		jpanelcenter.add(btn_getdoctor);
		jpanelcenter.add(btn_getmedicine);
		jpanelcenter.add(btn_pay);
		
		containerPanel.add(jpanelcenter);

	}
	//btn
	public JButton getbtn(JButton btn) {
		Font f = new Font("����", Font.BOLD, 20);
		btn.setFont(f);
		btn.addActionListener(this);
		btn.setBackground(Color.pink);
		btn.setPreferredSize(new Dimension(120,40));
		return btn;
	}
	

	public void go() {
		setVisible(true);
	}

	public static void main(String[] args) {
		new Index(new User()).go();
	}

	// ����ʽ�¼�����
	@Override
	public void actionPerformed(ActionEvent e) {
		// ��ȡ�¼�Դ �����¼��ĵط�
		Object source = e.getSource();
		JButton btn = (JButton) source;
		if(btn == btn_getnum) {
			System.out.println("ȡ��");
		}else if(btn == btn_getdoctor) {
			System.out.println("����");
		}else if(btn == btn_getmedicine) {
			System.out.println("��ҩ");
		}else if(btn == btn_pay) {
			System.out.println("�ɷ�");
			dispose();
			new PayUI().go();
		}
	}
}
