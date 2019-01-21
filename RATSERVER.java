import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class RATSERVER {
	ServerSocket ss;
	PrintWriter pw;
	BufferedReader br;
	Socket socket;
	public RATSERVER() {
		try {
			ss = new ServerSocket(27555);
			socket = ss.accept();
			pw = new PrintWriter(socket.getOutputStream(),true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			INPUTRATSERVER irs = new INPUTRATSERVER();
			Thread thread = new Thread(irs);
			thread.start();
			while (!socket.isClosed()) {
				System.out.println(br.readLine());
			}
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	private class INPUTRATSERVER implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Scanner scan = new Scanner(System.in);
			while(!socket.isClosed()) {
				if (scan.hasNext()) {
					pw.println(scan.nextLine());
					pw.flush();
				}
			}
			scan.close();
		}
	}
	public static void main(String[] args) {
		new RATSERVER();
	}
}
