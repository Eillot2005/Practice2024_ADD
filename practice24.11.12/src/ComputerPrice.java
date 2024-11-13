import java.util.InputMismatchException;
import java.util.Scanner;

public class ComputerPrice {
    public static void main(String[] args) {
        String menu="北京烤鸭:189元 西芹炒肉:12.9元 酸菜鱼:69元 铁板牛柳:32元";
        Scanner scanner = new Scanner(menu);//代码1:Scanner类创建对象scanner,将menu作为参数传入
        String regex = "[^0123456789.]+";
        scanner.useDelimiter(regex);//代码2:将regex作为参数传入
        double sum = 0;
        while (scanner.hasNext()) {
            try {
                double price = scanner.nextDouble();//代码3:scanner调用nextDouble()返回数字型单词
                sum += price;
                System.out.println(price);
            } catch (InputMismatchException exp) {
                String t = scanner.next();
            }
        }
        System.out.println("菜单总价格:" + sum);
        String men="中央电视台:www.cctv.com 清华大学:http//www.tsinghua.edu.cn";
        Scanner scanne = new Scanner(men);
        String rege = "[^(http//|www)\56?\\w+\56{1}\\w+\56{1}\\p{Alpha}]+";
        scanner.useDelimiter(rege);
        while (scanne.hasNext()) {
            System.out.println(scanne.next());
        }
    }
}

//输出结果
/*
189.0
12.9
69.0
32.0
菜单总价格:302.9
 */
//1.让Scanner类的实例使用正则表达式:
/*
String regex = "[^(http//|www)\56?\\w+\56{1}\\w+\56{1}\\p{Alpha}]+";
作为分格标记,解析出字符串:
"中央电视台:www.cctv.com 清华大学:http//www.tsinghua.edu.cn"
中的全部网址链接地址。
 */
/*
String men="中央电视台:www.cctv.com 清华大学:http//www.tsinghua.edu.cn";
Scanner scanne = new Scanner(men);
String rege = "[^(http//|www)\56?\\w+\56{1}\\w+\56{1}\\p{Alpha}]+";
scanner.useDelimiter(rege);
while (scanne.hasNext()) {
    System.out.println(scanne.next());
 */
/*
中央电视台:www.cctv.com
清华大学:http//www.tsinghua.edu.cn
 */
