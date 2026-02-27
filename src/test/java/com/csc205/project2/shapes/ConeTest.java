package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConeTest {

    @Test
    void constructorSetsFieldsCorrectly() {
        Cone c = new Cone("Hat", "Purple", 3.0, 7.0);
        assertEquals("Hat", c.getName());
        assertEquals("Purple", c.getColor());
        assertEquals(3.0, c.getRadius(), 1e-9);
        assertEquals(7.0, c.getHeight(), 1e-9);
    }

    @Test
    void settersUpdateValues() {
        Cone c = new Cone("Hat", "Purple", 3.0, 7.0);
        c.setRadius(5.0);
        c.setHeight(12.0);
        assertEquals(5.0, c.getRadius(), 1e-9);
        assertEquals(12.0, c.getHeight(), 1e-9);
    }

    @Test
    void slantHeightCalculation() {
        // slant = √(3² + 4²) = 5
        Cone c = new Cone("Hat", "Red", 3.0, 4.0);
        assertEquals(5.0, c.getSlantHeight(), 1e-9);
    }

    @Test
    void volumeCalculationRadius3Height7() {
        // V = (1/3) * π * 9 * 7 ≈ 65.973
        Cone c = new Cone("Hat", "Purple", 3.0, 7.0);
        assertEquals(65.973, c.getVolume(), 0.001);
    }

    @Test
    void surfaceAreaCalculationRadius3Height4() {
        // slant = 5; SA = π * 3 * (3 + 5) = 24π ≈ 75.398
        Cone c = new Cone("Hat", "Red", 3.0, 4.0);
        assertEquals(75.398, c.getSurfaceArea(), 0.001);
    }

    @Test
    void negativeRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cone("Bad", "Red", -1.0, 5.0));
    }

    @Test
    void zeroHeightThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cone("Bad", "Red", 3.0, 0.0));
    }

    @Test
    void isInstanceOfShape3D() {
        assertInstanceOf(Shape3D.class, new Cone("Hat", "Purple", 3.0, 7.0));
    }

    @Test
    void polymorphicReferenceCalcWorks() {
        Shape3D c = new Cone("Hat", "Purple", 3.0, 4.0);
        assertEquals(75.398, c.getSurfaceArea(), 0.001);
    }

    @Test
    void toStringContainsKeyInfo() {
        Cone c = new Cone("Hat", "Purple", 3.0, 7.0);
        String str = c.toString();
        assertTrue(str.contains("Hat"));
        assertTrue(str.contains("Purple"));
    }
}
