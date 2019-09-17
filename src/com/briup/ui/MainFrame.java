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

//主界面
public class MainFrame extends JFrame implements ActionListener {
	private JButton ghBtn,userBtn,ypBtn,doctorBtn,costBtn,roomBtn;
	private JLabel iconLabel;
	public MainFrame() {
		setTitle("主界面");
		setSize(500,350);
		setLocation(200,200);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}
	public void initGUI(){
		//添加背景图片
		iconLabel =new JLabel(new ImageIcon("src/images/login.png"));
		iconLabel.setSize(500,100);
		
		//创建六个管理系统按钮
		 userBtn=new JButton("用户管理系统");
//		 Font f=new Font("楷体",Font.BOLD,10);
//		 ghBtn.setFont(f);
		 userBtn.setSize(120,30);
		 userBtn.setLocation(100,120);
		 
		 ghBtn=new JButton("挂号管理系统");
		 ghBtn.setSize(120,30);
		 ghBtn.setLocation(250,120);
		 
		 ypBtn=new JButton("药品管理系统");
		 ypBtn.setSize(120,30);
		 ypBtn.setLocation(100, 180);
		 
		 doctorBtn=new JButton("门诊医生管理");
		 doctorBtn.setSize(120,30);
		 doctorBtn.setLocation(250, 180);
		 
		 costBtn=new JButton("收费项目登记");
		 costBtn.setSize(120,30);
		 costBtn.setLocation(100,240);
		 
		 roomBtn=new JButton("住院办理系统");
		 roomBtn.setSize(120,30);
		 roomBtn.setLocation(250,240);
		 //添加组件
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
			//关闭当前页面
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
