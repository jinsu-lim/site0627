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
		bt_connect=new JButton("접속");
		
		panel=new JPanel();
		panel.add(txt);
		
		//ip설정
		for(int i=0;i<ip.length;i++) {
			ch.add("192.168.0."+ip[i]);
		}
		p_north=new JPanel();
		p_north.add(ch);
		p_north.add(t_port);
		p_north.add(bt_connect);
		
		//개발자가 레이아웃을 지정하지않으면 에러가 아닌 디폴트 레이아웃이 적용
		//자바GUI 모든 컴포넌트에 레이아웃 능력이 있지는 않고
		//컨테이너 형에만 레이아웃이 있다.
		//모든 GUI 컴포넌트의 분류
		// 1)남을 포함할 수 있는 유형 : 컨테이너(Frame, Panel)
		//    > 남을 포함하기 위해 배치를 고민(frame==border, panel==flow)
		// 2)포함되는 유형 : 비쥬얼 컴포넌트
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
					//서버에 메세지 전송
					send(txt.getText());
				}
			}
		});
	}
	
	public void connect() {
		String ip=ch.getSelectedItem();
		int port=Integer.parseInt(t_port.getText());
		try {
			client=new Socket(ip,port); //ip, 포트
			//소켓으로부터 스트림 얻기
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
			bw.write("익명 : "+msg+"\n"); //문자열의 끝에 줄바꿈이 있어야 한 줄의 끝을 인식한다.
			bw.flush(); //버퍼처리된 출력 스트림 계열에서 이 메서드를 호출하면
			//현재 스트림에 쌓여있는 데이터를 모두 방출한다.  	
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
