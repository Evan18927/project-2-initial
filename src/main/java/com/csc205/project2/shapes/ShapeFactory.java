package com.csc205.project2.shapes;

/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: Claude (claude-sonnet-4-20250514)
 * Generation Date: 2025-02-26
 *
 * Original Prompt:
 * "Create a ShapeFactory class in Java that implements the factory pattern for
 * creating 3D shapes. It should have a static create() method that accepts a
 * Class type, a name String, and a varargs double[] of dimensions. It should
 * support Sphere, Cube, Cylinder, RectangularPrism, and Cone. Include full
 * JavaDoc and throw IllegalArgumentException for invalid inputs."
 *
 * Follow-up Prompts (if any):
 * 1. "Explain the factory pattern in comments at the top of the class."
 *
 * Manual Modifications:
 * - Added a default color parameter for the factory to use when none is supplied.
 *
 * Formula Verification:
 * - N/A (factory delegates to shape constructors)
 */

/**
 * Factory class for creating {@link Shape3D} instances from class type and dimensions.
 *
 * <p>The <em>Factory Pattern</em> centralizes object creation logic so callers do not
 * need to know which constructor to call. Instead, they pass a Class token and a set
 * of dimension values, and the factory handles instantiation details.</p>
 *
 * <p>Usage example:
 * <pre>
 *   Shape3D s = ShapeFactory.create(Sphere.class, "Red Ball", "Red", 5.0);
 *   Shape3D c = ShapeFactory.create(Cone.class, "Party Hat", "Yellow", 3.0, 7.0);
 * </pre>
 * </p>
*/



public class ShapeFactory {

    /** Private constructor to prevent instantiation of this utility class. */
    private ShapeFactory() {}

    /**
     * Creates a {@link Shape3D} of the requested type.
     *
     * <table border="1">
     *   <tr><th>Class</th><th>Required dimensions</th></tr>
     *   <tr><td>Sphere</td><td>radius</td></tr>
     *   <tr><td>Cube</td><td>sideLength</td></tr>
     *   <tr><td>Cylinder</td><td>radius, height</td></tr>
     *   <tr><td>RectangularPrism</td><td>length, width, height</td></tr>
     *   <tr><td>Cone</td><td>radius, height</td></tr>
     * </table>
     *
     * @param shapeClass the concrete shape class to create
     * @param name       the name to assign to the shape
     * @param color      the color to assign to the shape
     * @param dims       the dimension values in the order shown above
     * @return a new {@link Shape3D} instance
     * @throws IllegalArgumentException if the class is unsupported or wrong number of dimensions
     */
    public static Shape3D create(Class<? extends Shape3D> shapeClass, String name, String color, double... dims) {
        if (shapeClass == null) throw new IllegalArgumentException("Shape class must not be null.");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name must not be null or blank.");
        if (color == null || color.isBlank()) throw new IllegalArgumentException("Color must not be null or blank.");

        if (shapeClass == Sphere.class) {
            requireDims(dims, 1, "Sphere");
            return new Sphere(name, color, dims[0]);

        } else if (shapeClass == Cube.class) {
            requireDims(dims, 1, "Cube");
            return new Cube(name, color, dims[0]);

        } else if (shapeClass == Cylinder.class) {
            requireDims(dims, 2, "Cylinder");
            return new Cylinder(name, color, dims[0], dims[1]);

        } else if (shapeClass == RectangularPrism.class) {
            requireDims(dims, 3, "RectangularPrism");
            return new RectangularPrism(name, color, dims[0], dims[1], dims[2]);

        } else if (shapeClass == Cone.class) {
            requireDims(dims, 2, "Cone");
            return new Cone(name, color, dims[0], dims[1]);

        } else {
            throw new IllegalArgumentException("Unsupported shape class: " + shapeClass.getName());
        }
    }

    /**
     * Validates that the correct number of dimensions were supplied.
     *
     * @param dims     the supplied dimension array
     * @param required the number of dimensions expected
     * @param label    the shape name used in the error message
     * @throws IllegalArgumentException if the count does not match
     */
    private static void requireDims(double[] dims, int required, String label) {
        if (dims == null || dims.length < required) {
            throw new IllegalArgumentException(
                    label + " requires " + required + " dimension(s); got " + (dims == null ? 0 : dims.length));
        }


    }}