package com.epam.designpattern;
import java.util.ArrayList;
import java.util.List;

public class Structuraldesignpattern1 {
	public static void main(String[] args) {
		Shape tri = new Triangle();
		Shape tri1 = new Triangle();
		Shape cir = new Circle();
		Drawing drawing = new Drawing();
		drawing.add(tri1);
		drawing.add(tri1);
		drawing.add(cir);
		drawing.draw("Red");
		drawing.clear();
		drawing.add(tri);
		drawing.add(cir);
		drawing.draw("Green");
	}
}
interface Shape {
	public void draw(String fillColor);
}
class Triangle implements Shape {
	public void draw(String fillColor) {
		System.out.println("Drawing Triangle with color "+fillColor);
	}
}
class Circle implements Shape {
	public void draw(String fillColor) {
		System.out.println("Drawing Circle with color "+fillColor);
	}
}
class Drawing implements Shape{
	private List<Shape> shapes = new ArrayList<Shape>();

	public void draw(String fillColor) {
		for(Shape sh : shapes)
			sh.draw(fillColor);
	}
	public void add(Shape s){
		this.shapes.add(s);
	}
	public void remove(Shape s){
		shapes.remove(s);
	}
	public void clear(){
		System.out.println("Clearing all the shapes from drawing");
		this.shapes.clear();
	}
}
