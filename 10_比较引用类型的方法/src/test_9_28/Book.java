package test_9_28;

import java.util.Comparator;

/**
 * 1.自然顺序
 * isbn从大到小
 * 2.非自然顺序
 * 按价格由小到大
 */

class BookPriceComparator implements Comparator<Book>{

    private boolean asc = true;

    //设置升序还是降序（默认true升序）
    public void setAsc(boolean asc) {
        this.asc = asc;
    }

    @Override
    public int compare(Book o1, Book o2) {
        /*
         * true表示
         */
        if(!asc){
            return o2.price - o1.price;
        }
        return o1.price - o2.price;
    }
}
public class Book implements Comparable<Book>{
    public String isbn;
    public String writer;
    public String name;
    public int price;
    public int sells;
    public int comment;

    public Book(String isbn, String writer, String name, int price, int sells, int comment) {
        this.isbn = isbn;
        this.writer = writer;
        this.name = name;
        this.price = price;
        this.sells = sells;
        this.comment = comment;
    }


    @Override
    public String toString() {
        return String.format("书名：%s 作者：%s",this.name,this.writer);
    }

    @Override
    public int compareTo(Book o) {
        return this.isbn.compareTo(o.isbn);
    }


    //自然算法排序
    public static void quickWithFuture(Book[] book,int low,int high){
        int i = low;
        int j = high;
        Book key = book[low];
        while(i < j){
            while(i < j && book[j].compareTo(key) >= 0){
                j--;
            }
            if (i < j) {
                book[i++] = book[j];
            }
            while(i < j && book[i].compareTo(key) <= 0){
                i++;
            }
            if(i < j){
                book[j--] = book[i];
            }
        }
        //记得填坑
        book[i] = key;
        if(low < i - 1){
            quickWithFuture(book,low,i-1);
        }
        if(high > i + 1){
            quickWithFuture(book,i+1,high);
        }
    }

    //自然算法排序
    public static void quick(Book[] book,int low,int high,BookPriceComparator bp){
        int i = low;
        int j = high;
        Book key = book[low];
        while(i < j){
            while(i < j && bp.compare(book[j],key) >= 0){
                j--;
            }
            if (i < j) {
                book[i++] = book[j];
            }
            while(i < j && bp.compare(book[i],key) <= 0){
                i++;
            }
            if(i < j){
                book[j--] = book[i];
            }
        }
        //记得填坑
        book[i] = key;
        if(low < i - 1){
            quick(book,low,i-1,bp);
        }
        if(high > i + 1){
            quick(book,i+1,high,bp);
        }
    }

    public static void main(String[] args) {
        Book[] book = new Book[]{new Book("1","xiaoboge","小博哥漂流记",20,10000,999),
                new Book("3","fangfang","方方漂流记",15,1000,9),
                new Book("2","阿狗","阿狗漂流记",16,100,99)};

//        //自然排序
//        quickWithFuture(book,0,book.length - 1);
        //非自然排序
        BookPriceComparator bp = new BookPriceComparator();
        //设置按价格降序排序
        bp.setAsc(false);
        quick(book,0,book.length-1,bp);
        for(Book b:book){
            System.out.println(b);
        }
    }
}
