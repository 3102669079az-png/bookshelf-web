package com.bookshelf.model;

import java.math.BigDecimal;

public class EBook extends Book {

    private final int fileSize;

    public EBook(String name, BigDecimal price, int pages, int fileSize) {
        super(name, price, pages);
        this.fileSize = fileSize;
    }

    @Override
    public String getType() {
        return "电子书";
    }

    public int getFileSize() {
        return fileSize;
    }

    @Override
    public String toString() {
        return super.toString() + "," + fileSize + "MB";
    }
}