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
		// �����������
		setSize(280, 250);
		// ����λ��
		setLocationRelativeTo(null);
		// ���ò��ɸı��С
		setResizable(false);
		// ���ùرհ�ť���˳�����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ñ���
		setTitle("��֤�����");
		// ��������
		containerPanel = getContentPane();
		// ���ñ���
		containerPanel.setBackground(Color.gray);
		// ���ò��ֹ�����
		containerPanel.setLayout(new BorderLayout()); // ��һ��ˮƽ���
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
		text=new JLabel("��������֤��:");
		field=new JTextField(20);
		btn1=new JButton("ȷ��");
		btn2=new JButton("ȡ��");
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

