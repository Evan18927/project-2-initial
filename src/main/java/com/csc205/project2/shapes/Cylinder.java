package com.csc205.project2.shapes;

public class Cylinder extends Shape3D {

    /** The radius of the cylinder's circular cross-section. */
    private double radius;

    /** The height of the cylinder. */
    private double height;

    /**
     * Constructs a Cylinder with the specified name, color, radius, and height.
     *
     * @param name   the name of this cylinder; must not be null or blank
     * @param color  the color of this cylinder; must not be null or blank
     * @param radius the radius; must be positive
     * @param height the height; must be positive
     * @throws IllegalArgumentException if radius or height is not positive
     */
    public Cylinder(String name, String color, double radius, double height) {
        super(name, color);
        setRadius(radius);
        setHeight(height);
    }

    /**
     * Returns the radius of this cylinder.
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of this cylinder.
     *
     * @param radius the new radius; must be positive
     * @throws IllegalArgumentException if radius is not positive
     */
    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.radius = radius;
    }

    /**
     * Returns the height of this cylinder.
     *
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of this cylinder.
     *
     * @param height the new height; must be positive
     * @throws IllegalArgumentException if height is not positive
     */
    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive.");
        }
        this.height = height;
    }

    /**
     * Calculates the surface area of the cylinder (including both circular caps).
     * Formula: 2 * π * r * (r + h)
     *
     * @return surface area in square units
     */
    @Override
    public double getSurfaceArea() {
        return 2.0 * Math.PI * radius * (radius + height);
    }

    /**
     * Calculates the volume of the cylinder.
     * Formula: π * r² * h
     *
     * @return volume in cubic units
     */
    @Override
    public double getVolume() {
        return Math.PI * radius * radius * height;
    }

    /**
     * Returns a string representation of this cylinder.
     *
     * @return formatted description including radius, height, surface area, and volume
     */
    @Override
    public String toString() {
        return String.format("Cylinder{name='%s', color='%s', radius=%.2f, height=%.2f, surfaceArea=%.2f, volume=%.2f}",
                getName(), getColor(), radius, height, getSurfaceArea(), getVolume());
    }
}














