package com.xml.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author: 18040
 * @date: 2023/2/10 22:06
 */
public class Dom4jTest {

//    @Test
//    public void test1() throws DocumentException {
//        // 创建一个SAXReader输入流去读取xml配置文件，生产document对象
//        SAXReader saxReader = new SAXReader();
//        Document document = saxReader.read("src/main/webapp/xml/src/books.xml");
//
//        System.out.println(document);
//
//    }


    /**
     * 读取books.xml文件生成Book类
     */
    @Test
    public void test2() throws DocumentException {
        // 1.读取books.xml文件
        SAXReader reader = new SAXReader();

        // junit测试中，相对路径从模块名开始
        Document document = reader.read("src/main/webapp/xml/src/books.xml");
//        System.out.println(document);
        // 2.通过Document对象获取根元素
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement.asXML());
        // 3.通过根元素获取book标签对象
        // element()和elements() 都是通过标签名查找子元素
        List<Element> books = rootElement.elements("books");
        System.out.println(books);
        // 4.遍历，处理每个book标签转换为Book类
        for (Element book : books) {
            // asXML() 把标签对象转换为标签字符串
            System.out.println(book.asXML());
            Element nameElement = book.element("name");
            System.out.println(nameElement.asXML());
        }
    }

}
