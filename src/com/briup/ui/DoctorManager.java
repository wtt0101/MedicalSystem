package com.briup.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.briup.pojo.Doctor;
import com.briup.service.IDoctorLogin;
import com.briup.service.impl.DoctorLoginImpl;
//import com.briup.ui.ManageIndex;
//import com.briup.ui.ManageUpdate;

/*
 * ҽ���������
 */
public class DoctorManager extends JFrame implements ActionListener {
	private Container containerPanel;
	private List<Doctor> res;
	private int page = 1;
	private int size = 7;
	private int w = 90;
	private int h = 50;
	private JPanel left_center;
	private Font f = new Font("����", Font.BOLD, 16);
	private DoctorLoginImpl idoctorlogin = new DoctorLoginImpl();
	private JPanel jp = null;
	private Color bg = new Color(225, 242, 241);
	// ģ����ѯ
	private JButton start;
	private JLabel left_label;
	private JTextField left_select;
	// ����
	private Doctor doctor;
	private JLabel[] d;
	private JButton[] deletes;
	private JButton[] updates;
	//
	private int all = 1;
	private JLabel pageinfo;
	// ����ҳ
	private JButton btn_last;
	private JButton btn_next;

	// �ұ�
	private JTextField id_field;
	private JTextField name_field;
	private JTextField age_field;
	private JTextField office_field;
	private JTextField account_field;
	private JTextField password_field;
	private JButton reset;
	private JButton set;
	private int flag_gender = 0;
	private JRadioButton male;
	private JRadioButton female;

	private JSplitPane splitPane;
	private int splitPane_size = 1200;

	public void initGui() {
		// ��ʾ��jpanel
		jp = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 1));
		jp.setPreferredSize(new Dimension(w * 9, 420));

		res = idoctorlogin.paging(page, size);
		size = res.size();
		all = (int) Math.ceil(idoctorlogin.querrynum() * 1.0 / size);
		// ��������
		splitPane = new JSplitPane();

		// ���
		JPanel left = new JPanel(new FlowLayout(FlowLayout.CENTER, 500, 40));
		left.setBackground(new Color(216, 239, 240));

		left.setMinimumSize(new Dimension(0, 420));
		left.setMaximumSize(new Dimension(800, 420));
		splitPane.setLeftComponent(left);
		// ����
		JPanel left_top = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 10));
		left_top.setBackground(null);
		left_top.setSize(new Dimension(600, 100));

		left_label = new JLabel("�������ֲ�ѯ:");
		left_label.setFont(new Font("����", Font.BOLD, 20));
		left_select = new JTextField();
		left_select.setPreferredSize(new Dimension(250, 30));
		start = new JButton("�����ѯ");

		start.setFont(new Font("����", Font.BOLD, 15));
		start.setForeground(Color.white);
		start.setPreferredSize(new Dimension(120, 40));
		start.setBackground(new Color(64, 167, 152));// ��ť������ɫ
		start.setForeground(Color.white);
		start.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, Color.gray));

		start.addActionListener(this);
		left_select.setSize(new Dimension(300, 100));
		left_top.add(left_label);
		left_top.add(left_select);
		left_top.add(start);
		left.add(left_top);

		// ������ 50 50
//		int w = 90;
//		int h = 50;
		left_center = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 1));
		jp.setBackground(Color.white);
		left_center.setPreferredSize(new Dimension(w * 9, 420));
		left.add(left_center);

		String[] bar_str = { "���", "����", "����", "�Ա�", "ְ��", "�˺�", "����", "ɾ��", "�޸�" };
		JLabel[] bar_jlabel = new JLabel[9];

		for (int i = 0; i < 9; i++) {
			bar_jlabel[i] = new JLabel(bar_str[i], JLabel.CENTER);
			// �˾����ص㣬���ñ�����ɫ�����Ƚ�������Ϊ��͸���ģ���ΪĬ����͸���ġ�����
			bar_jlabel[i].setOpaque(true);
			bar_jlabel[i].setBackground(new Color(69, 146, 175));
			bar_jlabel[i].setForeground(Color.white);
			bar_jlabel[i].setPreferredSize(new Dimension(w, h + 10));
			bar_jlabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
			bar_jlabel[i].setFont(f);
			left_center.add(bar_jlabel[i]);
		}

		// ��ʾ����
		show(res);
		// ����
		JPanel left_buttom = new JPanel(new FlowLayout(FlowLayout.LEFT, 100, 1));
		left_buttom.setBackground(null);
		btn_last = new JButton("��һҳ");

		pageinfo = new JLabel(page + "/" + all);
