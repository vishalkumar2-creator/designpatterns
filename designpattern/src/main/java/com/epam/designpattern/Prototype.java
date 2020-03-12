package com.epam.designpattern;
import java.util.HashMap;
import java.util.Map;

public class Prototype 
{ 
    public static void main (String[] args) 
    { 
        ColorType.getColor("blue").addColor(); 
        ColorType.getColor("purple").addColor(); 
        ColorType.getColor("purple").addColor(); 
        ColorType.getColor("blue").addColor(); 
    } 
} 
 class ColorType{ 
	    private static Map<String, Color> colorMap = new HashMap<String, Color>(); 
	    static 
	    { 
	        colorMap.put("blue", new Blue()); 
	        colorMap.put("purple", new Purple()); 
	    } 
	       
	    public static Color getColor(String colorName) 
	    { 
	        return(Color)colorMap.get(colorName).clone(); 
	    } 
	} 
 abstract class Color implements Cloneable 
{ 
    protected String colorName; 
    abstract void addColor(); 
    public Object clone() 
    { 
        Object clone = null; 
        try 
        { 
            clone = super.clone(); 
        }  
        catch (CloneNotSupportedException e)  
        { 
            e.printStackTrace(); 
        } 
        return clone; 
    } 
} 
 class Blue extends Color 
 { 
     public Blue()  
     { 
         this.colorName = "blue"; 
     } 
     @Override
     void addColor()  
     { 
         System.out.println("Blue color added"); 
     }     
 } 
class Purple extends Color{ 
    public Purple() 
    { 
        this.colorName = "purple"; 
    } 
    @Override
    void addColor()  
    { 
        System.out.println("Purple color added"); 
    } 
} 