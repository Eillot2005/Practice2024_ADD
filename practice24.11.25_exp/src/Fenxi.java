import java.util.*;

public class Fenxi {
    public static double getTotalScore(String s){
        Scanner scanner=new Scanner(s);
        scanner.useDelimiter("[^0123456789.]+");
        double totalScore=0;
        while(scanner.hasNext()){
            try{
                double score=scanner.nextDouble();
                totalScore+=score;
            }
            catch (InputMismatchException exp){
                String t=scanner.next();
            }
        }
        return totalScore;
    }
    public static int count(String s){
        Scanner scanner=new Scanner(s);
        scanner.useDelimiter("[^0123456789.]+");
        int count=0;
        while(scanner.hasNext()){
            try{
                double score=scanner.nextDouble();
                count++;
            }
            catch (InputMismatchException exp){
                String t=scanner.next();
            }
        }
        return count;
    }
}
