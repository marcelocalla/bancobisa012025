package com.blog.demo.model.inputDto;

import com.blog.demo.model.Author;
import com.blog.demo.model.Blog;

import java.util.Date;

public class inputBlogGralDto {
    private Author author;
    private Blog blog;
    public inputBlogGralDto() {
    }

    public inputBlogGralDto(Author author, Blog blog) {
        this.author = author;
        this.blog = blog;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    public Blog getBlog() {
        return blog;
    }
    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
