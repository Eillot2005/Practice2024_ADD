import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        //url类
        /*
        1.构造方法
        URL(String spec) 通过一个字符串形式的URL地址创建URL对象
        URL(String protocol, String host, int port, String file) 通过指定的协议、主机、端口和文件名创建URL对象
        2.常用方法
        String getProtocol() 获取URL的协议名
        String getHost() 获取URL的主机名
        int getPort() 获取URL的端口号
        String getFile() 获取URL的文件名
        String getPath() 获取URL的路径部分
        String getQuery() 获取URL的查询部分
        String getRef() 获取URL的锚点部分
        String getAuthority() 获取URL的权限部分
        String getUserInfo() 获取URL的用户信息部分
        URLConnection openConnection() 打开URL的连接
        URLConnection openConnection(Proxy proxy) 打开URL的连接，使用指定的代理服务器
        3.url对象调用
        InputStream openStream() 打开URL的连接并返回一个输入流
         */
        try {
            URL url = new URL("http://authserver.csuft.edu.cn/authserver/login?service=http%3A%2F%2Fehall.csuft.edu.cn%2Flogin");
            InputStream in = url.openStream();
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = in.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
            }
            in.close();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //获取地址
        /*
        1.获取Internet上主机的IP地址
        InetAddress address = InetAddress.getByName("www.baidu.com");
        2.获取本地主机的IP地址
        InetAddress address = InetAddress.getLocalHost();
         */
        try {
            InetAddress address = InetAddress.getByName("www.baidu.com");
            System.out.println(address.toString());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        //套接字
        /*
        1.是什么？
        套接字是网络通信的基本工具，是网络通信的端点，是网络通信的一种方式。
        2.端口号
        一个套接字由一个IP地址和一个端口号组成，IP地址用于标识网络上的主机，端口号用于标识主机上的应用程序。
         */
        //客户端套接字
        /*
        客户端套接字是指发起网络通信的一方，客户端套接字通过指定服务器的IP地址和端口号来连接服务器。
        1.构造方法
        Socket(String host, int port) 通过指定的主机名和端口号创建Socket对象
        2.常用方法
        InputStream getInputStream() 获取Socket的输入流
        OutputStream getOutputStream() 获取Socket的输出流
        void close() 关闭Socket
        getInputStream()和getOutputStream()方法分别返回Socket的输入流和输出流，通过这两个流可以进行网络通信。
         */
        //服务端套接字
        /*
        服务端套接字是指接收网络通信的一方，服务端套接字通过指定端口号来监听客户端的连接请求。
        1.构造方法
        ServerSocket(int port) 通过指定的端口号创建ServerSocket对象
        2.常用方法
        Socket accept() 接受客户端的连接请求
        void close() 关闭ServerSocket
        accept()方法用于接受客户端的连接请求，返回一个Socket对象，通过这个Socket对象可以进行网络通信。
         */
        //使用多线程技术
        /*
        1.创建一个ServerSocket对象
        2.调用ServerSocket对象的accept()方法接受客户端的连接请求，返回一个Socket对象
        3.创建一个线程对象，将Socket对象传递给线程对象
        4.启动线程对象
         */
        //CS模式
        /*
        cs模式是指客户端和服务器端之间的通信模式，客户端和服务器端之间通过套接字进行通信。
        1.客户端
          1.1创建一个Socket对象，指定服务器的IP地址和端口号
          1.2获取Socket对象的输出流，向服务器发送数据
          1.3获取Socket对象的输入流，接收服务器的数据
          1.4关闭Socket对象
        2.服务器端
          2.1创建一个ServerSocket对象，指定端口号
          2.2调用ServerSocket对象的accept()方法接受客户端的连接请求，返回一个Socket对象
          2.3获取Socket对象的输入流，接收客户端的数据
          2.4获取Socket对象的输出流，向客户端发送数据
          2.5关闭Socket对象
         */


        //UDP
        /*
        UDP是一种无连接的通信协议，通信双方不需要建立连接，直接发送数据包。
        1.发送数据包
        DatagramSocket socket = new DatagramSocket(); 创建一个DatagramSocket对象
        byte[] data = "Hello".getBytes(); 将字符串转换为字节数组
        InetAddress address = InetAddress.getByName("localhost"); 获取主机的IP地址
        DatagramPacket packet = new DatagramPacket(data, data.length, address, 8080); 创建一个DatagramPacket对象
        socket.send(packet); 发送数据包
        2.接收数据包
        DatagramSocket socket = new DatagramSocket(8080); 创建一个DatagramSocket对象，并指定端口号
        byte[] data = new byte[1024]; 创建一个字节数组
        DatagramPacket packet = new DatagramPacket(data, data.length); 创建一个DatagramPacket对象
        socket.receive(packet); 接收数据包
        String message = new String(packet.getData(), 0, packet.getLength()); 将字节数组转换为字符串
         */


        //Java远程调用(RMI)
        /*
        Java远程调用是指在不同的Java虚拟机之间进行方法调用，Java远程调用可以实现不同Java虚拟机之间的通信。
        1.创建一个远程接口
        2.创建一个远程实现类
        3.创建一个远程对象
        4.创建一个远程注册表
        5.将远程对象注册到远程注册表
        6.创建一个客户端程序
        7.从远程注册表中查找远程对象
        8.调用远程对象的方法
         */
    }
}