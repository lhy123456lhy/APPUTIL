package com.ds.apputil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.net.ssl.SSLServerSocketFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 获取密码套件字的工具
 *
 */
public class AllCiphersApp extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8880089531014282682L;

	public static void main(String[] args) {
        new AllCiphersApp();
    }

    JLabel label1;
    JLabel label2;
    JButton bt;

    public AllCiphersApp() {
        this.setVisible(true);
        this.setSize(450, 420);//设置框大小
        this.setVisible(true);
        this.setLocation(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel("获取密码套件字");
        label2 = new JLabel("密码套件字：");
        JTextArea textArea = new JTextArea();
        textArea.setBounds(23, 217, 650, 266);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 217, 650, 266);
        scrollPane.setViewportView(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        bt = new JButton("获取密码套件字");
        
        // 添加获取密码套件字的点击事件监听器
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	SSLServerSocketFactory ssf =(SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
                TreeMap<String,Boolean> allciphers = new TreeMap<String,Boolean>();
                for(String cipher:ssf.getSupportedCipherSuites()) {
                	allciphers.put(cipher,Boolean.FALSE);
                    String s = "";
                    String[] defaultCipherSuites = ssf.getDefaultCipherSuites();
                    for(String str:defaultCipherSuites){
                    	s += str + "\n";
                    }
                    textArea.setText(s);
                }
            }
        });
        
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        // 添加间隔
        hGroup.addGap(5);
        hGroup.addGroup(layout.createParallelGroup().addComponent(label2));
        
        hGroup.addGroup(layout.createParallelGroup().addComponent(bt).addComponent(label1)
                .addComponent(scrollPane));
        hGroup.addGap(5);
        layout.setHorizontalGroup(hGroup);
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup().addComponent(label1));
       
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(label2).addComponent(scrollPane));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(bt));
        layout.setVerticalGroup(vGroup);
    }
}

