import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ClientGui extends JFrame implements ActionListener, Runnable{
	
	
	Container container = getContentPane();
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	JTextField textField = new JTextField();
	
	// for communicate
	Socket socket;
	PrintWriter out;
	BufferedReader in;
	String str; // message ����
	
	public ClientGui(String ip, int port) {
		
		// frame set
		setTitle("smwu chatting");
		setSize(550, 400);
		
		init();
		start();
		setVisible(true);
		
		// ��� �ʱ�ȭ
		initNet(ip, port);
		// ������ ip ���
		System.out.println("ip = " + ip);
	}	
	
	// ��� �ʱ�ȭ
	private void initNet(String ip, int port) {
		try {
			// ������ ���� �õ�
			socket = new Socket(ip, port);
			// ��ſ� input, output ����
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// true : auto flush ����
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (UnknownHostException e) {
			System.out.println("�ٸ� IP���� ������ �� �����ϴ�.");
		} catch (IOException e) {
			System.out.println("���� ����");
		}
		
		// ������ ����
		Thread thread = new Thread(this);
		thread.start();
	}
	
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("Center", scrollPane);
		container.add("South", textField);
	}
	
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		textField.addActionListener(this);
	}
	
	// ���� ���
	// �����κ��� ���޵� string �о, textArea�� ���
	@Override
	public void run() {
		while(true) {
			try {
				str = in.readLine();
				textArea.append(str + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// textField�� string �о�ͼ� ���� ����
		str = textField.getText();
		out.println(str);
		// ���� �� textField �ʱ�ȭ
		textField.setText("");
	}
}