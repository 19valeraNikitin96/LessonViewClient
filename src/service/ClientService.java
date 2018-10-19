package service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ClientService {

    public static String ip;
    public static String port;
    
    public ClientService(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }


}
