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
 * 主界面 登录成功后跳入此页面
 */
public class Index extends JFrame implements ActionListener {
	private User user;
	private Container containerPanel;
	// 上方图片
	private BackgroundPanel bgp;
	// 中间部分
	//
	private JPanel jpanelcenter;
	//取号 就诊 拿药 缴费
	private JButton btn_getnum;
	private JButton btn_getdoctor;
	private JButton btn_getmedicine;
	private JButton btn_pay;
	
	public Index(User user) {
		this.user = user;
		System.out.println(user);
		// 设置容器宽高
		setSize(450, 350);
		// 设置位置
		setLocationRelativeTo(null);
		// 设置不可改变大小
		setResizable(false);
		// 设置关闭按钮，退出程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置标题
		setTitle("医疗信息管理系统-主界面,欢迎："+user.getName());
		// 设置桌布
		containerPanel = getContentPane();
		// 设置背景
		containerPanel.setBackground(Color.gray);
		// 设置布局管理器
		containerPanel.setLayout(new BorderLayout()); // 第一个水平间距
		initGui();
	}

	public void initGui() {
		//上方图片部分
		bgp = new BackgroundPanel((new ImageIcon("./src/login.png")).getImage());
		bgp.setPreferredSize(new Dimension(450, 100));
		containerPanel.add(bgp, BorderLayout.NORTH);
		// 中间内容部分 密码部分
		jpanelcenter = new JPanel(new FlowLayout(FlowLayout.CENTER,50,30));
		jpanelcenter.setBackground(Color.white);
		jpanelcenter.setPreferredSize(new Dimension(300, 50));
		
		btn_getnum = new JButton("取号");
		btn_getdoctor = new JButton("就诊");
		btn_getmedicine = new JButton("拿药");
		btn_pay = new JButton("缴费");
		
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
		Font f = new Font("楷体", Font.BOLD, 20);
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

	// 集中式事件处理
	@Override
	public void actionPerformed(ActionEvent e) {
		// 获取事件源 产生事件的地方
		Object source = e.getSource();
		JButton btn = (JButton) source;
		if(btn == btn_getnum) {
			System.out.println("取号");
		}else if(btn == btn_getdoctor) {
			System.out.println("就诊");
		}else if(btn == btn_getmedicine) {
			System.out.println("拿药");
		}else if(btn == btn_pay) {
			System.out.println("缴费");
			dispose();
			new PayUI().go();
		}
	}
}
