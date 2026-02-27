package com.csc205.project2.shapes;


import com.csc205.project2.shapes.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;






public class ShapeDriver {



    public static void main(String[] args) {
        System.out.println("=".repeat(50));
        System.out.println("       3D Shape Analysis System");
        System.out.println("=".repeat(50));

        // ── 1. Create a polymorphic list of shapes ───────────────
        List<Shape3D> shapes = new ArrayList<>();
        shapes.add(new Sphere("Red Ball", "Red", 5.0));
        shapes.add(new Cube("Blue Box", "Blue", 4.0));
        shapes.add(new Cylinder("Green Can", "Green", 3.0, 8.0));
        shapes.add(new RectangularPrism("Orange Brick", "Orange", 6.0, 3.0, 2.0));
        shapes.add(new Cone("Purple Party Hat", "Purple", 3.0, 7.0));

        // ── 2. Print each shape ───────────────────────────────────
        System.out.println("\nCreated Shapes:");
        System.out.println("-".repeat(50));
        int i = 1;
        for (Shape3D shape : shapes) {
            System.out.printf("%d. %s%n", i++, shape);
            System.out.printf("   Surface Area : %.2f square units%n", shape.getSurfaceArea());
            System.out.printf("   Volume       : %.2f cubic units%n%n", shape.getVolume());
        }

        // ── 3. Analysis ───────────────────────────────────────────
        Shape3D largestVolume = shapes.stream()
                .max(Comparator.comparingDouble(Shape3D::getVolume))
                .orElseThrow();

        Shape3D largestSurface = shapes.stream()
                .max(Comparator.comparingDouble(Shape3D::getSurfaceArea))
                .orElseThrow();

        Shape3D mostEfficient = shapes.stream()
                .max(Comparator.comparingDouble(s -> s.getVolume() / s.getSurfaceArea()))
                .orElseThrow();

        System.out.println("Analysis Results:");
        System.out.println("-".repeat(50));
        System.out.printf("Largest Volume     : %s (%.2f)%n",
                largestVolume.getName(), largestVolume.getVolume());
        System.out.printf("Largest Surface    : %s (%.2f)%n",
                largestSurface.getName(), largestSurface.getSurfaceArea());
        System.out.printf("Most Efficient     : %s (Vol/SA = %.4f)%n",
                mostEfficient.getName(),
                mostEfficient.getVolume() / mostEfficient.getSurfaceArea());

        // ── 4. Factory demonstration ─────────────────────────────
        System.out.println("\nFactory Pattern Demo:");
        System.out.println("-".repeat(50));
        Shape3D factorySphere = ShapeFactory.create(Sphere.class, "Factory Sphere", "Silver", 2.5);
        Shape3D factoryCone   = ShapeFactory.create(Cone.class,   "Factory Cone",   "Gold",   4.0, 9.0);
        System.out.println(factorySphere);
        System.out.println(factoryCone);

        // ── 5. Interactive section ───────────────────────────────
        System.out.println("\nInteractive Shape Creator");
        System.out.println("-".repeat(50));
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter sphere name (or press Enter to skip): ");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                System.out.print("Enter color: ");
                String color = scanner.nextLine().trim();
                System.out.print("Enter radius: ");
                double r = Double.parseDouble(scanner.nextLine().trim());
                Sphere userSphere = new Sphere(input, color.isEmpty() ? "White" : color, r);
                System.out.println("Created: " + userSphere);
            }
        } catch (Exception e) {
            System.out.println("(Interactive input skipped: " + e.getMessage() + ")");
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("Analysis complete.");
    }
}












































