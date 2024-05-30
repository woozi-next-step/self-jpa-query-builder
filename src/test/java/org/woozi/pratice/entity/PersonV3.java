package org.woozi.pratice.entity;

import org.woozi.pratice.jakarta.persistence.entity.*;
import org.woozi.pratice.jakarta.persistence.entity.annotation.*;

import java.util.Objects;

@Table(name = "users")
@Entity
public class PersonV3 {

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

    public PersonV3() {
    }

    public PersonV3(final Long id, final String name, final Integer age) {
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

    public String getEmail() {
        return email;
    }

    public Integer getIndex() {
        return index;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PersonV3 personV3 = (PersonV3) o;
        return Objects.equals(id, personV3.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
