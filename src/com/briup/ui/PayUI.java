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
		setTitle("缴费登记");
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
		
		//病历
		blhLa=new JLabel();
		blhLa.setText("病历号:");
		blhLa.setSize(50,50);
		blhLa.setLocation(20,100);
		//病历文本框
		blhTxt=new JTextField();
		blhTxt.setSize(200,25);
		blhTxt.setLocation(80, 110);
		//姓名
		nameLa=new JLabel();
		nameLa.setText("姓名:");
		nameLa.setSize(50,50);
		nameLa.setLocation(20,130);
		//姓名框
		nameTxt=new JTextField();
		nameTxt.setSize(100,30);
		nameTxt.setLocation(80,140);
		//查询按钮
		checkBtn=new JButton("查询");
		checkBtn.setSize(60, 30);
		checkBtn.setLocation(300,130);
		
		//列表文本框
		listTxt=new JTextField();
		listTxt.setSize(450,50);
		listTxt.setLocation(20,200);
		listTxt.setEditable(false);
		listTxt.setBackground(Color.white);
		
		idla=new JLabel();
		idla.setText("凭单号");
		idla.setSize(50,50);
		idla.setLocation(20,160);
		
		bidla=new JLabel();
		bidla.setText("病历号");
		bidla.setSize(50,50);
		bidla.setLocation(70,160);
		
		ula=new JLabel();
		ula.setText("姓名");
		ula.setSize(50,50);
		ula.setLocation(120,160);
		
		mla=new JLabel();
		mla.setText("药品种类");
		mla.setSize(60,50);
		mla.setLocation(170,160);
		
		sfnla=new JLabel();
		sfnla.setText("收费内容");
		sfnla.setSize(60,50);
		sfnla.setLocation(250,160);
		
		tla=new JLabel();
		tla.setText("总费用");
		tla.setSize(60,50);
		tla.setLocation(330,160);
		//返回按钮
		returnBtn=new JButton("返回");
		returnBtn.setSize(60,30);
		returnBtn.setLocation(130,260);
		//列表按钮
		listBtn=new JButton("清单");
		listBtn.setSize(60,30);
		listBtn.setLocation(200,260);
		//退出按钮
		exitBtn=new JButton("退出");
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
		//获取按钮上显示的文本
		String str=bt.getText();
		if(str.equals("查询")) {
			if(!CheckIsNull()) {
				//获取输入的病历号
				String blh=blhTxt.getText().trim();
				//获取姓名
				String name=nameTxt.getText().trim();
				try {
					if(checkBlhAndName(blh,name)) {
						this.setVisible(true);
						//输入正确则跳转费用清单界面
						new Costlist().go();
					}
					else {

					    //如果错误则弹出一个显示框
					    JOptionPane pane = new JOptionPane("病历号或者姓名不能为空");
					    JDialog dialog  = pane.createDialog(this,"警告");
					    dialog.show();
					}
				}catch(HeadlessException e1) {
					e1.printStackTrace();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		}else if(str.equals("返回")){
			  dispose();
			  new MainFrame().go();
		}else if(str.equals("清单")){
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

