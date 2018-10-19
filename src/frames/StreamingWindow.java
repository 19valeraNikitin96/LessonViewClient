
package frames;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import service.ClientService;

public class StreamingWindow extends javax.swing.JFrame {

    public StreamingWindow(String ip, String port) {
        initComponents();
        streaming(ip, port);
    }
    
    public void streaming(String ip, String port){
        
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Socket s = null;
                    BufferedImage bi;
                    while (true) {
                        if (s == null) {
                            try {
                                s = new Socket(ip, Integer.parseInt(port));

                                bi = ImageIO.read(ImageIO.createImageInputStream(s.getInputStream()));

                                streamingArea.setIcon(new ImageIcon(bi));
                                s.close();
                                s = null;
                            } catch (IOException ex) {
                                Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                    }
                }
            }
        });
        th.start();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        streamingArea = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(streamingArea, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(streamingArea, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel streamingArea;
    // End of variables declaration//GEN-END:variables
}
