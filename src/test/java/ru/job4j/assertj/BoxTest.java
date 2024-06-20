package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author artem.polschak@gmail.com on 19.03.2023.
 * @project job4j_design
 */
class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 1);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 1);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(-1, 1);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void checkInt() {
        Box box = new Box(4, 8);
        int result = box.getNumberOfVertices();
        assertThat(result).isNotZero()
                .isPositive()
                .isEven()
                .isGreaterThan(1)
                .isLessThan(5)
                .isEqualTo(4);
    }

    @Test
    void checkIntFalse() {
        Box box = new Box(2, 8);
        int result = box.getNumberOfVertices();
        assertThat(result).isNegative().isNotZero();
    }

    @Test
    void checkIsExistFalse() {
        Box box = new Box(3, 0);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void checkIsExistTrue() {
        Box box = new Box(8, 8);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void checkGetAreaIsZero() {
        Box box = new Box(7, 8);
        double result = box.getArea();
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testGetArea() {

        Box sphere = new Box(0, 2);
        assertThat(sphere.getArea()).isCloseTo(50.265, withPrecision(0.001));

        Box tetrahedron = new Box(4, 3);
        assertThat(tetrahedron.getArea()).isCloseTo(15.588, withPrecision(0.001));

        Box cube = new Box(8, 4);
        assertThat(cube.getArea()).isCloseTo(96.0, withPrecision(0.001));

        Box invalid = new Box(6, 0);
        assertThat(invalid.getArea()).isEqualTo(0);
    }
}