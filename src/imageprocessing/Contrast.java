/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.awt.image.*; 
import java.net.*; 
import java.awt.*; 
import java.io.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.*; 

public class Contrast
{
    public Contrast(String input) throws Exception
    {
        int width = 963;    //width of the image
           int height = 640;   //height of the image
           BufferedImage image = null;
           try
             {
                File input_file = new File(input); //image file path
                image = new BufferedImage(width, height,
                                     BufferedImage.TYPE_INT_ARGB);
                image = ImageIO.read(input_file);
                System.out.println("Reading complete.");
             }
        catch(IOException e)
          {
              System.out.println("Error: "+e);
          }
  
        // Setting up the scaling and 
        // the offset parameters for processing 
        RescaleOp rop = new RescaleOp(1.75f, 3.6f, null); 
  
        // applying the parameters on the image 
        // by using filter() method, it takes the 
        // Source and destination objects of buffered reader 
        // here our destination object is null 
        BufferedImage bi 
            = rop.filter(image, null); 
        try {
            ImageIO.write(bi, "jpg", 
                    new File("images/contrast.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Contrast.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
