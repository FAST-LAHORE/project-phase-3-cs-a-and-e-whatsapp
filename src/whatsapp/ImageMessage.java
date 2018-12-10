/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsapp;

import java.awt.image.BufferedImage;

/**
 *
 * @author Mani
 */
public class ImageMessage implements Message {
    private BufferedImage ImageMessageImage;
    public ImageMessage (BufferedImage providedImage){
        this.ImageMessageImage = providedImage;
    }
}
