class FinalTeamMain 
{
	public static void main(String[] args) 
	{	
		ChatServer server = new ChatServer();
		server.giveAndTake();

		//실행(RUN)을 두 번 해주셔야 프로그램이 실행됩니다.
		MainFrame main = new MainFrame("5조 기말프로젝트: FlowMate");
	}
}
