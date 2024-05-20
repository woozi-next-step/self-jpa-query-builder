package org.woozi.pratice;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ReflectionTest {

    final Class<Car> carClass = Car.class;

    @Test
    void 클래스명를_가져온다() {
        final String name = carClass.getName();

        assertThat(name).isEqualTo("org.woozi.pratice.Car");
    }

    @Test
    void 필드명을_가져온다() {
        final Set<String> fieldNames = Arrays.stream(carClass.getDeclaredFields())
                .map(Field::getName)
                .collect(Collectors.toSet());

        assertThat(fieldNames).containsExactlyInAnyOrder("name", "price");
    }

    @Test
    void 생성자정보를_가져온다() {
        final Set<Integer> constructorParameterCount = Arrays.stream(carClass.getDeclaredConstructors())
                .map(Constructor::getParameterCount)
                .collect(Collectors.toSet());

        assertThat(constructorParameterCount).containsExactlyInAnyOrder(0, 2);
    }

    @Test
    void 메소드정보를_가져온다() {
        final List<String> methodNames = Arrays.stream(carClass.getDeclaredMethods())
                .map(Method::getName)
                .toList();

        assertThat(methodNames).containsExactlyInAnyOrder("printView", "testGetName", "testGetPrice", "equals", "hashCode");
    }

    @Test
    void test로_시작하는_메소드를_실행한다() {
        final Car car = new Car("테스트", 1000);
        final List<Object> methodResults = Arrays.stream(car.getClass().getDeclaredMethods())
                .filter(it -> it.getName().startsWith("test"))
                .map(it -> invokeMethod(it, car))
                .toList();
        assertThat(methodResults).containsExactly("name : 테스트", "price : 1000");
    }

    @Test
    void printView_어노테이션을_실행한다() {
        final Car car = new Car("테스트", 1000);
        final Stream<Method> methodResults = Arrays.stream(car.getClass().getDeclaredMethods())
                .filter(it -> it.isAnnotationPresent(PrintView.class));
        methodResults.forEach(it -> invokeMethod(it, car));
    }

    private static Object invokeMethod(final Method method, final Car car) {
        try {
            return method.invoke(car);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void private_필드에_값을_할당한다() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        final Car car = new Car();
        final Field name = car.getClass().getDeclaredField("name");
        final Field price = car.getClass().getDeclaredField("price");
        name.setAccessible(true);
        price.setAccessible(true);
        name.set(car, "테스트");
        price.set(car, 1000);

        assertAll(
                () -> assertThat(name.get(car)).isEqualTo("테스트"),
                () -> assertThat(price.get(car)).isEqualTo(1000)
        );
    }

    @Test
    void 인자를_가진_생성자의_인스터스를_생성한다() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        final Constructor<?> instance = Arrays.stream(carClass.getDeclaredConstructors())
                .filter(it -> it.getParameterCount() > 0)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("생성자가 없습니다."));

        final Car car = (Car) instance.newInstance("테스트", 1000);
        assertThat(car).isEqualTo(new Car("테스트", 1000));
    }
}