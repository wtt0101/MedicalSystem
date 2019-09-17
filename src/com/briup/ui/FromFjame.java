package com.briup.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.briup.pojo.Medicinal;
import com.briup.service.impl.MedServiceImpl;
import com.briup.utils.DateUtil;



public class FromFjame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	public FromFjame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 314, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("添加药品");
		label.setFont(new Font("宋体", Font.PLAIN, 17));
		label.setBounds(118, 20, 78, 39);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("名称");
		label_1.setBounds(23, 71, 40, 15);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(87, 68, 155, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("类型");
		label_2.setBounds(23, 128, 40, 15);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(87, 125, 155, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("描述");
		label_3.setBounds(23, 191, 32, 15);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(87, 188, 155, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("价格");
		label_4.setBounds(23, 251, 32, 15);
		contentPane.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(87, 248, 155, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
		//选择框添加内容
		JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(MedicinalFrame.med==null) {
					add();
				}else {
					update();
				}
			}
		});
		button.setBounds(37, 325, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//每次返回清空信息
				MedicinalFrame.med=null;
				//退出
				dispose();
			}
		});
		button_1.setBounds(169, 325, 93, 23);
		contentPane.add(button_1);
		
		//当点击的行数的信息不为空时，进行下面操作
		if(MedicinalFrame.med!=null) {
			textField.setText(MedicinalFrame.med.getName());
			textField_2.setText(MedicinalFrame.med.getType());
			textField_3.setText(MedicinalFrame.med.getDescription());
			textField_4.setText(MedicinalFrame.med.getPrice()+"");
			button.setText("修改");
		}
	}
	
	//增加
	private void add() {
		String name=textField.getText();
		String type=textField_2.getText();
		String description=textField_3.getText();
		double price=Double.parseDouble(textField_4.getText());
		Medicinal m=new Medicinal(name,type,description,price);
		int insert=new MedServiceImpl().insert(m);
		if(insert==0) {
			JOptionPane.showMessageDialog(null, "添加成功");
			textField.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			return;
		}else {
			JOptionPane.showMessageDialog(null, DateUtil.errors.get(insert));
		}
	}
	
	//修改
	private void update() {
		String name=textField.getText();
		String type=textField_2.getText();
		String description=textField_3.getText();
		double price=Double.parseDouble(textField_4.getText());
		MedicinalFrame.med.setName(name);
		MedicinalFrame.med.setType(type);
		MedicinalFrame.med.setDescription(description);
		MedicinalFrame.med.setPrice(price);
		int i=new MedServiceImpl().update(MedicinalFrame.med);
		if(i==0) {
			JOptionPane.showMessageDialog(null, "修改成功");
			MedicinalFrame.med=null;
			textField.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			MedicinalFrame.frame.quaryAll();
			dispose();
			return;
		}else {
			JOptionPane.showMessageDialog(null, DateUtil.errors.get(i));
		}		
	}
}
