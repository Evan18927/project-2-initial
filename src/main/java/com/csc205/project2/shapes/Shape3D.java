package com.csc205.project2.shapes;


/**
 * Abstract base class for all 3D geometric shapes.
 * Implements the {@link ThreeDimensionalShape} interface and provides
 * common properties (name, color) and a consistent toString() format.
 */




public abstract class Shape3D implements ThreeDimensionalShape {

    /** The descriptive name of this shape instance. */
    private String name;

    /** The color of this shape. */
    private String color;

    /**
     * Constructs a Shape3D with the given name and color.
     *
     * @param name  the name of the shape; must not be null or blank
     * @param color the color of the shape; must not be null or blank
     * @throws IllegalArgumentException if name or color is null or blank
     */
    public Shape3D(String name, String color) {
        setName(name);
        setColor(color);
    }

    /**
     * Returns the name of this shape.
     *
     * @return the shape name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this shape.
     *
     * @param name the new name; must not be null or blank
     * @throws IllegalArgumentException if name is null or blank
     */
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be null or blank.");
        }
        this.name = name;
    }

    /**
     * Returns the color of this shape.
     *
     * @return the shape color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of this shape.
     *
     * @param color the new color; must not be null or blank
     * @throws IllegalArgumentException if color is null or blank
     */
    public void setColor(String color) {
        if (color == null || color.isBlank()) {
            throw new IllegalArgumentException("Color must not be null or blank.");
        }
        this.color = color;
    }

    /**
     * Computes and returns the surface area of this shape.
     * Delegates to the concrete subclass implementation.
     *
     * @return surface area in square units
     */
    @Override
    public abstract double getSurfaceArea();

    /**
     * Computes and returns the volume of this shape.
     * Delegates to the concrete subclass implementation.
     *
     * @return volume in cubic units
     */
    @Override
    public abstract double getVolume();

    /**
     * Returns a formatted string representation of this shape,
     * including name, color, surface area, and volume.
     *
     * @return formatted shape description
     */
    @Override
    public String toString() {
        return String.format("Shape3D{name='%s', color='%s', surfaceArea=%.2f, volume=%.2f}",
                name, color, getSurfaceArea(), getVolume());
    }



}
