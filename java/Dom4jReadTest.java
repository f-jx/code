import java.io.*;
import java.util.*;

import javax.print.attribute.Attribute;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Dom4jReadTest {
    public static void main(String[] args) {
        // 创建SAXReader的对象
        SAXReader reader = new SAXReader();
        try {
            // 加载books.xml文件,获取对象
            Document doc = reader.read(new File("books.xml"));
            // 获取根节点
            Element books = doc.getRootElement();
            // 通过elementIterator方法获取迭代器
            Iterator it = books.elementIterator();
            while (it.hasNext()) {
                // 遍历迭代器,获取根节点中的信息
                Element book = (Element) it.next();
                // 获取book的属性名以及属性值存入List中
                List<Attribute> bookAttrs = book.attributes();
                // 用for循环遍历获取的属性名和属性值
                for (Attribute attr : bookAttrs) {
                    if (attr.getName().equals("id")) {
                        System.out.println("id:" + attr.getValue());
                    }
                }
            }
            Iterator itt = book.elementIterator();
            while (itt.hasNext()) {
                Element bookChild = (Element) itt.next();
                if (bookChild.getName().equals("title")) {
                    System.out.println("title:" + bookChild.getStringValue());
                }
                if (bookChild.getName().equals("author")) {
                    System.out.println("author:" + bookChild.getStringValue());
                }
                if (bookChild.getName().equals("price")) {
                    System.out.println("price:" + bookChild.getStringValue());
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}