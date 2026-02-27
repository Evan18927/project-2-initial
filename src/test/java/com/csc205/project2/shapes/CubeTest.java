package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CubeTest {

    @Test
    void constructorSetsFieldsCorrectly() {
        Cube c = new Cube("Box", "Blue", 4.0);
        assertEquals("Box", c.getName());
        assertEquals("Blue", c.getColor());
        assertEquals(4.0, c.getSideLength(), 1e-9);
    }

    @Test
    void setterUpdatesSideLength() {
        Cube c = new Cube("Box", "Blue", 4.0);
        c.setSideLength(10.0);
        assertEquals(10.0, c.getSideLength(), 1e-9);
    }

    @Test
    void volumeCalculationSide4() {
        // 4³ = 64
        Cube c = new Cube("Box", "Blue", 4.0);
        assertEquals(64.0, c.getVolume(), 1e-9);
    }

    @Test
    void surfaceAreaCalculationSide4() {
        // 6 * 4² = 96
        Cube c = new Cube("Box", "Blue", 4.0);
        assertEquals(96.0, c.getSurfaceArea(), 1e-9);
    }

    @Test
    void volumeCalculationSide1() {
        Cube c = new Cube("Unit", "White", 1.0);
        assertEquals(1.0, c.getVolume(), 1e-9);
    }

    @Test
    void surfaceAreaCalculationSide1() {
        Cube c = new Cube("Unit", "White", 1.0);
        assertEquals(6.0, c.getSurfaceArea(), 1e-9);
    }

    @Test
    void verySmallSideLengthReturnsPositive() {
        Cube c = new Cube("Tiny", "Black", 0.001);
        assertTrue(c.getVolume() > 0);
        assertTrue(c.getSurfaceArea() > 0);
    }

    @Test
    void negativeSideLengthThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cube("Bad", "Red", -5.0));
    }

    @Test
    void zeroSideLengthThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cube("Bad", "Red", 0.0));
    }

    @Test
    void nullColorThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cube("Box", null, 4.0));
    }

    @Test
    void cubeIsInstanceOfShape3D() {
        assertInstanceOf(Shape3D.class, new Cube("Box", "Blue", 4.0));
    }

    @Test
    void polymorphicReferenceCalcWorks() {
        Shape3D c = new Cube("Box", "Blue", 3.0);
        assertEquals(27.0, c.getVolume(), 1e-9);
        assertEquals(54.0, c.getSurfaceArea(), 1e-9);
    }

    @Test
    void toStringContainsKeyInfo() {
        Cube c = new Cube("Box", "Blue", 4.0);
        String str = c.toString();
        assertTrue(str.contains("Box"));
        assertTrue(str.contains("Blue"));
        assertTrue(str.contains("4.00"));
    }
}