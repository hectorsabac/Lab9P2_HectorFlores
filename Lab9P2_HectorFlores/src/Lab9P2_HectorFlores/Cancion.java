/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab9P2_HectorFlores;

import java.io.FileInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javazoom.jl.player.advanced.AdvancedPlayer;

/**
 *
 * @author hecto
 */
public class Cancion {
    public String path;
    private AdvancedPlayer player;
    private FileInputStream fis;
    private Thread hiloPlayer;
    private boolean pausada = false;
    private int framePausa = 0;
    
    String songName;
    String artist;
    String genre;
    
    public Cancion (String path){
        this.path = path;
    }

    public Cancion(String songName, String artist, String genre) {
        this.songName = songName;
        this.artist = artist;
        this.genre = genre;
    }
    
    public void play(){
        try {
            
            if (hiloPlayer != null && !pausada){
                stop();
            }
            
            fis = new FileInputStream(path);
            player = new AdvancedPlayer(fis);
            
            
            if (pausada){
                fis.getChannel().position(framePausa);
                pausada = false;
            }
            
            hiloPlayer = new Thread (() -> {
                try{
                    player.play(framePausa, Integer.MAX_VALUE);
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Ha ocurridoun error");
                    e.printStackTrace();
                }
                
            });
            
            hiloPlayer.start();
            
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado");
        }
    }
    
    public void pause(){
        if (player != null && hiloPlayer != null){
            
            try {
                pausada = true;
                framePausa = (int)(fis.getChannel().position());
                player.close();
                hiloPlayer.interrupt();
            }  catch (Exception e){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado");
                e.printStackTrace();
            }
            
        }
    }
    
    public void stop(){
        if (player != null){
            player.close();
        }
        
        if (hiloPlayer != null){
            hiloPlayer.interrupt();
        }
        
        framePausa = 0;
        pausada = false;
    }

    public String toString(){
        return "Cancion: " + songName + "\nArtista: " + artist + "\nGenero: " + genre;
    }

    public String getPath() {
        return this.path;
    }

    public String getSongName() {
        return songName;
    }
    
    
}
