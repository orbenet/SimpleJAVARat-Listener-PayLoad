import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class AndroidRatServer implements Runnable {
    MainActivity ma;
    ServerSocket ss;
    PrintWriter pw;
    BufferedReader br;
    Socket socket;
    String nextToSend;
    public ratServer(MainActivity _ma) {
        ma = _ma;
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            ss = new ServerSocket(27555);
            socket = ss.accept();
            pw = new PrintWriter(socket.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            INPUTRATSERVER irs = new INPUTRATSERVER();
            Thread thread = new Thread(irs);
            thread.start();
            while (!socket.isClosed()) {
                final String s = br.readLine();
                ma.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView tv = new TextView(ma.getApplicationContext());
                            tv.setText(s);
                            ma.ll.addView(tv);

                    }
                });
            }
        } catch (IOException e){

        }
    }

    private class INPUTRATSERVER implements Runnable {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            while (!socket.isClosed()) {
                if (nextToSend!=null) {
                    pw.println(nextToSend);
                    pw.flush();
                    nextToSend = null;
                    ma.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ma.scrolldisplay.fullScroll(TextView.FOCUS_DOWN);
                        }
                    });
                }
            }
        }
    }
}