//		pageinfo.setForeground(Color.white);
		pageinfo.setFont(new Font("����", Font.BOLD, 25));
		btn_next = new JButton("��һҳ");
		btn_last.addActionListener(this);
		btn_next.addActionListener(this);
		btn_last.setPreferredSize(new Dimension(100, 40));
		btn_next.setPreferredSize(new Dimension(100, 40));
		btn_last.setBackground(new Color(64, 167, 152));
		btn_next.setBackground(new Color(64, 167, 152));
		btn_last.setForeground(Color.white);
		btn_next.setForeground(Color.white);
		left_buttom.add(btn_last);
		left_buttom.add(pageinfo);
		left_buttom.add(btn_next);
		left.add(left_buttom);

		// �ұ�
		JPanel right = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 120));
		right.setBackground(Color.white);
		right.setMinimumSize(new Dimension(0, 420));
		right.setMaximumSize(new Dimension(500, 420));
		JPanel right_center = new JPanel();
		right_center.setBackground(bg);
		right_center.setPreferredSize(new Dimension(600, 550));
		right_center.setBorder(BorderFactory.createTitledBorder("����"));

		JPanel update = update();

		right_center.add(update);
		right.add(right_center);
		splitPane.setRightComponent(right);

		// �ָ�������ʾ���� �۵�/չ�� ���������С��ť
		splitPane.setOneTouchExpandable(true);
		// �϶��ָ���ʱ�����ػ����
		splitPane.setContinuousLayout(true);
		// ���÷ָ����ĳ�ʼλ��
		splitPane.setDividerLocation(splitPane_size);
