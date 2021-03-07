package adeste.dao;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COURSES")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID")
    private int id;

    private String name;
    private LocalDate first;
    private LocalDate last;

    public Course() {
    }

    public Course(String name, LocalDate first, LocalDate last) {
        this.name = name;
        this.first = first;
        this.last = last;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFirst() {
        return first;
    }

    public void setFirst(LocalDate first) {
        this.first = first;
    }

    public LocalDate getLast() {
        return last;
    }

    public void setLast(LocalDate last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", first=" + first + ", last=" + last + "]";
    }
}
