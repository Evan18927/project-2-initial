# AI Interaction Log

AI Interaction Log
Project: Project 2 – AI-Assisted 3D Geometric Shapes with Inheritance
AI Tool Used: Claude (claude-sonnet-4-20250514)
Course: CSC 205

This document serves as a log of interactions with AI systems, capturing prompts, responses, and reflections on the outcomes. It is intended to help users track their engagements with AI and improve future interactions.

## Driver
Session 5 – ShapeDriver
Date: 2025-02-26
Goal: Create the demonstration driver class.
Prompt:

"Create ShapeDriver.java that uses a polymorphic List<Shape3D> to hold five different shapes, prints each with surface area and volume, performs comparative analysis (largest volume, largest surface area, most efficient = volume/surface area), demonstrates the factory pattern, and includes a brief interactive section using Scanner."

Manual Modifications: None.


## Class 1

Session 1 – Abstract Base Class
Date: 2025-02-26
Goal: Generate the Shape3D abstract base class.
Prompt:

"Create an abstract base class Shape3D in Java that implements the ThreeDimensionalShape interface. Include private fields for name and color, constructors, getters/setters with validation (null/blank rejected), and implementations of getSurfaceArea() and getVolume() that are abstract. Add a toString() method that formats output consistently with name, color, surface area, and volume. Include full JavaDoc documentation."

AI Response Quality: Excellent. Generated all required elements on the first attempt.
Follow-up Prompt:

"Add input validation to the setters so null or empty strings are rejected with an IllegalArgumentException."

Manual Modifications: None — output met all requirements.

## Class 2

Session 3 – Test Suite
Date: 2025-02-26
Goal: Generate comprehensive JUnit 5 test classes.
Prompt (used for each shape):

"Generate a JUnit 5 test class for [ShapeName] that covers: constructor and getters, calculation accuracy with known values (and the expected answer), boundary conditions (very small/large), input validation (negatives, zero, null), and inheritance/polymorphism tests. Use assertEquals with delta tolerances for floating-point math."

AI Response Quality: Good — needed minor review to verify delta tolerances matched expected values.
Manual Modifications:

Verified all expected values using online geometric calculators.
Adjusted delta values from 1e-5 to 0.001 where appropriate for readable assertions.


