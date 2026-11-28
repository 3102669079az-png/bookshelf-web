package com.bookshelf.controller;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class BookRequest {

    @NotBlank(message = "书名不能为空")
    private String name;

    @NotBlank(message = "类型不能为空")
    @Pattern(regexp ="PAPER|EBOOK", message = "类型只能是 PAPER 或 EBOOK")
    private String type;

    @NotNull(message = "价格不能为空")
    @DecimalMin(value = "0.00", message = "价格不能为负")
    private BigDecimal price;

    @Min(value = 1, message = "页数至少为一")
    private int pages;

    @Min(value = 1,message = "文件大小至少为 1MB")
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
