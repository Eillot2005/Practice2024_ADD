import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        List<Book> bookList=new LinkedList<Book>();
        String bookName[]={ "Java", "C++", "Python", "操作系统","计算机网络","数据结构","数据库" };
        double bookPrice[]={ 79.8, 69.8, 89.8, 79.8, 49.8, 39.8, 79.8 };
        Book book[]=new Book[bookName.length];
        for(int k=0;k<bookName.length;k++){
            book[k]=new Book();
            book[k].setName(bookName[k]);
            book[k].setPrice(bookPrice[k]);
            bookList.add(book[k]);
        }
        Book newBook=new Book();
        newBook.setName("C");
        newBook.setPrice(79.8);
        Collections.sort(bookList);//排序
        int m=-1;
        System.out.println("新书:"+newBook.getName()+"("+newBook.getPrice()+")与下列图书：");
        while((m=Collections.binarySearch(bookList,newBook,null))>=0){
            Book bk=bookList.get(m);
            System.out.println(bk.getName()+"("+bk.getPrice()+")");
            bookList.remove(m);
        }
        System.out.println("价格相同");
    }
}


















