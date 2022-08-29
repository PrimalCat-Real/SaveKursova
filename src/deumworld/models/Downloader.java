/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deumworld.models;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;

import java.nio.file.Paths;
import javafx.concurrent.Task;

/**
 *
 * @author PrimalCat
 */
public class Downloader extends Task<Void>{
    private URL url;
    private String ext;
    public Downloader(String u) throws MalformedURLException {
        this.url = new URL(u);
        this.ext = u.substring(u.lastIndexOf("."), u.length());
    }
    
    @Override
    protected Void call() throws Exception {
        try (InputStream in = url.openStream()) {
            System.out.println("start download");
            Files.copy(in, Paths.get("test"+ext));
        }
        return null;
    }
    
    @Override 
    protected void failed(){
        System.out.println("fail");
    }
    
    protected void succes(){
        System.out.println("downloaded");
    }
}
