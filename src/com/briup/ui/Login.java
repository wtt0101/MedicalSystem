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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicButtonUI;

import com.briup.dao.DoctorDao;
import com.briup.dao.IUserDao;
import com.briup.pojo.Doctor;
import com.briup.pojo.Manager;
import com.briup.pojo.User;
import com.briup.ui.MainFrame;
import com.briup.service.IDoctorLogin;
import com.briup.service.IUserService;
import com.briup.service.impl.DoctorLoginImpl;
import com.briup.service.impl.UserServiceImpl;

/**
 * 
 * @author 吴涛涛
 * @date 2019年7月19日
 * 
 */
/*
 * 登录界面
 */
public class Login extends JFrame implements ActionListener {
	private int err = 0;
	private Verify x =new Verify();
	private Container containerPanel;
	// 上方图片
	private BackgroundPanel bgp;
	// 中间部分
	private JPanel center;
	private GroupLayout layout;
	private JPanel account;
	private JPanel password;
	private Color bg = new Color(225, 242, 241);
	// 登录按钮
	JPanel login;
	JButton bt_login,J_register;
	// 选择是普通用户还是管理员
	JPanel radio;
	ButtonGroup bg_radio;
	Font r_f;
	//JLabel J_register;
	// 密码**********
	JTextField t_password;
	// 账号********
	JTextField userid;
	//
	private int flag = 0; // 0 1

	public Login() {
		// 设置容器宽高
		setSize(450, 350);
		// 设置位置
		setLocationRelativeTo(null);
		// 设置不可改变大小
		setResizable(false);
		// 设置关闭按钮，退出程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置标题
		setTitle("登录界面");
		// 设置桌布
		containerPanel = getContentPane();
		// 设置背景
		containerPanel.setBackground(Color.gray);
		// 设置布局管理器
		containerPanel.setLayout(new BorderLayout()); // 第一个水平间距
		initGui();
	}

	public void initGui() {
		// 上方图片部分
		bgp = new BackgroundPanel((new ImageIcon("./src/login.png")).getImage());
		bgp.setPreferredSize(new Dimension(450, 100));
		containerPanel.add(bgp, BorderLayout.NORTH);
		// 中间部分
		center = new JPanel();
		center.setBackground(Color.white);
		layout = new GroupLayout(center);
// 账号********
		JButton b_account = new JButton();
		b_account.setEnabled(false);
		ImageIcon i_account = new ImageIcon("./src/images/account.png");// 48
		account = new JPanel();
		account.setPreferredSize(new Dimension(300, 50));
		account.setBackground(null);
		account.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));

		b_account.setIcon(i_account);
		b_account.setBorder(null);
		b_account.setPreferredSize(new Dimension(40, 40));// 设置按钮大小
		b_account.setContentAreaFilled(false);
		account.add(b_account, FlowLayout.LEFT);

		userid = new JTextField();
		userid.setPreferredSize(new Dimension(250, 40));
		userid.setBorder(null);
		// 添加事件
		userid.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				b_account.setEnabled(false);
				account.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
			}

			@Override
			public void focusGained(FocusEvent e) {
				b_account.setEnabled(true);
				account.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, bg));
			}
		});
//		t_account.setBackground(Color.blue);
		account.add(userid);
		GroupLayout.ParallelGroup g_account = layout.createParallelGroup().addComponent(account);

		// 密码**********
		JButton b_password = new JButton();
		b_password.setEnabled(false);
		ImageIcon i_password = new ImageIcon("./src/images/password.png");// 48
		password = new JPanel();
		password.setPreferredSize(new Dimension(300, 50));
		password.setBackground(null);
		password.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));

		b_password.setIcon(i_password);
		b_password.setBorder(null);
		b_password.setPreferredSize(new Dimension(40, 40));// 设置按钮大小
		b_password.setContentAreaFilled(false);
		password.add(b_password, FlowLayout.LEFT);

		t_password = new JTextField();
		// 添加事件
		t_password.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				b_password.setEnabled(false);
				password.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
			}

			@Override
			public void focusGained(FocusEvent e) {
				b_password.setEnabled(true);
				password.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, bg));
			}
		});
		t_password.setPreferredSize(new Dimension(250, 40));
		t_password.setBorder(null);
