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
		
		JLabel label = new JLabel("���ҩƷ");
		label.setFont(new Font("����", Font.PLAIN, 17));
		label.setBounds(118, 20, 78, 39);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("����");
		label_1.setBounds(23, 71, 40, 15);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(87, 68, 155, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("����");
		label_2.setBounds(23, 128, 40, 15);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(87, 125, 155, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("����");
		label_3.setBounds(23, 191, 32, 15);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(87, 188, 155, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("�۸�");
		label_4.setBounds(23, 251, 32, 15);
		contentPane.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(87, 248, 155, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
		//ѡ����������
		JButton button = new JButton("���");
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
		
		JButton button_1 = new JButton("����");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ÿ�η��������Ϣ
				MedicinalFrame.med=null;
				//�˳�
				dispose();
			}
		});
		button_1.setBounds(169, 325, 93, 23);
		contentPane.add(button_1);
		
		//���������������Ϣ��Ϊ��ʱ�������������
		if(MedicinalFrame.med!=null) {
			textField.setText(MedicinalFrame.med.getName());
			textField_2.setText(MedicinalFrame.med.getType());
			textField_3.setText(MedicinalFrame.med.getDescription());
			textField_4.setText(MedicinalFrame.med.getPrice()+"");
			button.setText("�޸�");
		}
	}
	
	//����
	private void add() {
		String name=textField.getText();
		String type=textField_2.getText();
		String description=textField_3.getText();
		double price=Double.parseDouble(textField_4.getText());
		Medicinal m=new Medicinal(name,type,description,price);
		int insert=new MedServiceImpl().insert(m);
		if(insert==0) {
			JOptionPane.showMessageDialog(null, "��ӳɹ�");
			textField.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			return;
		}else {
			JOptionPane.showMessageDialog(null, DateUtil.errors.get(insert));
		}
	}
	
	//�޸�
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
			JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
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
