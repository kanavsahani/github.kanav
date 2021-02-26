package github.kanav;
// Photoshop program that can run several manipulations on 
// an image
// filler code by Mr. David

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class PhotoshopFiller extends Component {

	// the name of the output file. will be determined by which methods are called
    private String outputName;
    
    // the 2d array of colors representing the image
    private Color[][] pixels;
    
    // the width and height of the image 
    private int w,h;
    

    // this method increases each color's rgb value by a given amount.
    // don't forget that rgb values are limited to the range [0,255]
    public void brighten(int amount) {
        outputName = "brightened_" + outputName;
        
        for ( int i = 0; i < pixels.length;i++) {
        	for (int j = 0; j < pixels[i].length; j++) {
        		
        		Color c = pixels[i] [j];
        		
        		int r = c.getRed() + amount;
        		int g = c.getGreen() + amount;
        		int b = c.getBlue() + amount;
        		
        		if (r > 255)
        			r = 255;
        		if (r < 0)
        			r = 0;
        		if (g > 255)
        			g = 255;
        		if (g < 0)
        			g = 0;
        		if (b > 255)
        			b = 255;
        		if (b < 0)
        			b = 0;
        		pixels[i][j] = new Color(r, g, b);
        	}
        }
    }
    
    // flip an image either horizontally or vertically.
    public void flip(boolean horizontally) {
        outputName = (horizontally?"h":"v") + "_flipped_" + outputName;
        if (horizontally == true) {
        	for ( int i = 0; i < pixels.length;i++) {
        		for (int j = 0; j < pixels[i].length/2; j++) {
        		Color temp = pixels [i] [j];
        		pixels [i] [j] = pixels[i] [pixels[i].length-1-j];
        		pixels[i] [pixels[i].length-1-j] = temp;
        		}
        	}
        }
        else {
        	for ( int i = 0; i < pixels.length/2;i++) {
               	for (int j = 0; j < pixels[i].length; j++) {
               		Color temp = pixels [i] [j];
            		pixels [i] [j] = pixels[pixels.length-1-i] [j];
            		pixels[pixels.length-1-i] [j] = temp;
                		}
                	}
        		}
        	}
    
    // negates an image
    // to do this: subtract each pixel's rgb value from 255 
    // and use this as the new value
    public void negate() {
        outputName = "negated_" + outputName;
        
        for ( int i = 0; i < pixels.length;i++) {
        	for (int j = 0; j < pixels[i].length; j++) {
        		
        		Color c = pixels[i] [j];
        		
        		int r = 255-c.getRed();
        		int g = 255-c.getGreen();
        		int b = 255-c.getBlue(); 
        		
        		pixels[i][j] = new Color(r, g, b);
        	}
        }
    }
    
    // this makes the image 'simpler' by redrawing it using only a few colors
    // to do this: for each pixel, find the color in the list that is closest to
    // the pixel's rgb value. 
    // use this predefined color as the rgb value for the changed image.
    public void simplify() {
    
    		// the list of colors to compare to. Feel free to change/add colors
    		Color[] colorList = {Color.BLUE, Color.RED,Color.ORANGE, Color.MAGENTA,
                Color.BLACK, Color.WHITE, Color.GREEN, Color.YELLOW, Color.CYAN};
        outputName = "simplified_" + outputName;
        for ( int i = 0; i < pixels.length;i++) {
        	for (int j = 0; j < pixels[i].length; j++) {
        		
        		Color c = pixels[i] [j];
        		Color closest = Color.BLUE;
        		for (int k = 0; k < colorList.length; k++) {
        			if (distance(c,colorList[k]) < distance(c,closest) ) {
            			closest = colorList[k];
            		}
        		}
        		pixels [i] [j] = closest;
        	}
        }
        
         
    }
    
    // optional helper method (recommended) that finds the 'distance' 
    // between two colors.
    // use the 3d distance formula to calculate
    public double distance(Color c1, Color c2) {
    	
    	
    		return Math.sqrt(Math.pow(c1.getRed()-c2.getRed(), 2)+Math.pow(c1.getGreen()-c2.getGreen(), 2)+Math.pow(c1.getBlue()-c2.getBlue(), 2));	
    }
    
    // this blurs the image
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values 
    // with the current pixel's own rgb value. 
    // divide this sum by 9, and set it as the rgb value for the blurred image
    public void blur() {
		outputName = "blurred_" + outputName;
		Color[][] copyImage = new Color[h] [w];
		for ( int i = 3; i < pixels.length-3;i++) {
        	for (int j = 3; j < pixels[i].length-3; j++) {
        		int countR = 0, countG = 0, countB = 0;

        		for (int k = i-3; k <= i+3; k++) {
        			for (int l = j-3; l <= j+3; l++) {
        			countR += pixels[k] [l].getRed();
        			countG += pixels[k] [l].getGreen();
        			countB += pixels[k] [l].getBlue();
        			}
        		}
        		copyImage[i] [j] = new Color(countR/49, countG/49, countB/49);
        	}
		}
		for ( int i = 3; i < pixels.length-3;i++) {
        	for (int j = 3; j < pixels[i].length-3; j++) {
        		pixels [i] [j] = copyImage[i] [j];
        	}
       	}
	}
    
    // this highlights the edges in the image, turning everything else black. 
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values. 
    // now, multiply the current pixel's rgb value by 8, then subtract the sum.
    // this value is the rgb value for the 'edged' image
    public void edge() {
        outputName = "edged_" + outputName;
        Color[][] copyImage = new Color[h] [w];
        for ( int i = 1; i < pixels.length-1;i++) {
        	for (int j = 1; j < pixels[i].length-1; j++) {
        		int countR = 0, countG = 0, countB = 0;
        		for (int k = i-1; k <= i+1; k++) {
        			for (int l = j-1; l <= j+1; l++) {
        			countR += pixels[k] [l].getRed();
        			countG += pixels[k] [l].getGreen();
        			countB += pixels[k] [l].getBlue();
        			}
        		}
        		
        		int newRed = countR-9*pixels [i] [j].getRed();
        		int newGreen = countG-9*pixels [i] [j].getGreen();
        		int newBlue = countB-9*pixels [i] [j].getBlue();
        		if (newRed > 255) {
        			newRed = 255;
        		}
        		if (newGreen > 255) {
        			newGreen = 255;
        		}
        		if (newBlue > 255) {
        			newBlue = 255;
        		}
        		if (newRed < 0) {
        			newRed = 0;
        		}
        		if (newGreen < 0) {
        			newGreen = 0;
        		}
        		if (newBlue < 0) {
        			newBlue = 0;
        		}
        		copyImage [i] [j] = new Color (newRed, newGreen, newBlue);
        	}
		}
        for ( int i = 1; i < pixels.length-1;i++) {
        	for (int j = 1; j < pixels[i].length-1; j++) {
        		pixels[i] [j] = copyImage [i] [j];
        	}
        }
    }
    public void crop() {
    	outputName = "cropped_" + outputName;
    	Color[][] copyImage = new Color[h/2] [w/2];
    	for ( int i = 0; i < pixels.length/2;i++) {
        	for (int j = 0; j < pixels[i].length/2; j++) {
        		copyImage[i] [j] = new Color(pixels[i] [j].getRed(), pixels[i] [j].getGreen(), pixels[i] [j].getBlue());
        	}
		}
        pixels = copyImage;
     }
    
    
  
    // *************** DON'T MESS WITH THE BELOW CODE **************** //
    
    // feel free to check it out, but don't change it unless you've consulted 
    // with Mr. David and understand what the code's doing
    
    

    public void run() {
    	JFileChooser fc = new JFileChooser();
		File workingDirectory = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+ "Images");
		fc.setCurrentDirectory(workingDirectory);
		fc.showOpenDialog(null);
		File my_file = fc.getSelectedFile();
		if (my_file == null)
			System.exit(-1);
		
		// reads the image file and creates our 2d array
        BufferedImage image;
		try {
			image = ImageIO.read(my_file);
		
	        BufferedImage new_image = new BufferedImage(image.getWidth(),
	                        image.getHeight(), BufferedImage.TYPE_INT_ARGB);
	        create_pixel_array(image);
			outputName = my_file.getName();
			
			// runs the manipulations determined by the user
			System.out.println("Enter the manipulations you would like to run on the image.\nYour "
					+ "choices are: brighten, flip, negate, blur, edge, crop, or simplify.\nEnter each "
					+ "manipulation you'd like to run, then type in 'done'.");
			Scanner in = new Scanner(System.in);
			String action = in.next().toLowerCase();
			while (!action.equals("done")) {
	    			try {
		    			if (action.equals("brighten")) {
		    				System.out.println("enter an amount to increase the brightness by");
		    				int brightness = in.nextInt();
		        			Method m = getClass().getDeclaredMethod(action, int.class);
		        			m.invoke(this, brightness);
		    			}
		    			else if (action.equals("flip")) {
		    				System.out.println("enter \"h\" to flip horizontally, anything else to flip vertically.");
		        			Method m = getClass().getDeclaredMethod(action, boolean.class);
		        			m.invoke(this, in.next().equals("h"));
		    			}
		    			else {
		        			Method m = getClass().getDeclaredMethod(action);
		        			m.invoke(this, new Object[0]);
		    			}
		    			System.out.println("done. enter another action, or type 'done'");
	    			}
	    			catch (NoSuchMethodException e) {
	    				System.out.println("not a valid action, try again");
	    			} catch (IllegalAccessException e) {e.printStackTrace();System.exit(1);} 
	    			catch (IllegalArgumentException e) {e.printStackTrace();System.exit(1);}
	    			catch (InvocationTargetException e) {e.printStackTrace();System.exit(1);}
	    			
	    			action = in.next().toLowerCase();
	    		} 
	        in.close();
	        
	        // turns our 2d array of colors into a new png file
	        create_new_image(new_image);
	        File output_file = new File("Images/" + outputName);
	        ImageIO.write(new_image, "png", output_file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
		
    
    public void create_pixel_array(BufferedImage image) {
        w = image.getWidth();
        h = image.getHeight();
        pixels = new Color[h][];
        for (int i = 0; i < h; i++) {
            pixels[i] = new Color[w];
            for (int j = 0; j < w; j++) {
                pixels[i][j] = new Color(image.getRGB(j,i));
            }
        }
    }

    public void create_new_image(BufferedImage new_image) {
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
            		new_image.setRGB(j, i, pixels[i][j].getRGB());
            }
        }
    }

    public static void main(String[] args) {
		new PhotoshopFiller();
	}

    public PhotoshopFiller() {
		run();
    }
}