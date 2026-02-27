package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeFactoryTest {

    @Test
    void createSphere() {
        Shape3D s = ShapeFactory.create(Sphere.class, "Ball", "Red", 3.0);
        assertInstanceOf(Sphere.class, s);
        assertEquals("Ball", s.getName());
        assertEquals(113.097, s.getVolume(), 0.001);
    }

    @Test
    void createCube() {
        Shape3D c = ShapeFactory.create(Cube.class, "Box", "Blue", 4.0);
        assertInstanceOf(Cube.class, c);
        assertEquals(64.0, c.getVolume(), 1e-9);
    }

    @Test
    void createCylinder() {
        Shape3D c = ShapeFactory.create(Cylinder.class, "Can", "Green", 3.0, 8.0);
        assertInstanceOf(Cylinder.class, c);
        assertEquals(226.195, c.getVolume(), 0.001);
    }

    @Test
    void createRectangularPrism() {
        Shape3D rp = ShapeFactory.create(RectangularPrism.class, "Brick", "Orange", 6.0, 3.0, 2.0);
        assertInstanceOf(RectangularPrism.class, rp);
        assertEquals(36.0, rp.getVolume(), 1e-9);
    }

    @Test
    void createCone() {
        Shape3D c = ShapeFactory.create(Cone.class, "Hat", "Purple", 3.0, 7.0);
        assertInstanceOf(Cone.class, c);
        assertEquals(65.973, c.getVolume(), 0.001);
    }

    @Test
    void nullClassThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> ShapeFactory.create(null, "Name", "Red", 3.0));
    }

    @Test
    void nullNameThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> ShapeFactory.create(Sphere.class, null, "Red", 3.0));
    }

    @Test
    void blankColorThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> ShapeFactory.create(Sphere.class, "Ball", "", 3.0));
    }

    @Test
    void tooFewDimensionsThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> ShapeFactory.create(Cylinder.class, "Can", "Green", 3.0)); // missing height
    }

    @Test
    void unsupportedClassThrowsException() {
        // Use an anonymous subclass to simulate an unknown shape type
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("serial")
            class Unknown extends Shape3D {
                Unknown() { super("?", "?"); }
                @Override public double getSurfaceArea() { return 0; }
                @Override public double getVolume() { return 0; }
            }
            ShapeFactory.create(Unknown.class, "X", "Y", 1.0);
        });
    }
}
