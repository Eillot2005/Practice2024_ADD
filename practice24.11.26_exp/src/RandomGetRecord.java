import java.util.Random;
import java.util.Vector;

public class RandomGetRecord {
    public static int[] getRandomNumber(int max,int amount){
        Vector<Integer> v=new Vector<Integer>();
        for (int i=0;i<max;i++){
            v.add(i);
        }
        int[] result=new int[amount];
        while (amount>0) {
            int index = new Random().nextInt(v.size());
            int m = v.elementAt(index);
            v.removeElementAt(index);
            result[amount - 1] = m;
            amount--;
        }
        return result;
    }
}
