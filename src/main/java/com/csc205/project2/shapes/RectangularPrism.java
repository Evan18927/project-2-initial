package com.csc205.project2.shapes;

public class RectangularPrism extends Shape3D {


    /** The length of the rectangular prism. */
    private double length;

    /** The width of the rectangular prism. */
    private double width;

    /** The height of the rectangular prism. */
    private double height;

    /**
     * Constructs a RectangularPrism with the specified name, color, and dimensions.
     *
     * @param name   the name; must not be null or blank
     * @param color  the color; must not be null or blank
     * @param length the length; must be positive
     * @param width  the width; must be positive
     * @param height the height; must be positive
     * @throws IllegalArgumentException if any dimension is not positive
     */
    public RectangularPrism(String name, String color, double length, double width, double height) {
        super(name, color);
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    /** @return the length */
    public double getLength() { return length; }

    /**
     * Sets the length.
     * @param length must be positive
     */
    public void setLength(double length) {
        if (length <= 0) throw new IllegalArgumentException("Length must be positive.");
        this.length = length;
    }

    /** @return the width */
    public double getWidth() { return width; }

    /**
     * Sets the width.
     * @param width must be positive
     */
    public void setWidth(double width) {
        if (width <= 0) throw new IllegalArgumentException("Width must be positive.");
        this.width = width;
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
     * Calculates the surface area of the rectangular prism.
     * Formula: 2 * (lw + lh + wh)
     *
     * @return surface area in square units
     */
    @Override
    public double getSurfaceArea() {
        return 2.0 * (length * width + length * height + width * height);
    }

    /**
     * Calculates the volume of the rectangular prism.
     * Formula: l * w * h
     *
     * @return volume in cubic units
     */
    @Override
    public double getVolume() {
        return length * width * height;
    }

    /**
     * Returns a string representation of this rectangular prism.
     *
     * @return formatted description
     */
    @Override
    public String toString() {
        return String.format(
                "RectangularPrism{name='%s', color='%s', length=%.2f, width=%.2f, height=%.2f, surfaceArea=%.2f, volume=%.2f}",
                getName(), getColor(), length, width, height, getSurfaceArea(), getVolume());
    }
}










