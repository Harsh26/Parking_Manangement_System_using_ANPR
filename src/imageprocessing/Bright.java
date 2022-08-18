/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import org.opencv.core.Core; 
import org.opencv.core.Mat; 
import org.opencv.imgcodecs.Imgcodecs; 

public class Bright 
{
   static int width; 
   static int height; 
   static double alpha = 1; 
   static double beta = 50; 
     
    public Bright()
    {
       try { 
  
         // For proper execution of native libraries 
         // Core.NATIVE_LIBRARY_NAME must be loaded before 
            // calling any of the opencv methods 
         System.loadLibrary( Core.NATIVE_LIBRARY_NAME ); 
  
         // input image 
         Mat source =   
          Imgcodecs.imread("images/n.jpg", Imgcodecs./*CV_LOAD_IMAGE_COLOR*/IMREAD_UNCHANGED); 
         Mat destination = new Mat(source.rows(), source.cols(), source.type()); 
  
         // applying brightness enhacement 
         source.convertTo(destination, -1, alpha, beta); 
  
         // output image 
         Imgcodecs.imwrite("images/Bright.jpg", destination); 
           
      } catch (Exception e) { 
         System.out.println("error: " + e.getMessage()); 
      }  
    }
}
