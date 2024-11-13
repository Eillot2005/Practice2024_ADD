public class FindMess {
    public static void main(String[] args) {
        String mess = "姓名:张三 出生日期:1989.10.16。 个人网站:http://www.zhang.com。" +
                "身高:185 cm,体重:72 kg";
        //代码1：调用indexOf方法查找第一个冒号的位置
        int index = mess.indexOf(":");
        String name = mess.substring(index + 1);
        if (name.startsWith("张")) {
            System.out.println("简历中的姓名姓\"张\"");
        }
        //代码2：调用indexOf方法查找第二个冒号的位置
        index = mess.indexOf(":", index + 1);
        String date = mess.substring(index + 1, index + 11);
        System.out.println(date);
        index = mess.indexOf(":", index + 1);
        //返回字符串首次出现身高的位置
        int heightPosition = mess.indexOf("身高");
        String personNet = mess.substring(index + 1, heightPosition - 1);
        System.out.println(personNet);
        //返回字符串身高后面冒号的位置
        index=mess.indexOf(":",heightPosition);
        int cmPosition = mess.indexOf("cm");
        String height = mess.substring(index + 1, cmPosition);
        height = height.trim();
        int h=Integer.parseInt(height);
        if (h >= 180) {
            System.out.println("简历中的升高"+height+"大于或等于180cm");
        }
        else {
            System.out.println("简历中的升高"+height+"小于180cm");
        }
        //返回字符串最后一个冒号的位置
        index=mess.lastIndexOf(":");
        int kgPosition = mess.indexOf("kg");
        String weight = mess.substring(index + 1, kgPosition);
        weight = weight.trim();
        int w=Integer.parseInt(weight);
        if (w >= 75) {
            System.out.println("简历中的体重"+weight+"大于或等于75kg");
        }
        else {
            System.out.println("简历中的体重"+weight+"小于75kg");
        }
        String str1=new String("ABCABC"),
                str2=null,
                str3=null,
                str4=null;
        str2=str1.replaceAll("A","First");
        str3=str2.replaceAll("B","Second");
        str4=str3.replaceAll("C","Third");
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(Long.toBinaryString(12345));
        System.out.println(Long.toOctalString(12345));
        System.out.println(Long.toHexString(12345));
    }
}

//输出结果：
/*
简历中的姓名姓"张"
1989.10.16
http://www.zhang.com
简历中的升高185大于或等于180cm
简历中的体重72大于或等于75kg
 */

//1.在程序的合适位置插入如下代码，注意输出的结果
/*
String str1=new String("ABCABC"),
       str2=null,
       str3=null,
       str4=null;
str2=str1.replaceAll("A","First");
str3=str2.replaceAll("B","Second");
str4=str3.replaceAll("C","Third");
System.out.println(str1);
System.out.println(str2);
System.out.println(str3);
System.out.println(str4);
 */
/*
ABCABC
FirstBCFirstBC
FirstSecondCFirstSecondC
FirstSecondThirdFirstSecondThird
 */
//2.可以使用Long类中下列的static方法得到整数的各种进制的字符串表示形式
/*
public static String toBinaryString(long i)：返回i的二进制表示形式
public static String toHexString(long i)：返回i的十六进制表示形式
public static String toOctalString(long i)：返回i的八进制表示形式
public static String toString(long i, int p)：返回i的p进制表示形式
请在适当位置插入代码，输出整数12345的二进制、八进制、十六进制表示形式
 */
/*
System.out.println(Long.toBinaryString(12345));
System.out.println(Long.toOctalString(12345));
System.out.println(Long.toHexString(12345));
 */
/*
11000000111001
30071
3039
 */