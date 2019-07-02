package net;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame{
	JTextArea area;
	JScrollPane scroll;
	JTextField txt,t_port;
	Choice ch;
	JButton bt_connect;
	JPanel panel,p_north;
	String ip[]= {"15","51","55","60","143","79","41","67"};
	Socket client;
	BufferedReader br;
	BufferedWriter bw;
	public ChatClient() {
		area=new JTextArea();
		scroll = new JScrollPane(area);
		txt=new JTextField(18);
		ch=new Choice();
		t_port=new JTextField("7777");
		bt_connect=new JButton("����");
		
		panel=new JPanel();
		panel.add(txt);
		
		//ip����
		for(int i=0;i<ip.length;i++) {
			ch.add("192.168.0."+ip[i]);
		}
		p_north=new JPanel();
		p_north.add(ch);
		p_north.add(t_port);
		p_north.add(bt_connect);
		
		//�����ڰ� ���̾ƿ��� �������������� ������ �ƴ� ����Ʈ ���̾ƿ��� ����
		//�ڹ�GUI ��� ������Ʈ�� ���̾ƿ� �ɷ��� ������ �ʰ�
		//�����̳� ������ ���̾ƿ��� �ִ�.
		//��� GUI ������Ʈ�� �з�
		// 1)���� ������ �� �ִ� ���� : �����̳�(Frame, Panel)
		//    > ���� �����ϱ� ���� ��ġ�� ���(frame==border, panel==flow)
		// 2)���ԵǴ� ���� : ����� ������Ʈ
		add(scroll, BorderLayout.CENTER);
		add(p_north, BorderLayout.NORTH);
		add(panel, BorderLayout.SOUTH);
		setVisible(true);
		//setSize(300,400);
		setBounds(100, 100, 300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt_connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		txt.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				//enter == 10
				if(e.getKeyCode()==e.VK_ENTER) {
					//������ �޼��� ����
					send(txt.getText());
				}
			}
		});
	}
	
	public void connect() {
		String ip=ch.getSelectedItem();
		int port=Integer.parseInt(t_port.getText());
		try {
			client=new Socket(ip,port); //ip, ��Ʈ
			//�������κ��� ��Ʈ�� ���
			br=new BufferedReader(new InputStreamReader(client.getInputStream()));
			bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void listen() {
		String msg=null;
		try {
			msg=br.readLine();
			area.append(msg+"\n");
			txt.setText("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void send(String msg) {
		try {
			bw.write("�͸� : "+msg+"\n"); //���ڿ��� ���� �ٹٲ��� �־�� �� ���� ���� �ν��Ѵ�.
			bw.flush(); //����ó���� ��� ��Ʈ�� �迭���� �� �޼��带 ȣ���ϸ�
			//���� ��Ʈ���� �׿��ִ� �����͸� ��� �����Ѵ�.  	
			listen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ChatClient();

	}

}
