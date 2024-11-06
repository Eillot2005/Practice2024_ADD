public class Check {
    public static void main(String[] args) {
        Machine machine = new Machine();
        String name[]={"苹果","炸药","西服","硫酸","手表","硫磺"};
        Goods goods[] = new Goods[name.length];
        for (int i = 0; i < name.length; i++) {
            goods[i] = new Goods();
            goods[i].setName(name[i]);
            if(i%2==0) {
                goods[i].setIsDanger(false);
                goods[i].setName(name[i]);
            }
            else {
                goods[i].setIsDanger(true);
                goods[i].setName(name[i]);
            }
        }
        for (int i = 0; i < name.length; i++) {
            try {
                machine.checkBag(goods[i]);
            } catch (DangerException e) {
                //代码2：e调用toShow方法
                //e.toShow();
                System.out.println(goods[i].getName() + "被禁止");
            }
        }
    }
}

/*
苹果不是危险品
危险品! 炸药被禁止
西服不是危险品
危险品! 硫酸被禁止
手表不是危险品
危险品! 硫磺被禁止
 */

//1. 是否可以将try-catch语句中的catch捕获的异常类型改为Exception? 为什么?
/*
可以，因为Exception是所有异常的父类，可以捕获所有异常。
 */
//2. 是否可以将try-catch语句中的catch捕获的异常类型改为java.io.IOException? 为什么?
/*
不可以，因为java.io.IOException是IOException类的父类，而DangerException类并不是IOException类的子类。
 */
//将代码2注释掉，再回答上述问题。
/*
1. 可以，因为Exception是所有异常的父类，可以捕获所有异常。
2. 不可以，因为java.io.IOException是IOException类的父类，而DangerException类并不是IOException类的子类。(java: 在相应的 try 语句主体中不能抛出异常错误java.io.IOException)
 */