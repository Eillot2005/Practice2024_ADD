public class Machine {
    public void checkBag(Goods goods) throws DangerException {//throws的意思是:这个方法可能会抛出异常
        if (goods.isDanger) {
            DangerException danger = new DangerException();
            //代码1：抛出异常
            throw danger;
        }
        else {
            System.out.println(goods.getName() + "不是危险品");
        }
    }
}
