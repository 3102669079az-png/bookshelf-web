package com.bookshelf.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Book {

    protected long id;
    protected String name;
    protected BigDecimal price;
    protected int pages;

    protected Book(String name, BigDecimal price, int pages) {
        if (name == null || name.isBlank()) {
            throw new BookException("书名不能为空");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new BookException("价格不能为负数: " + price);
        }
        if (pages <= 0) {
            throw new BookException("页数必须大于 0: " + pages);
        }
        this.name = name;
        this.price = price;
        this.pages = pages;
    }

    public abstract String getType();

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
    public int getPages() { return pages; }

    @Override
    public String toString() {
        return name + "," + price.setScale(2, RoundingMode.HALF_UP) + "元," + pages + "页";
    }
}