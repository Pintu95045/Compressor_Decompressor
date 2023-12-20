/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_dcomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * The `compressor` class provides a method for compressing a file using GZIP compression.
 * It also includes a main method for testing the compression functionality.
 * 
 * @author Pintu Giri
 */
public class compressor {
    
    /**
     * Compresses the specified file using GZIP compression.
     * 
     * @param file The file to be compressed
     * @throws IOException If an I/O error occurs during compression
     */
    public static void method(File file) throws IOException {
        // Get the directory of the file
        String fileDirectory = file.getParent();
        
        // Create FileInputStream for reading the file
        FileInputStream fis = new FileInputStream(file);
        
        // Create FileOutputStream for writing the compressed file
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/CompressedFile.gz");
        
        // Create GZIPOutputStream for compressing data
        GZIPOutputStream gzip = new GZIPOutputStream(fos);
        
        // Buffer for reading and writing data
        byte[] buffer = new byte[1024];
        int len;
        
        // Read from the file and write to the compressed file
        while ((len = fis.read(buffer)) != -1) {
            gzip.write(buffer, 0, len);
        }
        
        // Close streams
        gzip.close();
        fos.close();
        fis.close();
    }
    
    /**
     * Main method for testing the compression functionality.
     * 
     * @param args The command-line arguments (not used in this application)
     * @throws IOException If an I/O error occurs during compression
     */
    public static void main(String[] args) throws IOException {
        // Example: Provide the path to the directory containing the file to be compressed
        File path = new File("/Users/Pintu Giri/COMPRESSOR_DECOMPRESSOR/Testfile");
        
        // Call the compress method
        method(path);
    }
}
