import java.util.*;

public class CollectionTest {
    public static void main(String args[]) {
        // 小明打算学Java，买了三本书
        Book bookA = new Book("Java核心技术（卷一）", 88.9);
        Book bookB = new Book("Java核心技术（卷二）", 88.6);
        Book bookC = new Book("Java编程思想", 99.0);
        // 他想了想，放哪呢？到处放怕之后会找不到，放书架以后书变多了找起来就很麻烦
        // 于是他找了个管家
        Map<String, Book> bookMap = new HashMap<>(3);
        // 然后跟管家说，这三本书先放你这了，要用的时候找你拿
        bookMap.put(bookA.getName(), bookA);
        bookMap.put(bookB.getName(), bookB);
        bookMap.put(bookC.getName(), bookC);
        // 勤劳的管家兢兢业业的保存好了三本书
        // 小明回到家，想检查一下管家老不老实
        // “管家，把Java核心技术（卷一）给我拿过来”
        Book bookD = bookMap.get("Java核心技术（卷一）");
        // 他查看了一下这本书的信息并跟原来的信息校验了一番
        System.out.println(bookD);
        System.out.println(bookA.equals(bookD));
        // 并同样校验了另外两本书
        Book bookE = bookMap.get("Java核心技术（卷二）");
        System.out.println(bookE);
        System.out.println(bookB.equals(bookE));
        Book bookF = bookMap.get("Java编程思想");
        System.out.println(bookF);
        System.out.println(bookC.equals(bookF));
        // 嗯，看来管家没有玩花样，还是原来的书，晚饭给他加个蛋
    }
}

class Book {
    private String name;
    private Double price;

    public Book(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" + "name='" + name + '\'' + ", price=" + price + '}';
    }
}
