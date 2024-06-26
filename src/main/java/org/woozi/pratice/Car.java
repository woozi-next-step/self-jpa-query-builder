package org.woozi.pratice;

import java.util.Objects;

public final class Car {
    private String name;
    private int price;

    public Car() {
    }

    public Car(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    @PrintView
    public void printView() {
        System.out.println("자동차 정보를 출력 합니다.");
    }

    public String testGetName() {
        return "name : " + name;
    }

    public String testGetPrice() {
        return "price : " + price;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Car car = (Car) o;
        return price == car.price && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