//		t_password.setBackground(Color.blue);
		password.add(t_password);
		GroupLayout.ParallelGroup g_password = layout.createParallelGroup().addComponent(password);

		//
		radio = new JPanel();
		radio.setBackground(Color.white);
		r_f = new Font("楷体", Font.BOLD, 13);
		JRadioButton r_radio1 = new JRadioButton("用户");
		JRadioButton r_radio2 = new JRadioButton("管理员");
		r_radio1.setFont(r_f);
		r_radio2.setFont(r_f);
		r_radio1.setForeground(Color.gray);
		r_radio2.setForeground(Color.gray);
		r_radio1.setBackground(Color.white);
		r_radio2.setBackground(Color.white);
		r_radio2.setMargin(new Insets(0, 0, 0, 120));
		bg_radio = new ButtonGroup();

		bg_radio.add(r_radio1);
		bg_radio.add(r_radio2);
		r_radio1.setSelected(true);
		radio.add(r_radio1);
		
		//用户
		r_radio1.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (flag == 0) {
					flag = 1;
					//System.out.println(flag);
				}
				else {
					flag = 0;
					//System.out.println(flag);
				}
					
			}
		});
		/*//管理员
		r_radio2.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (flag == 0)
					flag = 1;
				else
					flag = 0;
			}
		});*/
		radio.add(r_radio2);
		J_register = new JButton("点击注册");
		J_register.setBackground(Color.white);
		J_register.setBorder(null);
		J_register.setFont(r_f);
		J_register.setForeground(Color.gray);
		radio.add(J_register);
		GroupLayout.ParallelGroup g_radio = layout.createParallelGroup().addComponent(radio);
		J_register.addActionListener(this);

		//
		login = new JPanel();
		login.setBackground(Color.white);
		bt_login = new JButton("登录");
		bt_login.addActionListener(this);
		bt_login.setFont(new Font("楷体", Font.BOLD, 18));
//		bt_register.setForeground(Color.gray);
		bt_login.setBackground(bg);
		bt_login.setPreferredSize(new Dimension(220, 35));
		login.add(bt_login);
		GroupLayout.ParallelGroup bt_radio = layout.createParallelGroup().addComponent(login);
		// 加入
		GroupLayout.SequentialGroup group = layout.createSequentialGroup();
		layout.setVerticalGroup(group);
		group.addGroup(g_account).addGroup(g_password).addGroup(g_radio).addGroup(bt_radio);

		containerPanel.add(center, BorderLayout.CENTER);
	}

	public void go() {
		setVisible(true);
	}

	public static void main(String[] args) {
		new Login().go();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if(J_register==e.getSource()) {
				dispose();
				new UserRegister().go();
				return;
			}
		Object source = e.getSource();
		int id = Integer.parseInt(userid.getText());
		String psw = t_password.getText();
		UserServiceImpl user = new UserServiceImpl();
		System.out.println(id+"*");
		System.out.println(psw+"*");
		if(x.flag==1) {               
			x.flag=0;
			this.err=1;
		}
		if ((JButton) source == source) {
			
//			System.out.println(err);
//			System.out.println(flag);
			if(err>2) {
				if(err==3) {
					JOptionPane.showMessageDialog(null, "你已经输错两次了~");
				}
				x.go();
//				System.out.println("x.flag"+x.flag);
			}
			System.out.println("flag"+flag);
			if (flag == 0) { 
				// 普通用户
				if(bt_login==e.getSource()) {
					if (user.login(id, psw)) {
						System.out.println("登录成功！");
						dispose();
						IUserDao dao = new IUserDao();
						User use = dao.QuerrybyAccount(id);
						new Index(use).go();
					}
				}
			} else if (flag == 1) { 
				// 管理员
				System.out.println(id);
				System.out.println(psw);
			  if(user.managerlogin(id, psw)) {
					System.out.println("登录成功");
					dispose();
					new MainFrame().go();
				}else {
					//登录失败
					err = err+1;
					
				}
			}
		}
		
	}

}
