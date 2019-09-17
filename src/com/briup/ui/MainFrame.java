package com.briup.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.briup.ui.DoctorManager;
import com.briup.ui.Login;

//������
public class MainFrame extends JFrame implements ActionListener {
	private JButton ghBtn,userBtn,ypBtn,doctorBtn,costBtn,roomBtn;
	private JLabel iconLabel;
	public MainFrame() {
		setTitle("������");
		setSize(500,350);
		setLocation(200,200);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}
	public void initGUI(){
		//��ӱ���ͼƬ
		iconLabel =new JLabel(new ImageIcon("src/images/login.png"));
		iconLabel.setSize(500,100);
		
		//������������ϵͳ��ť
		 userBtn=new JButton("�û�����ϵͳ");
//		 Font f=new Font("����",Font.BOLD,10);
//		 ghBtn.setFont(f);
		 userBtn.setSize(120,30);
		 userBtn.setLocation(100,120);
		 
		 ghBtn=new JButton("�ҺŹ���ϵͳ");
		 ghBtn.setSize(120,30);
		 ghBtn.setLocation(250,120);
		 
		 ypBtn=new JButton("ҩƷ����ϵͳ");
		 ypBtn.setSize(120,30);
		 ypBtn.setLocation(100, 180);
		 
		 doctorBtn=new JButton("����ҽ������");
		 doctorBtn.setSize(120,30);
		 doctorBtn.setLocation(250, 180);
		 
		 costBtn=new JButton("�շ���Ŀ�Ǽ�");
		 costBtn.setSize(120,30);
		 costBtn.setLocation(100,240);
		 
		 roomBtn=new JButton("סԺ����ϵͳ");
		 roomBtn.setSize(120,30);
		 roomBtn.setLocation(250,240);
		 //������
		this.add(iconLabel,BorderLayout.NORTH);
		this.add(userBtn);
		this.add(ghBtn);
		this.add(ypBtn);
		this.add(doctorBtn);
		this.add(costBtn);
		this.add(roomBtn);
		
		userBtn.addActionListener(this);
		ghBtn.addActionListener(this);
		ypBtn.addActionListener(this);
		doctorBtn.addActionListener(this);
		costBtn.addActionListener(this);
		roomBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==userBtn) {
			
		}else if(e.getSource()==ghBtn) {
			dispose();
			try {
				new RegisteredGui1().go();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource()==ypBtn) {
			dispose();
			new MedicinalFrame().setVisible(true);
			
		}else if(e.getSource()==doctorBtn) {
			dispose();
			new DoctorManager().go();
			
		}else if(e.getSource()==costBtn) {
			//�رյ�ǰҳ��
			dispose();
			new PayUI().go();
		}else {
	
		}
	}
	public void go() {
		setVisible(true);
	}
	public static void main(String[] args) {
		new MainFrame().go();
	}
	
}
