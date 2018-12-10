/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsapp;

import java.io.File;
import oracle.jrockit.jfr.ActiveRecordingEvent;
/**
 *
 * @author Mani
 */
public class VideoMessage implements Message {
    private File videoMessageVideo;
    public VideoMessage(File video){
        this.videoMessageVideo = video;
    }
}
