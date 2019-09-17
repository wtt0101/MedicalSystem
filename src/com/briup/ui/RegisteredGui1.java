package com.briup.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;

import static javax.swing.JOptionPane.*;

/**
 * @Author: Jiang Lei
 * @Date: 2019/7/4 9:06
 */
public class RegisteredGui1 extends JFrame {
    private JPanel panel1, panel2, panel3, panel4, panel5;
    private JLabel label0, label1, label2, label3, label4,
            label5, label6, label7, label8, label9, label10;
    private JTextField textField1, textField2, textField3, textField4, textField5,
            textField6, textField7, textField8, textField9, textField10;
    private JButton button1, button2, button3, button4, button5;
    private JTextArea textArea1;
    private JComboBox comboBox;
    private JSeparator separator1, separator2;
    private BufferedReader br;
    private BufferedWriter bw;
    private File file;
    private long count1, count2;

    public RegisteredGui1() throws IOException {
        br = new BufferedReader(
                new FileReader(
                        "src/com/briup/ui/registered.txt"));
        bw = new BufferedWriter(
                new FileWriter(
                        "src/com/briup/ui/registered.txt", true));
        file = new File("src/com/briup/ui/registered.txt");
        count1 = 0;
        count2 = 0;

        setTitle("挂号信息管理");
        setSize(1100, 650);
        setLocation(150, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());

        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel(new BorderLayout());

        separator1 = new JSeparator(SwingConstants.HORIZONTAL);
        separator2 = new JSeparator();

//        label0 = new JLabel("",JLabel.CENTER);
//        label0.setText("挂号信息管理");
//        panel1.add(label0);
//        add(panel1);


        label1 = new JLabel("姓名");
        label1.setFont(new Font("Dialog", 1, 15));
        panel2.add(label1);
        textField1 = new JTextField(10);
        textField1.setFont(new Font("Dialog", 0, 15));
        panel2.add(textField1);

        label2 = new JLabel("性别");
        label2.setFont(new Font("Dialog", 1, 15));
        panel2.add(label2);

        comboBox = new JComboBox();
        comboBox.addItem(new String("--请选择--"));
        comboBox.addItem(new String("男"));
        comboBox.addItem(new String("女"));
        comboBox.setFont(new Font("Dialog", 1, 12));
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String s = (String) comboBox.getSelectedItem();
                if (s.contains("--请选择--")) {
                    showMessageDialog(
                            null, "请选择正确的选项！！！",
                            "温馨提示", INFORMATION_MESSAGE);
                }
            }
        });
        panel2.add(comboBox);

        label3 = new JLabel("诊断编号");
        label3.setFont(new Font("Dialog", 1, 15));
        panel2.add(label3);
        textField3 = new JTextField(10);
        textField3.setFont(new Font("Dialog", 0, 15));
        panel2.add(textField3);

        label4 = new JLabel("诊断名称");
        label4.setFont(new Font("Dialog", 1, 15));
        panel2.add(label4);
        textField4 = new JTextField(10);
        textField4.setFont(new Font("Dialog", 0, 15));
        panel2.add(textField4);

        label5 = new JLabel("所属科室");
        label5.setFont(new Font("Dialog", 1, 15));
        panel2.add(label5);
        textField5 = new JTextField(10);
        textField5.setFont(new Font("Dialog", 0, 15));
        panel2.add(textField5);
        add(panel2);
        add(separator1);

        label6 = new JLabel("挂号编号");
        label6.setFont(new Font("Dialog", 1, 15));
        panel3.add(label6);
        textField6 = new JTextField(10);
        textField6.setFont(new Font("Dialog", 0, 15));
        panel3.add(textField6);

        label7 = new JLabel("病人编号");
        label7.setFont(new Font("Dialog", 1, 15));
        panel3.add(label7);
        textField7 = new JTextField(10);
        textField7.setFont(new Font("Dialog", 0, 15));
        panel3.add(textField7);

        label8 = new JLabel("医生编号");
        label8.setFont(new Font("Dialog", 1, 15));
        panel3.add(label8);
        textField8 = new JTextField(10);
        textField8.setFont(new Font("Dialog", 0, 15));
        panel3.add(textField8);

        label9 = new JLabel("医生姓名");
        label9.setFont(new Font("Dialog", 1, 15));
        panel3.add(label9);
        textField9 = new JTextField(10);
        textField9.setFont(new Font("Dialog", 0, 15));
        panel3.add(textField9);

        label10 = new JLabel("挂号时间");
        label10.setFont(new Font("Dialog", 1, 15));
        panel3.add(label10);
        textField10 = new JTextField(10);
        textField10.setFont(new Font("Dialog", 0, 15));
        panel3.add(textField10);
        add(panel3);

        button1 = new JButton("新增");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().length() == 0
                        || comboBox.getSelectedItem().equals("--请选择--")
                        || textField3.getText().length() == 0
                        || textField4.getText().length() == 0
                        || textField5.getText().length() == 0
                        || textField6.getText().length() == 0
                        || textField7.getText().length() == 0
                        || textField8.getText().length() == 0
                        || textField9.getText().length() == 0
                        || textField9.getText().length() == 0) {
                    showMessageDialog(
                            null, "请输入完整信息！", "警告", WARNING_MESSAGE);
                } else {
                    try {
                        while (br.readLine() != null) {
                            if (!br.readLine().contains(
                                    "姓名：" + textField1.getText() + " " +
                                            "性别：" + comboBox.getSelectedItem().toString() + " " +
                                            "诊断编号：" + textField3.getText() + " " +
                                            "诊别名称：" + textField4.getText() + " " +
                                            "所属科室：" + textField5.getText() + " " +
                                            "挂号编号：" + textField6.getText() + " " +
                                            "病人编号：" + textField7.getText() + " " +
                                            "医生编号：" + textField8.getText() + " " +
                                            "医生姓名：" + textField9.getText() + " " +
                                            "挂号时间：" + textField10.getText() + " "
                            )) {
                                try {
                                    count1 = file.length();
                                    System.out.println(count1);
                                    bw.write("姓名：" + textField1.getText() + " ");
                                    bw.write("性别：" + comboBox.getSelectedItem().toString() + " ");
                                    bw.write("诊断编号：" + textField3.getText() + " ");
                                    bw.write("诊别名称：" + textField4.getText() + " ");
                                    bw.write("所属科室：" + textField5.getText() + " ");
                                    bw.write("挂号编号：" + textField6.getText() + " ");
                                    bw.write("病人编号：" + textField7.getText() + " ");
                                    bw.write("医生编号：" + textField8.getText() + " ");
                                    bw.write("医生姓名：" + textField9.getText() + " ");
                                    bw.write("挂号时间：" + textField10.getText() + " ");
                                    bw.write("\n");
                                    bw.flush();
                                    textArea1.append("姓名：" + textField1.getText() + " ");
                                    textArea1.append("性别：" + comboBox.getSelectedItem().toString() + " ");
                                    textArea1.append("诊断编号：" + textField3.getText() + " ");
                                    textArea1.append("诊别名称：" + textField4.getText() + " ");
                                    textArea1.append("所属科室：" + textField5.getText() + " ");
                                    textArea1.append("挂号编号：" + textField6.getText() + " ");
                                    textArea1.append("病人编号：" + textField7.getText() + " ");
                                    textArea1.append("医生编号：" + textField8.getText() + " ");
                                    textArea1.append("医生姓名：" + textField9.getText() + " ");
                                    textArea1.append("挂号时间：" + textField10.getText() + " ");
                                    textArea1.append("\n");
                                    count2 = file.length();
                                    System.out.println(count2);
                                    if (count2 > count1) {
                                        showMessageDialog(null, "添加成功", "温馨提示", INFORMATION_MESSAGE);
                                    } else {
                                        showMessageDialog(null, "添加失败", "警告", WARNING_MESSAGE);
                                    }
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                            } else {
                                showMessageDialog(null, "请不要重复添加", "警告", WARNING_MESSAGE);
                            }
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        button1.setFont(new Font("Dialog", 1, 15));
        panel4.add(button1);

        button2 = new JButton("查询");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = showInputDialog("请输入要查询的挂号编号");
                if (s.length() == 0) {
                    textArea1.setText("请输入正确编号！");
                } else {
                    textArea1.setText("");
                    //TODO
                }
            }
        });
        button2.setFont(new Font("Dialog", 1, 15));
        panel4.add(button2);

        button3 = new JButton("修改");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        button3.setFont(new Font("Dialog", 1, 15));
        panel4.add(button3);

        button4 = new JButton("删除");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        button4.setFont(new Font("Dialog", 1, 15));
        panel4.add(button4);

        button5 = new JButton("清空");
        button5.setFont(new Font("Dialog", 1, 15));
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
                textField7.setText("");
                textField8.setText("");
                textField9.setText("");
                textField10.setText("");
            }
        });
        panel4.add(button5);

        add(panel4);
        textArea1 = new JTextArea(23, 82);
        //激活自动换行功能
        textArea1.setLineWrap(true);
        textArea1.setFont(new Font("Dialog", 0, 16));
        panel5.add(new JScrollPane(textArea1));
        add(BorderLayout.SOUTH, panel5);
        String s;
        while ((s = br.readLine()) != null) {
            textArea1.append(s + "\n");
            textArea1.getLineWrap();
        }
    }

    public void go() {
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new RegisteredGui1().go();
    }
}