//		splitPane.setDividerLocation(500);
		// ���÷ָ����Ŀ��
		splitPane.setDividerSize(20);
		containerPanel.add(splitPane);
	}

	// �ұ��޸�***************************

	Font text = new Font("����", Font.BOLD, 18);

	public JPanel update() {
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		jp.setPreferredSize(new Dimension(480, 470));
		jp.setBackground(Color.white);
		// ���
		JPanel id_jp = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		id_jp.setPreferredSize(new Dimension(300, 50));
		id_jp.setBackground(Color.white);
		JLabel id_label = new JLabel("���");
		id_label.setFont(text);
		id_field = new JTextField(10);
		id_jp.add(id_label);
		id_jp.add(id_field);

		// ����
		JPanel name_jp = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		name_jp.setPreferredSize(new Dimension(300, 50));
		name_jp.setBackground(Color.white);
		JLabel name_label = new JLabel("����");
		name_label.setFont(text);

		name_field = new JTextField(10);
		name_jp.add(name_label);
		name_jp.add(name_field);

		// ����
		JPanel age_jp = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		age_jp.setPreferredSize(new Dimension(300, 50));
		age_jp.setBackground(Color.white);
		JLabel age_label = new JLabel("����");
		age_label.setFont(text);
		age_field = new JTextField(10);
		age_jp.add(age_label);
		age_jp.add(age_field);

		// �Ա�

		JPanel gender_jp = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		gender_jp.setPreferredSize(new Dimension(300, 50));
		gender_jp.setBackground(Color.white);
		male = new JRadioButton("��");
		female = new JRadioButton("Ů");
		JLabel gender_label = new JLabel("�Ա�");
		gender_label.setFont(text);
		//
		ButtonGroup gender = new ButtonGroup();
		gender.add(male);
		gender.add(female);
		gender_jp.add(gender_label);
		gender_jp.add(male);
		gender_jp.add(female);

		// ����
		JPanel office_jp = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		office_jp.setPreferredSize(new Dimension(300, 50));
		JLabel office_label = new JLabel("����");
		office_label.setFont(text);
		office_jp.setBackground(Color.white);

		office_field = new JTextField(10);
		office_jp.add(office_label);
		office_jp.add(office_field);

		// �˺�
		JPanel account_jp = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		account_jp.setPreferredSize(new Dimension(300, 50));
		JLabel account_label = new JLabel("�˺�");
		account_label.setFont(text);
		account_jp.setBackground(Color.white);

		account_field = new JTextField(10);
		account_jp.add(account_label);
		account_jp.add(account_field);

		// ����
		JPanel password_jp = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		password_jp.setPreferredSize(new Dimension(300, 50));
		JLabel password_label = new JLabel("����");
		password_label.setFont(text);
		password_jp.setBackground(Color.white);

		password_field = new JTextField(10);
		password_jp.add(password_label);
		password_jp.add(password_field);

		// ����
		JPanel do_jp = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		do_jp.setBackground(Color.white);
		password_jp.setPreferredSize(new Dimension(300, 50));
		reset = new JButton("����");
		reset.setBackground(new Color(64, 167, 152));
		reset.setFont(text);
		set = new JButton("�޸�");
		set.setBackground(new Color(64, 167, 152));
		reset.addActionListener(this);
		set.addActionListener(this);
		set.setFont(text);
		do_jp.add(reset);
		do_jp.add(set);

		jp.add(id_jp);
		jp.add(name_jp);
		jp.add(age_jp);
		jp.add(gender_jp);
		jp.add(office_jp);
		jp.add(account_jp);
		jp.add(password_jp);
		jp.add(do_jp);

		return jp;
	}

//	��ʾ����
	public void show(List<Doctor> res) {
		if (jp != null) {
			jp.removeAll();
			jp.repaint();
		}

		deletes = new JButton[size];
		updates = new JButton[size];
		for (int j = 0; j < res.size(); j++) {
			doctor = res.get(j);
			d = new JLabel[7];
			d[0] = new JLabel(doctor.getDid() + "", JLabel.CENTER);
			d[1] = new JLabel(doctor.getDname(), JLabel.CENTER);
			d[2] = new JLabel(doctor.getDage() + "", JLabel.CENTER);
			d[3] = new JLabel(doctor.getDgender(), JLabel.CENTER);
			d[4] = new JLabel(doctor.getDoffice(), JLabel.CENTER);
			d[5] = new JLabel(doctor.getDaccount(), JLabel.CENTER);
			d[6] = new JLabel(doctor.getDpassword(), JLabel.CENTER);
			for (int x = 0; x < 7; x++) {
				d[x].setOpaque(true);
				d[x].setBackground(null);
				d[x].setPreferredSize(new Dimension(w, h));
				d[x].setBackground(Color.white);
				d[x].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
				d[x].setFont(f);
			}

			deletes[j] = new JButton("ɾ��");
			updates[j] = new JButton("�޸�");
			deletes[j].setBackground(new Color(245, 88, 123));
			updates[j].setBackground(new Color(95, 184, 120));
			deletes[j].setForeground(Color.white);
			updates[j].setForeground(Color.white);
			deletes[j].setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, Color.gray));
			updates[j].setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, Color.gray));
			deletes[j].addActionListener(this);
			updates[j].addActionListener(this);
			deletes[j].setPreferredSize(new Dimension(w, h));
			updates[j].setPreferredSize(new Dimension(w, h));

			deletes[j].addActionListener(this);
			updates[j].addActionListener(this);
			jp.add(d[0]);
			jp.add(d[1]);
			jp.add(d[2]);
			jp.add(d[3]);
			jp.add(d[4]);
			jp.add(d[5]);
			jp.add(d[6]);
			jp.add(deletes[j]);
			jp.add(updates[j]);
