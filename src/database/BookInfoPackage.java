package database;

import java.io.FileInputStream;

public final class BookInfoPackage {

    private String id = null;
    private String name = null;
    private String author = null;
    private String publisher = null;
    private FileInputStream front = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public FileInputStream getFront() {
        return front;
    }

    public void setFront(FileInputStream front) {
        this.front = front;
    }
}
