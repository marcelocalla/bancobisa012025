package com.blog.demo.model.outDto;

import com.blog.demo.model.Author;
import com.blog.demo.model.Blog;
import com.blog.demo.model.ComentarioBlog;

import java.util.List;

public class ConsultaBlogDto {
    private Author author;
    private Blog blog;
    private List<ComentarioBlog> lComent;

    public ConsultaBlogDto() {
    }

    public ConsultaBlogDto(Author author, Blog blog, List<ComentarioBlog> lComent) {
        this.author = author;
        this.blog = blog;
        this.lComent = lComent;
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

    public List<ComentarioBlog> getlComent() {
        return lComent;
    }

    public void setlComent(List<ComentarioBlog> lComent) {
        this.lComent = lComent;
    }
}
