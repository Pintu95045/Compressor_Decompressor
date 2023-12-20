/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_dcomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 * The `decompressor` class provides a method for decompressing a GZIP compressed file.
 * It also includes a main method for testing the decompression functionality.
 * 
 * @author Pintu Giri
 */
public class decompressor {
    
    /**
     * Decompresses the specified file that is in GZIP format.
     * 
     * @param file The GZIP compressed file to be decompressed
     * @throws IOException If an I/O error occurs during decompression
     */
    public static void method(File file) throws IOException {
        // Get the directory of the file
        String fileDirectory = file.getParent();
        
        // Create FileInputStream for reading the compressed file
        FileInputStream fis = new FileInputStream(file);
        
        // Create GZIPInputStream for decompressing data
        GZIPInputStream gzip = new GZIPInputStream(fis);
        
        // Create FileOutputStream for writing the decompressed file
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/decompressedFile");
        
        // Buffer for reading and writing data
        byte[] buffer = new byte[1024];
        int len;
        
        // Read from the compressed file and write to the decompressed file
        while ((len = gzip.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        
        // Close streams
        gzip.close();
        fos.close();
        fis.close();
    }
    
    /**
     * Main method for testing the decompression functionality.
     * 
     * @param args The command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        // Example: Provide the path to the compressed file
        File path = new File("Users/Pintu Giri/Downloads/Compressor/compressordecompressor/CompressedFile.gz");
        
        // Call the decompress method
        try {
            method(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
