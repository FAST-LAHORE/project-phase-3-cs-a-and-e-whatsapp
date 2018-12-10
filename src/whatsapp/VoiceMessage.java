/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsapp;

import java.applet.AudioClip;
/**
 *
 * @author Mani
 */
public class VoiceMessage implements Message {
    private AudioClip VoiceMessageAudio;
    public VoiceMessage(AudioClip audio){
        this.VoiceMessageAudio = audio;
    }
}
