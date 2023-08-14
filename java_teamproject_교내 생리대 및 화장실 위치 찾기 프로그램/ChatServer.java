import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	ServerSocket serverSocket;
	Socket socket;
	List<Thread> list;		// ServerSocketThread 객체 저장
	
	public ChatServer() {
		list = new ArrayList<Thread>();
		System.out.println("서버가 시작되었습니다.");
	}
	
	public void giveAndTake() {
		try {
			serverSocket = new ServerSocket(5420);		// 소켓 접속 대기
			serverSocket.setReuseAddress(true); 		// server socket이 port를 다시 사용함
			
			while(true) {
				socket = serverSocket.accept();			// accept -> 1. 소켓 접속 대기 2. 소켓 접속 허락
				ServerSocketThread thread = new ServerSocketThread(this, socket);	// this -> ChatServer 자신
				addClient(thread);		// 리스트에 쓰레드 객체 저장
				thread.start();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	// synchronized: 쓰레드 간의 공유데이터 사용 금지
	// 클라이언트 입장 시 호출 
	// 리스트에 해당 클라이언트 쓰레드 저장
	private synchronized void addClient(ServerSocketThread thread) {
		// 리스트에 ServerSocketThread 객체 저장
		list.add(thread);
		System.out.println("Client 1명 입장. 총 " + list.size() + "명");
	}		
	
	// 클라이언트가 퇴장 시 호출
	// addClient에서 저장했던 리스트에서 해당 클라이언트 쓰레드 제거
	public synchronized void removeClient(Thread thread) {
		list.remove(thread);
		System.out.println("Client 1명 퇴장. 총 " + list.size() + "명");
	}
	
	// 모든 클라이언트에게 채팅 내용 전달
	public synchronized void broadCasting(String str) {
		for(int i = 0; i < list.size(); i++) {
			ServerSocketThread thread = (ServerSocketThread)list.get(i);
			thread.sendMessage(str);
		}
	}
}