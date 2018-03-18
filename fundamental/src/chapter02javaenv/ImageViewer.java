package chapter02javaenv;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2018/3/18 12:40
 * Project:CoreJava
 */
public class ImageViewer {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame vJFrame = new ImageViewerFrame();
                vJFrame.setTitle("ImageViewer");
                vJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                vJFrame.setVisible(true);
            }
        });
    }

}

class ImageViewerFrame extends JFrame {
    private JLabel mJLabel;
    private JFileChooser mJFileChooser;
    public static final int DEF_WIDTH = 300;
    public static final int DEF_LENGTH = 400;

    ImageViewerFrame() throws HeadlessException {
        setSize(DEF_WIDTH,DEF_LENGTH);
        mJLabel = new JLabel();
        add(mJLabel);

        mJFileChooser = new JFileChooser();
        mJFileChooser.setCurrentDirectory(new File("."));

        JMenuBar vJMenuBar = new JMenuBar();
        setJMenuBar(vJMenuBar);

        JMenu vMenu = new JMenu("File");
        vJMenuBar.add(vMenu);

        JMenuItem vOpen = new JMenuItem("Open");
        vMenu.add(vOpen);
        vOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int vShowOpenDialog = mJFileChooser.showOpenDialog(null);
                if (vShowOpenDialog == JFileChooser.APPROVE_OPTION) {
                    String vPath = mJFileChooser.getSelectedFile().getPath();
                    mJLabel.setIcon(new ImageIcon(vPath));
                }
            }
        });

        JMenuItem vExit = new JMenuItem("Exit");
        vMenu.add(vExit);
        vExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
