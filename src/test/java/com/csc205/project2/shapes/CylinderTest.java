package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {

    @Test
    void constructorSetsFieldsCorrectly() {
        Cylinder c = new Cylinder("Can", "Green", 3.0, 8.0);
        assertEquals("Can", c.getName());
        assertEquals("Green", c.getColor());
        assertEquals(3.0, c.getRadius(), 1e-9);
        assertEquals(8.0, c.getHeight(), 1e-9);
    }

    @Test
    void settersUpdateValues() {
        Cylinder c = new Cylinder("Can", "Green", 3.0, 8.0);
        c.setRadius(5.0);
        c.setHeight(10.0);
        assertEquals(5.0, c.getRadius(), 1e-9);
        assertEquals(10.0, c.getHeight(), 1e-9);
    }

    @Test
    void volumeCalculationRadius3Height8() {
        // V = π * 9 * 8 ≈ 226.195
        Cylinder c = new Cylinder("Can", "Green", 3.0, 8.0);
        assertEquals(226.195, c.getVolume(), 0.001);
    }

    @Test
    void surfaceAreaCalculationRadius3Height8() {
        // SA = 2 * π * 3 * (3 + 8) = 2 * π * 33 ≈ 207.345
        Cylinder c = new Cylinder("Can", "Green", 3.0, 8.0);
        assertEquals(207.345, c.getSurfaceArea(), 0.001);
    }

    @Test
    void negativeRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cylinder("Bad", "Red", -1.0, 5.0));
    }

    @Test
    void zeroHeightThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cylinder("Bad", "Red", 3.0, 0.0));
    }

    @Test
    void negativeHeightThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cylinder("Bad", "Red", 3.0, -2.0));
    }

    @Test
    void cylinderIsInstanceOfShape3D() {
        assertInstanceOf(Shape3D.class, new Cylinder("Can", "Green", 3.0, 8.0));
    }

    @Test
    void polymorphicReferenceCalcWorks() {
        Shape3D c = new Cylinder("Can", "Green", 3.0, 8.0);
        assertEquals(226.195, c.getVolume(), 0.001);
    }

    @Test
    void toStringContainsKeyInfo() {
        Cylinder c = new Cylinder("Can", "Green", 3.0, 8.0);
        String str = c.toString();
        assertTrue(str.contains("Can"));
        assertTrue(str.contains("Green"));
    }}