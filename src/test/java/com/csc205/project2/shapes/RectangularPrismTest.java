package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangularPrismTest {

    @Test
    void constructorSetsFieldsCorrectly() {
        RectangularPrism rp = new RectangularPrism("Brick", "Orange", 6.0, 3.0, 2.0);
        assertEquals("Brick", rp.getName());
        assertEquals("Orange", rp.getColor());
        assertEquals(6.0, rp.getLength(), 1e-9);
        assertEquals(3.0, rp.getWidth(), 1e-9);
        assertEquals(2.0, rp.getHeight(), 1e-9);
    }

    @Test
    void settersUpdateValues() {
        RectangularPrism rp = new RectangularPrism("Brick", "Orange", 6.0, 3.0, 2.0);
        rp.setLength(10.0);
        rp.setWidth(5.0);
        rp.setHeight(4.0);
        assertEquals(10.0, rp.getLength(), 1e-9);
        assertEquals(5.0, rp.getWidth(), 1e-9);
        assertEquals(4.0, rp.getHeight(), 1e-9);
    }

    @Test
    void volumeCalculation() {
        // 6 * 3 * 2 = 36
        RectangularPrism rp = new RectangularPrism("Brick", "Orange", 6.0, 3.0, 2.0);
        assertEquals(36.0, rp.getVolume(), 1e-9);
    }

    @Test
    void surfaceAreaCalculation() {
        // 2*(6*3 + 6*2 + 3*2) = 2*(18+12+6) = 72
        RectangularPrism rp = new RectangularPrism("Brick", "Orange", 6.0, 3.0, 2.0);
        assertEquals(72.0, rp.getSurfaceArea(), 1e-9);
    }

    @Test
    void cubeSpecialCaseVolume() {
        // When all sides equal, behaves like a cube
        RectangularPrism rp = new RectangularPrism("Cube-like", "White", 4.0, 4.0, 4.0);
        assertEquals(64.0, rp.getVolume(), 1e-9);
    }

    @Test
    void negativeLengthThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new RectangularPrism("Bad", "Red", -1.0, 3.0, 2.0));
    }

    @Test
    void zeroWidthThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new RectangularPrism("Bad", "Red", 5.0, 0.0, 2.0));
    }

    @Test
    void negativeHeightThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new RectangularPrism("Bad", "Red", 5.0, 3.0, -1.0));
    }

    @Test
    void isInstanceOfShape3D() {
        assertInstanceOf(Shape3D.class,
                new RectangularPrism("Brick", "Orange", 6.0, 3.0, 2.0));
    }

    @Test
    void polymorphicReferenceCalcWorks() {
        Shape3D rp = new RectangularPrism("Brick", "Orange", 6.0, 3.0, 2.0);
        assertEquals(36.0, rp.getVolume(), 1e-9);
        assertEquals(72.0, rp.getSurfaceArea(), 1e-9);
    }

    @Test
    void toStringContainsKeyInfo() {
        RectangularPrism rp = new RectangularPrism("Brick", "Orange", 6.0, 3.0, 2.0);
        String str = rp.toString();
        assertTrue(str.contains("Brick"));
        assertTrue(str.contains("Orange"));
    }
}
