package com.example.demo.book;

import com.example.demo.student.Student;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "Book")
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(
            strategy = IDENTITY
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;
    @Column
    private BookStatus status = BookStatus.AVAILABLE;

    @ManyToOne
    @JoinColumn(
            name = "student_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "student_book_fk"
            )
    )
    private Student student;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public Book() {
    }

    public Book(String name,
                LocalDateTime createdAt) {
        this.createdAt = createdAt;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Student getStudent() {
        return student;
    }

    public BookStatus getBookStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", status=" + status +
                ", bookName='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}

