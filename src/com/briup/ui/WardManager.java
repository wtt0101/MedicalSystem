package com.briup.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.briup.pojo.Ward;
import com.briup.service.IWardService;
import com.briup.service.impl.WardServiceImpl;

public class WardManager extends JFrame implements ActionListener{ 
	private Container containerPane;
	//���в�����Ϣ
	List<Ward> res = null;
	// �Ϸ�ͼƬ
	private BackgroundPanel bgp;
	//�м���ʾ
	private JPanel jpanelcenter;
	//bar
	private String[] strbar ;
	private JLabel[] jlabelbar ;
	
	private Ward ward;
	private JLabel[] w;
	private JButton[] deletes;
	private JButton[] updates;
	

	public WardManager() {
		//��ȡ������Ϣ
		IWardService docs = new WardServiceImpl();
		 res = docs.querryall();
		//this.page=page;
		setTitle("�����������");
		//���ô�С
		int  h= res.size()*60+250;
		setSize(1000, h);
		// ����λ��
		setLocationRelativeTo(null);
		//���ܸı�������С
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		containerPane = getContentPane();
		containerPane.setLayout(new BorderLayout());
		initGUI();
	}
	public void initGUI() {
		Color bg = new Color(225, 242, 241);
		Font f = new Font("����", Font.BOLD, 20);
		Font f2 = new Font("����", Font.BOLD, 17);
		// �Ϸ�ͼƬ
		bgp = new BackgroundPanel((new ImageIcon("./src/login.png")).getImage());
//		bgp.setBounds(0,0,400,300);
		bgp.setPreferredSize(new Dimension(100, 120));
		containerPane.add(bgp, BorderLayout.NORTH);
		//�м���ʾ
		jpanelcenter = new JPanel(new GridLayout(res.size()+1,10,3,3));
		strbar =new String[]{"���","�������","��λ��","����ҽ��",
				"ҽ�����","��������","��������","������","ɾ��","�޸�"};
		jlabelbar = new JLabel[10];
		for (int i = 0; i < 10; i++) {
			jlabelbar[i] = new JLabel(strbar[i],JLabel.CENTER);
			// ���ñ�����ɫ
			jlabelbar[i] .setOpaque(true);  
			jlabelbar[i] .setBackground(bg);
			jlabelbar[i].setFont(f);
			jpanelcenter.add(jlabelbar[i]);
		}
		 updates = new JButton[res.size()];
		 deletes = new JButton[res.size()];
		for(int j=0; j<res.size(); j++) {
			ward = res.get(j);
			 w= new JLabel[8];
			 w[0] = new JLabel(ward.getId()+"",JLabel.CENTER);
			 w[1] = new JLabel(ward.getWid()+"",JLabel.CENTER);
			 w[2] = new JLabel(ward.getWbednum()+"",JLabel.CENTER);
			 w[3] = new JLabel(ward.getWdoctor(),JLabel.CENTER);
			 w[4] = new JLabel(ward.getWdoctornum()+"",JLabel.CENTER);
			 w[5] = new JLabel(ward.getWtype(),JLabel.CENTER);
			 w[6] = new JLabel(ward.getWdepartment(),JLabel.CENTER);
			 w[7] = new JLabel(ward.getWrespname(),JLabel.CENTER);
			 for(int x=0; x<8; x++) {
				 w[x].setFont(f2);
			 }
			
			 deletes[j] = new JButton("ɾ��");
			 updates[j] = new JButton("�޸�");
			 
			 deletes[j].setBackground(null);
			 updates[j].setBackground(null);
			 deletes[j].addActionListener(this);
			 updates[j].addActionListener(this);
			 jpanelcenter.add(w[0]);
			 jpanelcenter.add(w[1]);
			 jpanelcenter.add(w[2]);
			 jpanelcenter.add(w[3]);
			 jpanelcenter.add(w[4]);
			 jpanelcenter.add(w[5]);
			 jpanelcenter.add(w[6]);
			 jpanelcenter.add(w[7]);
			 jpanelcenter.add(deletes[j]);
			 jpanelcenter.add(updates[j]);
		}
		jpanelcenter.setBackground(Color.white);
		containerPane.add(jpanelcenter);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		JButton btn = (JButton)source;
		for(int i=0; i<res.size(); i++) {
			int id = res.get(i).getId();
			if(btn==deletes[i]) {
				System.out.println("deletes"+id);
				IWardService war= new WardServiceImpl();
				boolean deletebyid = war.deletebyid(id);
					dispose();
					new WardManager().go();
			}
			if(btn==updates[i]) {
				Ward war = res.get(i);
				dispose();
				//new ManageUpdate(doc).go();
				System.out.println("updates"+id);
			}
		}
	}
	public void go() {
		setVisible(true);
	}
	public static void main(String[] args) {
		new WardManager().go();
	}
}
