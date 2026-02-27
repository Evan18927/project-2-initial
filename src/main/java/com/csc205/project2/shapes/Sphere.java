package com.csc205.project2.shapes;

public class Sphere extends Shape3D {

    /** The radius of the sphere. */
    private double radius;

    /**
     * Constructs a Sphere with the specified name, color, and radius.
     *
     * @param name   the name of this sphere; must not be null or blank
     * @param color  the color of this sphere; must not be null or blank
     * @param radius the radius of this sphere; must be positive
     * @throws IllegalArgumentException if radius is not positive
     */
    public Sphere(String name, String color, double radius) {
        super(name, color);
        setRadius(radius);
    }

    /**
     * Returns the radius of this sphere.
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of this sphere.
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
     * Calculates the surface area of the sphere.
     * Formula: 4 * π * r²
     *
     * @return surface area in square units
     */
    @Override
    public double getSurfaceArea() {
        return 4.0 * Math.PI * radius * radius;
    }

    /**
     * Calculates the volume of the sphere.
     * Formula: (4/3) * π * r³
     *
     * @return volume in cubic units
     */
    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    /**
     * Returns a string representation of this sphere.
     *
     * @return formatted description including radius, surface area, and volume
     */
    @Override
    public String toString() {
        return String.format("Sphere{name='%s', color='%s', radius=%.2f, surfaceArea=%.2f, volume=%.2f}",
                getName(), getColor(), radius, getSurfaceArea(), getVolume());
    }

}
