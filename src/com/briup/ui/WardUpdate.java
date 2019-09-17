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
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.briup.pojo.Ward;
import com.briup.service.IWardService;
import com.briup.service.impl.WardServiceImpl;
/**
 * 
 * @author 吴涛涛
 * @date 2019年7月22日
 *
 */
public class WardUpdate extends JFrame implements ActionListener {
	Ward ward=null;
	private Container containerPanel;
	private BackgroundPanel bgp;
	private JPanel jpanelcenter,jpanelupdate;
	private JButton jbuttonupdate,jbuttonback;
	private JPanel[] jpanel;
	private JButton[] jbutton;
	private JTextField[] jtextfield;
	//private JTextField Jtextfield[];
	private String[] btninfo;
	
	Color bg = new Color(225, 242, 241);
	Font f = new Font("楷体", Font.BOLD, 18);
	public WardUpdate(Ward ward) {
		this.ward=ward;
		setSize(450, 650);
		// 设置位置
		setLocationRelativeTo(null);
		// 设置不可改变大小
		setResizable(false);
		// 设置关闭按钮，退出程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置标题
		setTitle("病房管理-修改界面");
		// 设置桌布
		containerPanel = getContentPane();
		// 设置背景
		containerPanel.setBackground(Color.gray);
		// 设置布局管理器
		containerPanel.setLayout(new BorderLayout()); 
		initGUI();
		
	}
	public void initGUI() {
		bgp=new BackgroundPanel(new ImageIcon("src/images/login.png").getImage());
		bgp.setPreferredSize(new Dimension(450, 100));
		containerPanel.add(bgp,BorderLayout.NORTH);
		//中间部分
		jpanelcenter = new JPanel(new FlowLayout());
		jpanelcenter.setBackground(Color.white);
		FlowLayout f = (FlowLayout) jpanelcenter.getLayout();
		f.setHgap(0);// 水平间距
		f.setVgap(15);// 组件垂直间距
		jpanel = new JPanel[8];
		jbutton = new JButton[8];
		jtextfield =new JTextField[8];
//      *编号id
//      *病房编号wid
//		*病房床位号wbednum
//		*病房管理医生wdoctor
//  	*病房管理医生编号wdoctornum
//		*病房类型wtype
//		*病房所属科室wdepartment
// 		*病房负责人wrespname
		btninfo=new String[]{"编号","病房编号","床位号","所属医生","医生编号",
		                   "病房类型","所属科室","负责人"};
		for(int i = 0; i<8; i++) {
			jpanel[i] = new JPanel();
			jbutton[i] = new JButton() ;
			jtextfield[i] = new JTextField();
			jbutton[i].setText(btninfo[i]);
			jpanel[i] = get(jpanel[i],jbutton[i],jtextfield[i]);
			jpanelcenter.add(jpanel[i]);
		}
		jtextfield[0].setText(ward.getId()+"");
		jtextfield[1].setText(ward.getWid()+"");
		jtextfield[2].setText(ward.getWbednum()+"");
		jtextfield[3].setText(ward.getWdoctor());
		jtextfield[4].setText(ward.getWdoctornum()+"");
		jtextfield[5].setText(ward.getWtype());
		jtextfield[6].setText(ward.getWdepartment());
		jtextfield[7].setText(ward.getWrespname());
		//修改按钮
		jpanelupdate = new JPanel(new FlowLayout());
		jbuttonupdate.setBackground(Color.white);
		jbuttonupdate = new JButton("修改");
		jbuttonupdate.setBackground(bg);
		jbuttonupdate.setPreferredSize(new Dimension(220, 35));
		jpanelupdate.add(jbuttonupdate);
		jbuttonupdate.addActionListener(this);
		FlowLayout fl = (FlowLayout) jpanelupdate.getLayout();
		fl.setHgap(0);// 水平间距
		fl.setVgap(0);// 组件垂直间距
		//返回按钮
		jbuttonback = new JButton("返回");
		jbuttonback.setBorder(null);
		jbuttonback.setBackground(Color.white);
		jpanelupdate.add(jbuttonback);
		jbuttonback.addActionListener(this);
		
		jpanelupdate.add(jbuttonback);
		jpanelcenter.add(jpanelupdate);
		containerPanel.add(jpanelcenter, BorderLayout.CENTER);
	}
	private JPanel get(JPanel jpanel, JButton jbutton, JTextField jtext) {
		//中间内容部分
		jpanel.setPreferredSize(new Dimension(300, 50));
		jbutton.setFont(f);
		jbutton.setBorder(null);
		jbutton.setPreferredSize(new Dimension(40, 40));
		jbutton.setContentAreaFilled(false);
		jpanel.add(jbutton, FlowLayout.LEFT);
		//输入部分
		jtext.setBorder(null);
		jtext.setBackground(null);
		jtext.setPreferredSize(new Dimension(250, 40));
		jpanel.add(jtext);
		return jpanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn=(JButton)e.getSource();
		if(btn==jbuttonupdate) {
			String id = jtextfield[0].getText();
			String wid = jtextfield[1].getText();
			String wbednum = jtextfield[2].getText();
			String wdoctor = jtextfield[3].getText();
			String wdoctornum = jtextfield[4].getText();
			String wtype = jtextfield[5].getText();
			String wdepartment = jtextfield[6].getText();
			String wrespname = jtextfield[7].getText();
			Ward ward=new Ward(Integer.parseInt(id),Integer.parseInt(wid),Integer.parseInt(wbednum),
					wdoctor,Integer.parseInt(wdoctornum),wtype,wdepartment,wrespname);
			IWardService iws=new WardServiceImpl();
			if(iws.update(ward)) {
				System.out.println("更新成功");
				dispose();
				new WardManager().go();
			}
		}else if(btn==jbuttonback) {
			dispose();
			new WardManager().go();
		}
	}
	public void go() {
		setVisible(true);
	}
	public static void main(String[] args) {
		//new WardUpdate().go();
	}
}
