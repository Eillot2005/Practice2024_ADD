import java.io.*;

public class AnalysisResult {
    public static void main(String[] args) {
        File fRead=new File("score.txt");
        File fWrite=new File("scoreAnalysis.txt");
        try{
            Writer out=new FileWriter(fWrite,true);
            BufferedWriter bufferedWriter=new BufferedWriter(out);
            Reader in=new FileReader(fRead);
            BufferedReader bufferedReader=new BufferedReader(in);
            String str=null;
            while((str=bufferedReader.readLine())!=null){
                double totalScore=Fenxi.getTotalScore(str);
                int count=Fenxi.count(str);
                str=str+"总分:"+totalScore+" 平均分:"+totalScore/count;
                System.out.println(str);
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.close();
        }
        catch (IOException e){
            System.out.println(e.toString());
        }
    }
}

//实验练习：
//1）改进程序，使能输出每个学生的平均分。
//2)现有如下goods.txt文件，文件内容如下：品名:电视，length:102cm，width:89cm，height:56cm 读取文件内容，计算体积，并输出到文件中。
/*
代码如下：
import java.io.*;
import java.util.regex.*;

public class CalculateVolume {
    public static void main(String[] args) {
        // 输入文件名
        String inputFile = "goods.txt";
        // 输出文件名
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // 读取文件内容
            String line;
            while ((line = reader.readLine()) != null) {
                // 提取数据
                String productName = extractValue(line, "品名:(.*?)[，,]");
                int length = extractNumber(line, "length:(\\d+)cm");
                int width = extractNumber(line, "width:(\\d+)cm");
                int height = extractNumber(line, "height:(\\d+)cm");

                // 计算体积
                int volume = length * width * height;

                // 写入输出文件
                writer.write("品名: " + productName + "，体积: " + volume + " 立方厘米");
                writer.newLine();
            }

            System.out.println("体积计算完成，结果已写入到 " + outputFile);
        } catch (IOException e) {
            System.err.println("文件处理时发生错误: " + e.getMessage());
        }
    }

    // 提取字符串中的某个值
    private static String extractValue(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "未知";
    }

    // 提取字符串中的数字
    private static int extractNumber(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }
}
 */


