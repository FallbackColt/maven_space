package com.spring5.test.collectiontype;

import java.util.List;

/**
 * @author: 18040
 * @date: 2023/4/7 21:44
 */
public class Book {

    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Book{" +
                "list=" + list +
                '}';
    }

}
