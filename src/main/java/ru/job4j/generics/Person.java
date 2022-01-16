package ru.job4j.generics;

import java.util.Date;
import java.util.Objects;

/**
 * @author Artem Polshchak on 23.12.2021.
 * @project job4j_design 0. Что такое обобщенные типы (generics) [#4952]
 */
public class Person {
    private String name;
    private int age;
    private Date birthday;

    public Person(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return getAge() == person.getAge() && Objects.equals(getName(), person.getName()) && Objects.equals(getBirthday(), person.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getBirthday());
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name
                + '\'' + ", age=" + age
                + ", birthday=" + birthday + '}';
    }
}
