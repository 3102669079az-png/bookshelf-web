package com.bookshelf.controller;

import java.math.BigDecimal;

public class BookRequest {

    private String name;
    private String type;
    private BigDecimal price;
    private int pages;
    private Integer fileSize;

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    public Integer getFileSize() { return fileSize; }
    public void setFileSize(Integer fileSize) { this.fileSize = fileSize; }
}
