package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    // ── Basic Functionality ───────────────────────────────────

    @Test
    void constructorSetsFieldsCorrectly() {
        Sphere s = new Sphere("Ball", "Red", 3.0);
        assertEquals("Ball", s.getName());
        assertEquals("Red", s.getColor());
        assertEquals(3.0, s.getRadius(), 1e-9);
    }

    @Test
    void settersUpdateValues() {
        Sphere s = new Sphere("Ball", "Red", 3.0);
        s.setRadius(7.5);
        assertEquals(7.5, s.getRadius(), 1e-9);
        s.setName("New Ball");
        assertEquals("New Ball", s.getName());
    }

    // ── Calculation Accuracy ─────────────────────────────────

    @Test
    void volumeCalculationRadius3() {
        // V = (4/3) * π * 3³ ≈ 113.097
        Sphere s = new Sphere("Ball", "Blue", 3.0);
        assertEquals(113.097, s.getVolume(), 0.001);
    }

    @Test
    void surfaceAreaCalculationRadius3() {
        // SA = 4 * π * 3² ≈ 113.097
        Sphere s = new Sphere("Ball", "Blue", 3.0);
        assertEquals(113.097, s.getSurfaceArea(), 0.001);
    }

    @Test
    void volumeCalculationRadius1() {
        // V = (4/3) * π * 1 ≈ 4.189
        Sphere s = new Sphere("Unit", "White", 1.0);
        assertEquals(4.189, s.getVolume(), 0.001);
    }

    @Test
    void surfaceAreaCalculationRadius1() {
        // SA = 4 * π ≈ 12.566
        Sphere s = new Sphere("Unit", "White", 1.0);
        assertEquals(12.566, s.getSurfaceArea(), 0.001);
    }

    // ── Boundary Testing ─────────────────────────────────────

    @Test
    void verySmallRadiusReturnsPositiveValues() {
        Sphere s = new Sphere("Tiny", "Black", 0.001);
        assertTrue(s.getVolume() > 0);
        assertTrue(s.getSurfaceArea() > 0);
    }

    @Test
    void veryLargeRadiusCalculatesCorrectly() {
        Sphere s = new Sphere("Giant", "Black", 1_000_000.0);
        assertTrue(s.getVolume() > 0);
        assertTrue(s.getSurfaceArea() > 0);
    }

    // ── Input Validation ─────────────────────────────────────

    @Test
    void negativeRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Sphere("Bad", "Red", -1.0));
    }

    @Test
    void zeroRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Sphere("Bad", "Red", 0.0));
    }

    @Test
    void nullNameThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Sphere(null, "Red", 3.0));
    }

    @Test
    void blankColorThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Sphere("Ball", "   ", 3.0));
    }

    // ── Inheritance / Polymorphism ────────────────────────────

    @Test
    void sphereIsInstanceOfShape3D() {
        Sphere s = new Sphere("Ball", "Red", 5.0);
        assertInstanceOf(Shape3D.class, s);
    }

    @Test
    void sphereIsInstanceOfThreeDimensionalShape() {
        Sphere s = new Sphere("Ball", "Red", 5.0);
        assertInstanceOf(ThreeDimensionalShape.class, s);
    }

    @Test
    void polymorphicReferenceCallsCorrectMethods() {
        Shape3D s = new Sphere("Ball", "Red", 3.0);
        assertEquals(113.097, s.getVolume(), 0.001);
        assertEquals(113.097, s.getSurfaceArea(), 0.001);
    }

    @Test
    void toStringContainsKeyInfo() {
        Sphere s = new Sphere("Ball", "Red", 3.0);
        String str = s.toString();
        assertTrue(str.contains("Ball"));
        assertTrue(str.contains("Red"));
        assertTrue(str.contains("3.00"));
    }
}