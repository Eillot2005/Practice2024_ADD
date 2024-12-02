import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
public class ServerNumber {
    public static void main(String[] args) {
        ServerSocket server = null;
        ServerThread thread;
        Socket you = null;
        while (true) {
            try {
                server = new ServerSocket(4331);
            } catch (IOException e1) {
                System.out.println("正在监听");
            }
            try {
                you = server.accept();
                System.out.println("客户的地址：" + you.getInetAddress());
            } catch (IOException e1) {
                System.out.println("正在等待客户");
            }
            if (you != null) {
                new ServerThread(you).start();
            }
        }
    }
}
class ServerThread extends Thread {
    Socket socket;
    DataInputStream in=null;
    DataOutputStream out=null;
    ServerThread(Socket t) {
        socket = t;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
        }
    }
    public void run() {
        try{
            while (true){
                String str = in.readUTF();
                boolean boo=str.startsWith("Y")||str.startsWith("y");
                if(boo) {
                    out.writeUTF("给你一个1-100之间的随机数，请猜测这个数");
                    Random random = new Random();
                    int realNumber = random.nextInt(100) + 1;
                    handelCilentGuess(realNumber);
                    out.writeUTF("询问：想继续玩输入Y，否则输入N");
                }else{
                    return;
                }
            }
        }catch (IOException e){
        }
    }
    public void handelCilentGuess(int realNumber){
        while (true) {
            try{
                int cilentGuess = in.readInt();
                System.out.println(cilentGuess);
                if(cilentGuess>realNumber){
                    out.writeUTF("猜大了");
                }else if(cilentGuess<realNumber){
                    out.writeUTF("猜小了");
                }else{
                    out.writeUTF("猜对了");
                    return;
                }
            }catch (IOException e){
                System.out.println("客户已断开");
                return;
            }
        }
    }
}