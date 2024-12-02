public class Book implements Comparable {
    double price;
    String name;
    public void setPrice(double c){
        price=c;
    }
    public double getPrice(){
        return price;
    }
    public void setName(String n){
        name=n;
    }
    public String getName(){
        return name;
    }
    public int compareTo(Object o){
        Book b=(Book)o;
        int difference=(int)(this.getPrice()-b.getPrice())*10000;
        return difference;
    }
}