//			jp.revalidate();

			left_center.add(jp);
		}
	}

	public DoctorManager() {
		this.page = page;
		// �����������
		setSize(1200, 750);
		// ����λ��
		setLocationRelativeTo(null);
		// ���ò��ɸı��С
		setResizable(false);
		// ���ùرհ�ť���˳�����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ñ���
		setTitle("ҽ���������");
		// ��������
		containerPanel = getContentPane();
		// ���ñ���
		containerPanel.setBackground(Color.gray);
		// ���ò��ֹ�����
		containerPanel.setLayout(new BorderLayout()); // ��һ��ˮƽ���
		initGui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		all = (int) Math.ceil(idoctorlogin.querrynum() * 1.0 / size);
		Object source = e.getSource();
		JButton btn = (JButton) source;
		if (btn == btn_next) {
			if (page == all) {
				return;
			}
			page++;
			System.out.println("page=" + page);
			res = idoctorlogin.paging(page, size);
			jp.removeAll();
			System.out.println(jp == null);
			show(res);
			jp.updateUI();
			pageinfo.setText(page + "/" + all);

		} else if (btn == btn_last) {
			if (page == 1) {
				return;
			}
			page--;
			res = idoctorlogin.paging(page, size);
			jp.removeAll();
			System.out.println(jp == null);
			show(res);
			jp.updateUI();
			pageinfo.setText(page + "/" + all);
		}

		//
		for (int i = 0; i < res.size(); i++) {
			int did = res.get(i).getDid();
			if (btn == deletes[i]) {
				System.out.println("deletes" + did);
				if (idoctorlogin.deletebyid(did)) {
					res = idoctorlogin.paging(page, size);
					jp.removeAll();
					System.out.println(jp == null);
					show(res);
					jp.updateUI();
				}
			}

			if (btn == updates[i]) {
				splitPane.setDividerLocation(800);// **********************************
				jp.updateUI();
				Doctor doc = res.get(i);
				id_field.setText(doc.getDid() + "");
				name_field.setText(doc.getDname());
				age_field.setText(doc.getDage() + "");
				office_field.setText(doc.getDoffice());
				account_field.setText(doc.getDaccount());
				password_field.setText(doc.getDpassword());
				if (doc.getDgender().equals("��")) {
					male.setSelected(true);
				} else {
					female.setSelected(true);
				}
				System.out.println("updates" + did);
			}
		}

		// ��ѯ
		if (btn == start) {
			String name = left_select.getText();
			if (name.equals("")) {
				jp.removeAll();
				show(res);
				jp.updateUI();
			} else {
				List<Doctor> res = idoctorlogin.Querrybyname(name);
				jp.removeAll();
				System.out.println(jp == null);
				show(res);
				jp.updateUI();
				System.out.println(res);
			}
		}
		// �޸�
		if (btn == reset) {
			id_field.setText("");
			name_field.setText("");
			age_field.setText("");
			office_field.setText("");
			account_field.setText("");
			password_field.setText("");
		} else if (btn == set) {
			String g = "";
			if (male.isSelected()) {
				g = "��";
			} else {
				g = "Ů";
			}
			Doctor new_doc = new Doctor(name_field.getText(), Integer.parseInt(age_field.getText()), g,
					office_field.getText(), account_field.getText(), password_field.getText());
			new_doc.setDid(Integer.parseInt(id_field.getText()));
			if (idoctorlogin.update(new_doc)) {
				System.out.println("�޸ĳɹ�");
				res = idoctorlogin.paging(page, size);
				jp.removeAll();
				System.out.println(jp == null);
				show(res);
				splitPane.setDividerLocation(1200);
				jp.updateUI();
			} else {
				System.out.println("�޸�ʧ��");
			}
		}

	}

	public void go() {
		setVisible(true);
	}

	public static void main(String[] args) {
		new DoctorManager().go();
	}
}
