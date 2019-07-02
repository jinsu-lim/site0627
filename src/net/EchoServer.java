//에코서버란 클라이언트의 메세지를 받은 후, 그대로 전달하는 역할의 네트워크 서버를 의미
//채팅 제작의 기초
//이미 구현해놓은 구현체(객체) = socket
//전산에서의 소켓이란 현실에서의 소켓(전구 등)처럼 이미 내부적으로 기술적인 부분을
//구현해놓은 구현체를 말한다.
//특히 복잡한 부분을 추상화 시켜놓아 개발자가 메서드 호출만으로도 기술 구현이 가능해진다.
//자바 네트워크에서의 소켓은 두 종류가 있다. 전화기용 소켓(대화용 소켓)
// 1)  전화를 받는 용도 == 서버소켓
// 2) 대화용 소켓 : 종이컵과 같음
package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	ServerSocket server; //받는 용도
	int port=7777; //0~1023까지는 시스템 점유 포트이므로 사용x
	public EchoServer() {
		try {
			server=new ServerSocket(port); //해당 포트번호로 서버 생성
			System.out.println("접속사 기다리기 시작!");
			//소켓은 대화를 나눌 수 있는 전화기와 같다.
			Socket client=server.accept(); //접속자를 기다림, 메인 스레드인 실행부는 접속자가 발생할 때까지 대기상태에 빠짐
			System.out.println("접속자 발견!");
			
			//Client가 보낸 메세지를 받으려면
			//실행중인 프로그램으로 데이터가 들어오는 것이므로 입력스트림이 필요
			InputStream is=client.getInputStream();
			OutputStream os=client.getOutputStream();
			InputStreamReader input=new InputStreamReader(is);
			OutputStreamWriter output=new OutputStreamWriter(os);
			BufferedReader br=new BufferedReader(input);
			BufferedWriter bw=new BufferedWriter(output);
			while(true) {
			//int data=input.read();
			String data=br.readLine();
			System.out.println(data);
			//읽어들인 데이터를 다시 클라이언트에게 보내기
			//==실행중인 프로그램에서 데이터가 나가는 것이므로 출력
			bw.write(data+"\n");
			bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new EchoServer();
	}

}
