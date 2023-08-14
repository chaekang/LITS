import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSocketThread extends Thread {
	Socket socket;
	ChatServer server;
	BufferedReader in;		// �Է�
	PrintWriter out;		// ���
	String name;
	String threadName;
	
	public ServerSocketThread(ChatServer server, Socket socket) {
		this.server = server;
		this.socket = socket;
		threadName = super.getName();	// Thread �̸�
		System.out.println(socket.getInetAddress() + "���� �����Ͽ����ϴ�.");	// IP�ּ�
		System.out.println("Thread Name : " + threadName);
	}
	
	// Ŭ���̾�Ʈ�� �޽��� ���
	public void sendMessage(String str) {
		if (str != null)
			out.println(str);
	}
	
	// ������
	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// auto flush true: buffer �������� buffer ���� ���� �� buffer ���
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			
			sendMessage("����ä�ÿ� ���Ű��� ȯ���մϴ�. ����� �г����� �Է����ּ���.");
			name = in.readLine();
			server.broadCasting("["+name+"]"+"���� �����ϼ̽��ϴ�.");
			
			while(true) {
				String str_in = in.readLine();
				server.broadCasting("[" + name + "] " + str_in);
			}
		} catch (IOException e) {
			System.out.println(threadName + " �����߽��ϴ�.");
			server.removeClient(this);
			//e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}