/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Ian
 */
public class TrailMap extends JPanel {
    
    private BufferedImage map;
    
    public TrailMap(){
        //map = new BufferedImage(100, 100, 100);
        
        this.setSize(600, 400);
        
    }
    
}
