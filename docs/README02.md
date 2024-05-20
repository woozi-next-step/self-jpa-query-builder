# 요구사항 1 - 아래 정보를 바탕으로 create 쿼리 만들어보기

```java
@Entity
public class Person {

    @Id
    private Long id;

    private String name;

    private Integer age;

}
```
- [ ] @Entity 선언 클래스를 바탕으로 create query 를 만든다.  
  - [ ] 필드 정보를 일어와서 사용할 수 있다. 
  - [ ] @Id 가 있는 필드는 pk 로 만든다.


# 요구사항 2 - 추가된 정보를 통해 create 쿼리 만들어보기
```java
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

}
```
- [ ] strategy = GenerationType.IDENTITY 를 이용한 PK statement 조정
- [ ] @Column(name) 을 이용한 column 이름 정보 조정
- [ ] @Column(nullable) 를 이용한 not null 제약조건 추가

# 요구사항 3 - 추가된 정보를 통해 create 쿼리 만들어보기2
```java
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

}
```
- [ ] @Table(name) 을 통한 테이블명 조정
- [ ] @Transient 을 이용한 column 맵핑 무시


# 요구사항 4 - 정보를 바탕으로 drop 쿼리 만들어보기
- [ ] @Table(name) 을 고려해 drop 쿼리 작성