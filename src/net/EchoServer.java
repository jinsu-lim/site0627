//���ڼ����� Ŭ���̾�Ʈ�� �޼����� ���� ��, �״�� �����ϴ� ������ ��Ʈ��ũ ������ �ǹ�
//ä�� ������ ����
//�̹� �����س��� ����ü(��ü) = socket
//���꿡���� �����̶� ���ǿ����� ����(���� ��)ó�� �̹� ���������� ������� �κ���
//�����س��� ����ü�� ���Ѵ�.
//Ư�� ������ �κ��� �߻�ȭ ���ѳ��� �����ڰ� �޼��� ȣ�⸸���ε� ��� ������ ����������.
//�ڹ� ��Ʈ��ũ������ ������ �� ������ �ִ�. ��ȭ��� ����(��ȭ�� ����)
// 1)  ��ȭ�� �޴� �뵵 == ��������
// 2) ��ȭ�� ���� : �����Ű� ����
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
	ServerSocket server; //�޴� �뵵
	int port=7777; //0~1023������ �ý��� ���� ��Ʈ�̹Ƿ� ���x
	public EchoServer() {
		try {
			server=new ServerSocket(port); //�ش� ��Ʈ��ȣ�� ���� ����
			System.out.println("���ӻ� ��ٸ��� ����!");
			//������ ��ȭ�� ���� �� �ִ� ��ȭ��� ����.
			Socket client=server.accept(); //�����ڸ� ��ٸ�, ���� �������� ����δ� �����ڰ� �߻��� ������ �����¿� ����
			System.out.println("������ �߰�!");
			
			//Client�� ���� �޼����� ��������
			//�������� ���α׷����� �����Ͱ� ������ ���̹Ƿ� �Է½�Ʈ���� �ʿ�
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
			//�о���� �����͸� �ٽ� Ŭ���̾�Ʈ���� ������
			//==�������� ���α׷����� �����Ͱ� ������ ���̹Ƿ� ���
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
