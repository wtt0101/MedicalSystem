package com.briup.ui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class Costlist extends JFrame {
	public Costlist() {
		setTitle("费用单");
		initGUI();
	}
	public void initGUI() {
		 String[] costlists =  
		        { "id_费用凭单号","blh_病历号", "username_姓名", "mtypes_药品种类", 
		        		"sfnl_收费内容", "tcost_总的费用" };  //设置JTable的列名 
		        Object[][] obj=new Object[8][8];  
		        for (int i=0;i<8;i++)  
		        {  
		            for(int j=0;j<8;j++)  
		            {  
		                switch (j)  
		                {  
		                case 0:  
		                    obj[0][0] = "1001";
		                    obj[0][1] = "01"; 
		                    obj[0][2] = "Jack"; 
		                    obj[0][3] = "3"; 
		                    obj[0][4] = "挂号费&X光线费&药品费 "; 
		                    obj[0][5] = "80.5"; 
		                    break;  
		                case 1:  
		                    obj[1][0] = "1002";
		                    obj[1][1] = "02"; 
		                    obj[1][2] = "柳如烟"; 
		                    obj[1][3] = "4"; 
		                    obj[1][4] = "挂号费&医生诊断费&B超费&药品费"; 
		                    obj[1][5] = "299.9"; 
		                    break;  
		                case 2:  
		                    obj[2][0] = "1003";
		                    obj[2][1] = "03"; 
		                    obj[2][2] = "陈翰文"; 
		                    obj[2][3] = "1"; 
		                    obj[2][4] = "挂号费&药品费"; 
		                    obj[2][5] = "39.8"; 
		                    break;  
		                case 3:  
		                    obj[3][0] = "1004";
		                    obj[3][1] = "04"; 
		                    obj[3][2] = "杨大力"; 
		                    obj[3][3] = "2"; 
		                    obj[3][4] = "挂号费&抽血费&药品费"; 
		                    obj[3][5] = "110.5"; 
		                    break;  
		                case 4:  
		                    obj[4][0] = "1005";
		                    obj[4][1] = "05"; 
		                    obj[4][2] = "闫珊珠"; 
		                    obj[4][3] = "5"; 
		                    obj[4][4] = "挂号费&手术费&住院费&药品费"; 
		                    obj[4][5] = "9998.9"; 
		                    break;  
		                case 5:  
		                    obj[5][0] = "1006";
		                    obj[5][1] = "06"; 
		                    obj[5][2] = "于海川"; 
		                    obj[5][3] = "3"; 
		                    obj[5][4] = "挂号费&打针费&药品费"; 
		                    obj[5][5] = "100.5"; 
		                    break;  
		                case 6:  
		                    obj[6][0] = "1007";
		                    obj[6][1] = "07"; 
		                    obj[6][2] = "周卫国"; 
		                    obj[6][3] = "6"; 
		                    obj[6][4] = "挂号费&做视镜费&药品费"; 
		                    obj[6][5] = "998"; 
		                    break;  
		                case 7:  
		                    obj[7][0] = "1008";
		                    obj[7][1] = "08"; 
		                    obj[7][2] = "曾晗"; 
		                    obj[7][3] = "3"; 
		                    obj[7][4] = "挂号费&检查费&药品费"; 
		                    obj[7][5] = "122.5"; 
		                    break;  

		                }  
		            }  
		        }  

		        JTable table=new JTable(obj, costlists);  //JTable的其中一种构造方法 
		        TableColumn column=null;                    //设置JTable的列默认的宽度和高度 
		        int colunms = table.getColumnCount();  
		        for(int i=0;i<colunms;i++)  
		        {  
		            column = table.getColumnModel().getColumn(i);  
		            column.setPreferredWidth(100);          //将每一列的默认宽度设置为100
		        }  
		        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); //设置JTable自动调整列表的状态，此处设置为关闭  
		        JScrollPane scroll = new JScrollPane(table);  //用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看
		        scroll.setSize(300, 50);  

		        add(scroll); 

		        this.setLocation(600, 200); 
		        this.setVisible(true);  
		        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		        this.pack();  
		    
	}
	public void go() {
		setVisible(true);
	}
	public static void main(String[] args) {
		new Costlist().go();
	}
}
