/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GUI;

import comp_dcomp.compressor;
import comp_dcomp.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The AppFrame class represents the main frame of the application.
 * It contains buttons for compressing and decompressing files.
 * 
 * @author Pintu Giri
 */
public class AppFrame extends JFrame implements ActionListener {
    
    // Buttons for file compression and decompression
    JButton compressButton;
    JButton decompressButton;
    
    // Constructor for AppFrame.
    // Initializes the frame and buttons.
    AppFrame() {
        this.setLayout(null);
        
        // Set default close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Initialize and set properties for the compress button
        compressButton = new JButton("Select file to compress");
        compressButton.setBounds(20, 100, 200, 30);
        compressButton.addActionListener(this);
        
        // Initialize and set properties for the decompress button
        decompressButton = new JButton("Select file to Decompress");
        decompressButton.setBounds(250, 100, 200, 30);
        decompressButton.addActionListener(this);
        
        // Add buttons to the frame
        this.add(compressButton);
        this.add(decompressButton);
        
        // Set frame size, background color, and make it visible
        this.setSize(1000, 500); // Adjusted size for better visibility
        this.getContentPane().setBackground(Color.green);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // If the compress button is clicked
        if (e.getSource() == compressButton) {
            // Show file chooser dialog for saving
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                // Get selected file and call compressor method
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    compressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }

        // If the decompress button is clicked
        if (e.getSource() == decompressButton) {
            // Show file chooser dialog for saving
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                // Get selected file and call decompressor method
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    decompressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}
