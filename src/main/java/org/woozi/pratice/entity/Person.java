package org.woozi.pratice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import org.woozi.pratice.jakarta.persistence.entity.Entity;
import org.woozi.pratice.jakarta.persistence.entity.GeneratedValue;
import org.woozi.pratice.jakarta.persistence.entity.GenerationType;
import org.woozi.pratice.jakarta.persistence.entity.Id;

import java.util.Objects;

@Table(name = "users")
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nick_name")
    private String name;

    @Column(name = "old")
    private Integer age;

    @Column(nullable = false)
    private String email;

    @Transient
    private Integer index;

    public Person() {
    }

    public Person(final Long id, final String name, final Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
