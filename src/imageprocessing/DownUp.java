/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.URL;

public class DownUp {

   public void mymethod() throws Exception {
   
      try{
         String fileName = "digital_image_processing.jpg";
         String website = "http://tutorialspoint.com/java_dip/images/"+fileName;
         
         System.out.println("Downloading File From: " + website);
         
         URL url = new URL(website);
         InputStream inputStream = url.openStream();
         OutputStream outputStream = new FileOutputStream(fileName);
         byte[] buffer = new byte[2048];
         
         int length = 0;
         
         while ((length = inputStream.read(buffer)) != -1) {
            System.out.println("Buffer Read of length: " + length);
            outputStream.write(buffer, 0, length);
         }
         
         inputStream.close();
         outputStream.close();
         
      } catch(Exception e) {
         System.out.println("Exception: " + e.getMessage());
      }
   }
}
