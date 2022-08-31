package com.kuang.pojo;

public class Books {
    @Override
    public String toString() {
        return "Books{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", bookcounts=" + bookcounts +
                ", detail='" + detail + '\'' +
                '}';
    }

    public Books() {
    }

    public Books(Integer bookid, String bookname, Integer bookcounts, String detail) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.bookcounts = bookcounts;
        this.detail = detail;
    }

    private Integer bookid;

    private String bookname;

    private Integer bookcounts;

    private String detail;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public Integer getBookcounts() {
        return bookcounts;
    }

    public void setBookcounts(Integer bookcounts) {
        this.bookcounts = bookcounts;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}