package com.csc205.project2.shapes;

public class Cone extends Shape3D {


    /** The radius of the cone's circular base. */
    private double radius;

    /** The vertical height of the cone. */
    private double height;

    /**
     * Constructs a Cone with the specified name, color, radius, and height.
     *
     * @param name   the name; must not be null or blank
     * @param color  the color; must not be null or blank
     * @param radius the base radius; must be positive
     * @param height the height; must be positive
     * @throws IllegalArgumentException if radius or height is not positive
     */
    public Cone(String name, String color, double radius, double height) {
        super(name, color);
        setRadius(radius);
        setHeight(height);
    }

    /** @return the base radius */
    public double getRadius() { return radius; }

    /**
     * Sets the base radius.
     * @param radius must be positive
     */
    public void setRadius(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Radius must be positive.");
        this.radius = radius;
    }

    /** @return the height */
    public double getHeight() { return height; }

    /**
     * Sets the height.
     * @param height must be positive
     */
    public void setHeight(double height) {
        if (height <= 0) throw new IllegalArgumentException("Height must be positive.");
        this.height = height;
    }

    /**
     * Calculates the slant height of the cone.
     * Formula: √(r² + h²)
     *
     * @return slant height in units
     */
    public double getSlantHeight() {
        return Math.sqrt(radius * radius + height * height);
    }

    /**
     * Calculates the total surface area of the cone (base + lateral).
     * Formula: π * r * (r + slant height)
     *
     * @return surface area in square units
     */
    @Override
    public double getSurfaceArea() {
        return Math.PI * radius * (radius + getSlantHeight());
    }

    /**
     * Calculates the volume of the cone.
     * Formula: (1/3) * π * r² * h
     *
     * @return volume in cubic units
     */
    @Override
    public double getVolume() {
        return (1.0 / 3.0) * Math.PI * radius * radius * height;
    }

    /**
     * Returns a string representation of this cone.
     *
     * @return formatted description
     */
    @Override
    public String toString() {
        return String.format(
                "Cone{name='%s', color='%s', radius=%.2f, height=%.2f, slantHeight=%.2f, surfaceArea=%.2f, volume=%.2f}",
                getName(), getColor(), radius, height, getSlantHeight(), getSurfaceArea(), getVolume());
    }
}


