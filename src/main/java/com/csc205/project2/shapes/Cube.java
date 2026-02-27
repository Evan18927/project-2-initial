package com.csc205.project2.shapes;

public class Cube extends Shape3D  {

    /** The length of each side of the cube. */
    private double sideLength;

    /**
     * Constructs a Cube with the specified name, color, and side length.
     *
     * @param name       the name of this cube; must not be null or blank
     * @param color      the color of this cube; must not be null or blank
     * @param sideLength the side length; must be positive
     * @throws IllegalArgumentException if sideLength is not positive
     */
    public Cube(String name, String color, double sideLength) {
        super(name, color);
        setSideLength(sideLength);
    }

    /**
     * Returns the side length of this cube.
     *
     * @return the side length
     */
    public double getSideLength() {
        return sideLength;
    }

    /**
     * Sets the side length of this cube.
     *
     * @param sideLength the new side length; must be positive
     * @throws IllegalArgumentException if sideLength is not positive
     */
    public void setSideLength(double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Side length must be positive.");
        }
        this.sideLength = sideLength;
    }

    /**
     * Calculates the surface area of the cube.
     * Formula: 6 * s²
     *
     * @return surface area in square units
     */
    @Override
    public double getSurfaceArea() {
        return 6.0 * sideLength * sideLength;
    }

    /**
     * Calculates the volume of the cube.
     * Formula: s³
     *
     * @return volume in cubic units
     */
    @Override
    public double getVolume() {
        return Math.pow(sideLength, 3);
    }

    /**
     * Returns a string representation of this cube.
     *
     * @return formatted description including side length, surface area, and volume
     */
    @Override
    public String toString() {
        return String.format("Cube{name='%s', color='%s', sideLength=%.2f, surfaceArea=%.2f, volume=%.2f}",
                getName(), getColor(), sideLength, getSurfaceArea(), getVolume());
    }

}

