package com.briup.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class PayUI extends JFrame implements ActionListener {
	private JButton checkBtn,returnBtn,exitBtn,listBtn;
	private JLabel ilabel,blhLa,nameLa,idla,bidla,ula,mla,sfnla,tla;
	private JTextField blhTxt,nameTxt,listTxt;
	public PayUI() {
		setTitle("�ɷѵǼ�");
		setSize(500,350);
		setLocation(200,200);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		contentPane=getContentPane();
//		contentPane.setLayout(new BorderLayout());
		initGUI();
	}
	public void initGUI() {
		ilabel =new JLabel(new ImageIcon("src/image/login.png"));
		ilabel.setSize(500,100);
		
		//����
		blhLa=new JLabel();
		blhLa.setText("������:");
		blhLa.setSize(50,50);
		blhLa.setLocation(20,100);
		//�����ı���
		blhTxt=new JTextField();
		blhTxt.setSize(200,25);
		blhTxt.setLocation(80, 110);
		//����
		nameLa=new JLabel();
		nameLa.setText("����:");
		nameLa.setSize(50,50);
		nameLa.setLocation(20,130);
		//������
		nameTxt=new JTextField();
		nameTxt.setSize(100,30);
		nameTxt.setLocation(80,140);
		//��ѯ��ť
		checkBtn=new JButton("��ѯ");
		checkBtn.setSize(60, 30);
		checkBtn.setLocation(300,130);
		
		//�б��ı���
		listTxt=new JTextField();
		listTxt.setSize(450,50);
		listTxt.setLocation(20,200);
		listTxt.setEditable(false);
		listTxt.setBackground(Color.white);
		
		idla=new JLabel();
		idla.setText("ƾ����");
		idla.setSize(50,50);
		idla.setLocation(20,160);
		
		bidla=new JLabel();
		bidla.setText("������");
		bidla.setSize(50,50);
		bidla.setLocation(70,160);
		
		ula=new JLabel();
		ula.setText("����");
		ula.setSize(50,50);
		ula.setLocation(120,160);
		
		mla=new JLabel();
		mla.setText("ҩƷ����");
		mla.setSize(60,50);
		mla.setLocation(170,160);
		
		sfnla=new JLabel();
		sfnla.setText("�շ�����");
		sfnla.setSize(60,50);
		sfnla.setLocation(250,160);
		
		tla=new JLabel();
		tla.setText("�ܷ���");
		tla.setSize(60,50);
		tla.setLocation(330,160);
		//���ذ�ť
		returnBtn=new JButton("����");
		returnBtn.setSize(60,30);
		returnBtn.setLocation(130,260);
		//�б�ť
		listBtn=new JButton("�嵥");
		listBtn.setSize(60,30);
		listBtn.setLocation(200,260);
		//�˳���ť
		exitBtn=new JButton("�˳�");
		exitBtn.setSize(60, 30);
		exitBtn.setLocation(270,260);
		this.add(ilabel,BorderLayout.NORTH);
		this.add(blhLa);
		this.add(blhTxt);
		this.add(nameLa);
		this.add(nameTxt);
		this.add(checkBtn);
		this.add(idla);
		this.add(bidla);
		this.add(ula);
		this.add(mla);
		this.add(sfnla);
		this.add(listTxt);
		this.add(tla);
		this.add(returnBtn);
		this.add(listBtn);
		this.add(exitBtn);
		checkBtn.addActionListener(this);
		returnBtn.addActionListener(this);
		listBtn.addActionListener(this);
		exitBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton bt=(JButton)e.getSource();
		//��ȡ��ť����ʾ���ı�
		String str=bt.getText();
		if(str.equals("��ѯ")) {
			if(!CheckIsNull()) {
				//��ȡ����Ĳ�����
				String blh=blhTxt.getText().trim();
				//��ȡ����
				String name=nameTxt.getText().trim();
				try {
					if(checkBlhAndName(blh,name)) {
						this.setVisible(true);
						//������ȷ����ת�����嵥����
						new Costlist().go();
					}
					else {

					    //��������򵯳�һ����ʾ��
					    JOptionPane pane = new JOptionPane("�����Ż�����������Ϊ��");
					    JDialog dialog  = pane.createDialog(this,"����");
					    dialog.show();
					}
				}catch(HeadlessException e1) {
					e1.printStackTrace();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		}else if(str.equals("����")){
			  dispose();
			  new MainFrame().go();
		}else if(str.equals("�嵥")){
			//dispose();
			new Costlist().go();
			
		}else {
			System.exit(0);
		}
	}
	private boolean CheckIsNull() {
		boolean flag = false;
		if(blhTxt.getText().trim().equals(" ")){
			flag = true;
		}else{
			if(nameTxt.getText().trim().equals(" ")){
				flag = true;
            }
	     }
		return flag;
	}
	 private boolean checkBlhAndName(String blh,String name) throws Exception{
	        boolean result = false;
	        Properties props = new Properties(); 
	        props.load(new FileInputStream("src/com/briup/ui/record.properties")); 
	        String blh1= props.getProperty("bId"); 
	        String name1= props.getProperty("name"); 
	        if(blh.equals(blh1)&&name.equals(name1))
	        	result = true;
	        System.out.println(blh1);
	        System.out.println(name1);
	        return result;
		}
	public void go() {
		setVisible(true);
	}
	public static void main(String[] args) {
		new PayUI().go();
	}
} 

