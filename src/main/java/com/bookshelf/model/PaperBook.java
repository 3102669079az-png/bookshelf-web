package com.bookshelf.model;

import java.math.BigDecimal;

public class PaperBook extends Book {

    public PaperBook(String name, BigDecimal price, int pages) {
        super(name, price, pages);
    }

    @Override
    public String getType() {
        return "纸质书";
    }
}