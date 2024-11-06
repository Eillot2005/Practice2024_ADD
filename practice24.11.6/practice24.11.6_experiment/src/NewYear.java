class MobileShop
{
    //代码1：使用内部类InnerPurchaseMoney声明对象PurchaseMoney1
    InnerPurchaseMoney PurchaseMoney1;
    //代码2：使用内部类InnerPurchaseMoney声明对象PurchaseMoney2
    InnerPurchaseMoney PurchaseMoney2;
    private int mobileAmount;
    MobileShop()
    {
        //代码3：创造价值为20000的PurchaseMoney1对象
        PurchaseMoney1 = new InnerPurchaseMoney(20000);
        //代码4：创造价值为10000的PurchaseMoney2对象
        PurchaseMoney2 = new InnerPurchaseMoney(10000);
    }
    void setMobileAmount(int m)
    {
        mobileAmount = m;
    }
    int getMobileAmount()
    {
        return mobileAmount;
    }
    class InnerPurchaseMoney
    {
        int moneyValue;
        InnerPurchaseMoney(int m)
        {
            moneyValue = m;
        }
        void buyMobile()
        {
            if(moneyValue>=20000)
            {
                mobileAmount-=6;
                System.out.println("用价值"+moneyValue+"的内部购物券买了6部手机");
            }
            else if(moneyValue>=10000&&moneyValue<20000)
            {
                mobileAmount-=3;
                System.out.println("用价值"+moneyValue+"的内部购物券买了3部手机");
            }
        }
    }
}
public class NewYear
{
    public static void main(String[] args)
    {
        MobileShop shop = new MobileShop();
        shop.setMobileAmount(30);
        System.out.println("目前手机专卖店有"+shop.getMobileAmount()+"部手机");
        shop.PurchaseMoney1.buyMobile();
        shop.PurchaseMoney2.buyMobile();
        System.out.println("目前手机专卖店有"+shop.getMobileAmount()+"部手机");
    }
}

/*
目前手机专卖店有30部手机
用价值20000的内部购物券买了6部手机
用价值10000的内部购物券买了3部手机
目前手机专卖店有21部手机
 */
//参照本实验,用内部类模拟一个实际问题
//类似的问题可以是：一个学校多个学生，该学生的总成绩
//请用内部类模拟这个问题
//代码实现如下：
/*
class School{
    InnerStudent student1;
    InnerStudent student2;
    School(){
        student1 = new InnerStudent(100);
        student2 = new InnerStudent(99);
    }
    class InnerStudent{
        int score;
        InnerStudent(int s){
            score = s;
        }
        void totalScore(){
            System.out.println("学生的总分是"+score);
        }
    }
}

输出:
学生1的总分是100
学生2的总分是99
 */
