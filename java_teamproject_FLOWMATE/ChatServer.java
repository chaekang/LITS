import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	ServerSocket serverSocket;
	Socket socket;
	List<Thread> list;		// ServerSocketThread ��ü ����
	
	public ChatServer() {
		list = new ArrayList<Thread>();
		System.out.println("������ ���۵Ǿ����ϴ�.");
	}
	
	public void giveAndTake() {
		try {
			serverSocket = new ServerSocket(5420);		// ���� ���� ���
			serverSocket.setReuseAddress(true); 		// server socket�� port�� �ٽ� �����
			
			while(true) {
				socket = serverSocket.accept();			// accept -> 1. ���� ���� ��� 2. ���� ���� ���
				ServerSocketThread thread = new ServerSocketThread(this, socket);	// this -> ChatServer �ڽ�
				addClient(thread);		// ����Ʈ�� ������ ��ü ����
				thread.start();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	// synchronized: ������ ���� ���������� ��� ����
	// Ŭ���̾�Ʈ ���� �� ȣ�� 
	// ����Ʈ�� �ش� Ŭ���̾�Ʈ ������ ����
	private synchronized void addClient(ServerSocketThread thread) {
		// ����Ʈ�� ServerSocketThread ��ü ����
		list.add(thread);
		System.out.println("Client 1�� ����. �� " + list.size() + "��");
	}		
	
	// Ŭ���̾�Ʈ�� ���� �� ȣ��
	// addClient���� �����ߴ� ����Ʈ���� �ش� Ŭ���̾�Ʈ ������ ����
	public synchronized void removeClient(Thread thread) {
		list.remove(thread);
		System.out.println("Client 1�� ����. �� " + list.size() + "��");
	}
	
	// ��� Ŭ���̾�Ʈ���� ä�� ���� ����
	public synchronized void broadCasting(String str) {
		for(int i = 0; i < list.size(); i++) {
			ServerSocketThread thread = (ServerSocketThread)list.get(i);
			thread.sendMessage(str);
		}
	}
}