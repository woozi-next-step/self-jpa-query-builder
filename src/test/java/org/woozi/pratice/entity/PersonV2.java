package org.woozi.pratice.entity;

import org.woozi.pratice.jakarta.persistence.entity.GenerationType;
import org.woozi.pratice.jakarta.persistence.entity.annotation.*;

import java.util.Objects;

@Entity
public class PersonV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nick_name")
    private String name;

    @Column(name = "old")
    private Integer age;

    @Column(nullable = false)
    private String email;

    public PersonV2() {
    }

    public PersonV2(final Long id, final String name, final Integer age, final String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PersonV2 personV3 = (PersonV2) o;
        return Objects.equals(id, personV3.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
