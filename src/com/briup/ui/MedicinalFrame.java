package com.briup.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.briup.pojo.Medicinal;
import com.briup.service.impl.MedServiceImpl;
import com.briup.utils.DateUtil;


//药品信息管理
public class MedicinalFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private String[] columnCount= {"序号","姓名","成绩","生日","城市"};
	private List<Medicinal> list;
	public static Medicinal med;
	public static MedicinalFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MedicinalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MedicinalFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 469);
		setTitle("药品信息管理");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 58, 692, 332);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quaryAll();
			}
		});
		button.setBounds(58, 22, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("添加");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FromFjame().setVisible(true);
			}
		});
		button_1.setBounds(205, 22, 93, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("修改");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				quaryAll();
			}
		});
		button_2.setBounds(357, 22, 93, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("删除");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove();
				quaryAll();
			}
		});
		button_3.setBounds(539, 22, 93, 23);
		contentPane.add(button_3);
		
	}
	
	
	
	//查询
	public void quaryAll() {
		MedServiceImpl ss=new MedServiceImpl();
		list = ss.queryAll();
		if(list==null) {
			JOptionPane.showMessageDialog(null, "服务器繁忙");
			return;
		}
		Object[][] data = DateUtil.listToArray(list);
		table.setModel(new DefaultTableModel(data, columnCount));
	}
	
	//删除
	private void remove() {
		int i = table.getSelectedRow();
		Medicinal m = list.get(i);
		int code = new MedServiceImpl().delete(m.getId());
		if(code==0) {
			JOptionPane.showMessageDialog(null, "删除成功");
			return;
		}else {
			JOptionPane.showMessageDialog(null,DateUtil.errors.get(code) );
		}
		quaryAll();
	}
	
	//修改
	private void update() {
		int i = table.getSelectedRow();
		med = list.get(i);
		new FromFjame().setVisible(true);
	}
}