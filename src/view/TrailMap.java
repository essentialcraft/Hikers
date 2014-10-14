/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ian
 */
public class TrailMap extends JPanel {
    
    
    
    
    BufferedImage image;

    public TrailMap() {
        try {
            String path = "area_map.png";
            image = ImageIO.read(getClass().getResource(path));
            
            JLabel picLabel = new JLabel(new ImageIcon(image));
            add(picLabel);
        } catch (IOException ex) {
            // handle exception...
        }
    }

    @Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    System.out.println("image is null: " + (image == null)); // TODO: Delete this
    g.drawImage(image, getWidth(), getHeight(), null);      
}
        
        
    }
    

