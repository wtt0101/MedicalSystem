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
	// 上方图片
	private BackgroundPanel bgp;
	// 中间内容部分
	private JPanel jpanelcenter;
	private JPanel[] jpanel;
	private JButton[] jbutton;
	private JTextField[] Jtextfield;
//	private ImageIcon[] icon;
	private String[] btninfo;
	
	// 登录按钮
	private JPanel jpanelregister;
	private JButton jbuttonregister;
	// 返回
	private JButton jbuttonback;
	
	Color bg = new Color(200, 242, 241);
	Font f = new Font("楷体", Font.BOLD, 15);
	public UserRegister() {
		// 设置容器宽高
		setSize(450, 600);
		// 设置位置
		setLocationRelativeTo(null);
		// 设置不可改变大小
		setResizable(false);
		// 设置关闭按钮，退出程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置标题
		setTitle("医疗信息管理系统-注册");
		// 设置桌布
		containerPanel = getContentPane();
		// 设置背景
		containerPanel.setBackground(Color.GRAY);
		// 设置布局管理器
		containerPanel.setLayout(new BorderLayout()); // 第一个水平间距
		initGUI();
	}
	public void initGUI() {
		// 上方图片
	    bgp = new BackgroundPanel((new ImageIcon("./src/login.png")).getImage());
	    bgp.setPreferredSize(new Dimension(450, 100));
		containerPanel.add(bgp, BorderLayout.NORTH);

		// 中间内容部分
		jpanelcenter = new JPanel(new FlowLayout());
		jpanelcenter.setBackground(Color.pink);
		FlowLayout f = (FlowLayout) jpanelcenter.getLayout();
		f.setHgap(0);// 水平间距
		f.setVgap(15);// 组件垂直间距
		// 中间内容部分 
		jpanel = new JPanel[6] ;
		jbutton = new JButton[6] ;
		Jtextfield = new JTextField[6];
//		 * 用户名 usreid
//		 * 密码 password
//		 * 姓名 name
//		 * 年龄 age
//		 * 性别 gender
//		 * 电话号码 phone
		btninfo= new String[]{"用户名:","密码:","姓名:","年龄:","性别:","电话号码:"};
		for(int i = 0; i<6; i++) {
			jpanel[i] = new JPanel();
			jbutton[i] = new JButton() ;
			Jtextfield[i] = new JTextField();
			jbutton[i].setText(btninfo[i]);
			jpanel[i] = get(jpanel[i],jbutton[i],Jtextfield[i]);
			jpanelcenter.add(jpanel[i]);
		}
		// 注册按钮
		jpanelregister = new JPanel(new FlowLayout());
		jpanelregister.setBackground(Color.white);
//		jpanelregister.setPreferredSize(new Dimension(300,50));
		jbuttonregister = new JButton("注册");
		jbuttonregister.setBackground(bg);
		jbuttonregister.setPreferredSize(new Dimension(150, 35));
		jpanelregister.add(jbuttonregister);
		jbuttonregister.addActionListener(this);
		FlowLayout fl = (FlowLayout) jpanelregister.getLayout();
		fl.setHgap(0);// 水平间距
		fl.setVgap(0);// 组件垂直间距

		// 返回
		jbuttonback = new JButton("返回");
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
		// 中间内容部分
		jpanel.setPreferredSize(new Dimension(300, 50));
		jbuttonicon.setFont(f);
		jbuttonicon.setBorder(null);
		jbuttonicon.setPreferredSize(new Dimension(80, 40));// 设置按钮大小
		jbuttonicon.setContentAreaFilled(false);
		jpanel.add(jbuttonicon, FlowLayout.LEFT);
		// 输入部分
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
				JOptionPane.showMessageDialog(null, "不能输入为空！");
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
				System.out.println("注册成功！");
				dispose();
				new Login().go();
			}else {
				System.out.println("注册失败！");
				JOptionPane.showMessageDialog(null, "注册失败！");
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
