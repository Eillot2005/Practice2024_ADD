import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;


public class CilentGuess {
    public static <IntputStream> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Socket mySocket = null;
        DataInputStream inData=null;
        DataOutputStream outData=null;
        Thread thread;
        ReadNumber readNumber=null;
        try{
            mySocket=new Socket();
            readNumber=new ReadNumber();
            thread=new Thread(readNumber);
            System.out.print("请输入服务器的IP：");
            String IP=scanner.nextLine();
            System.out.println("请输入服务器的端口：");
            int port=scanner.nextInt();
            if(mySocket.isConnected()){
                System.out.println("连接成功");
            }else{
                InetAddress address=InetAddress.getByName(IP);//获取IP地址
                InetSocketAddress socketAddress=new InetSocketAddress(address,port);//获取端口
                mySocket.connect(socketAddress);//连接服务器
                IntputStream in= (IntputStream) mySocket.getInputStream();
                OutputStream out=mySocket.getOutputStream();
                inData = new DataInputStream((InputStream) in);
                outData = new DataOutputStream(out);
                readNumber.setDataInputStream(inData);
                readNumber.setDataOutputStream(outData);
                thread.start();
            }
        }
        catch (Exception e){
            System.out.println("服务器已断开");
        }
    }
}
class ReadNumber implements Runnable {
    Scanner scanner = new Scanner(System.in);
    DataInputStream in;
    DataOutputStream out;
    public void setDataInputStream(DataInputStream in){
        this.in=in;
    }
    public void setDataOutputStream(DataOutputStream out){
        this.out=out;
    }
    public void run() {
        try {
            out.writeUTF("Y");//发送一个Y给服务器
            while (true) {
                String str = in.readUTF();//读取服务器发送的数据
                System.out.println(str);
                if(!str.startsWith("询问")){
                    if(str.startsWith("猜对了")){
                        continue;
                    }
                    System.out.println("好的,我输入猜测：");
                    int myGuess = scanner.nextInt();
                    String enter = scanner.nextLine();
                    out.writeInt(myGuess);
                }
                else{
                    System.out.println("好的,我输入Y或N：");
                    String myAnswer = scanner.nextLine();
                    out.writeUTF(myAnswer);
                }
            }
        } catch (Exception e) {
            System.out.println("服务器已断开");
        }
    }
}
