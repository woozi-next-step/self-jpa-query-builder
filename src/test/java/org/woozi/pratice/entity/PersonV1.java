package org.woozi.pratice.entity;

import org.woozi.pratice.jakarta.persistence.entity.annotation.Entity;
import org.woozi.pratice.jakarta.persistence.entity.annotation.Id;

import java.util.Objects;

@Entity
public class PersonV1 {

    @Id
    private Long id;

    private String name;

    private Integer age;

    public PersonV1() {
    }

    public PersonV1(final Long id, final String name, final Integer age) {
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
        final PersonV1 personV3 = (PersonV1) o;
        return Objects.equals(id, personV3.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
