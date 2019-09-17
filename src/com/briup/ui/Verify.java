package com.briup.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Verify extends JFrame implements ActionListener{
	int flag=0;
	private Container containerPanel;
	private Mypanel panel;
	private JPanel center;
	private JLabel text;
	private JTextField field;
	private JButton btn1,btn2;
	public Verify() {
		// 设置容器宽高
		setSize(280, 250);
		// 设置位置
		setLocationRelativeTo(null);
		// 设置不可改变大小
		setResizable(false);
		// 设置关闭按钮，退出程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置标题
		setTitle("验证码界面");
		// 设置桌布
		containerPanel = getContentPane();
		// 设置背景
		containerPanel.setBackground(Color.gray);
		// 设置布局管理器
		containerPanel.setLayout(new BorderLayout()); // 第一个水平间距
		initGUI();
	}
	public void initGUI() {
		panel=new Mypanel();
		panel.setPreferredSize(new Dimension(280, 80));
		containerPanel.add(panel,BorderLayout.NORTH);
		
		containerPanel.setBackground(null);
//		Mypanel panel = new Mypanel();
//		panel.setPreferredSize(new Dimension(280, 80));
		center=new JPanel();
		center.setPreferredSize(new Dimension(280, 60));
		text=new JLabel("请输入验证码:");
		field=new JTextField(20);
		btn1=new JButton("确定");
		btn2=new JButton("取消");
		center.add(text);
		center.add(field);
		center.add(btn1);
		center.add(btn2);
		containerPanel.add(center,BorderLayout.CENTER);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if ((JButton) source == btn1) {
			String text = field.getText().toLowerCase();
			String str = panel.flag;
			System.out.println(text);
			System.out.println(str);
			System.out.println(text.equals(str));
			if (text.equals(str)) {
				flag=1;
				dispose();
				new Login().go();
			}
		} else if ((JButton) source == btn2) {
			dispose();
		}
	}
	public void go() {
		setVisible(true);
	}
	public static void main(String[] args) {
		new Verify().go();
	}
}

