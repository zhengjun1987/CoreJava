package chapter04networks;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2018/5/11 19:59
 * Project:CoreJava
 */
public class InterruptibleSocketFrame extends JFrame {

    private static final int ROWS = 20;
    private static final int COLUMNS = 60;
    final JTextArea mMessages;
    private final JButton mInterruptibleButton;
    private final JButton mBlockingButton;
    private final JButton mCancelButton;
    private Thread mConnectThread;
    private final TestServer mTestServer;
    private Scanner mScanner;

    InterruptibleSocketFrame() throws HeadlessException {
        JPanel northPanel = new JPanel();
        add(northPanel, BorderLayout.NORTH);
        mMessages = new JTextArea(ROWS, COLUMNS);
        add(new JScrollPane(mMessages));

        mInterruptibleButton = new JButton("Interruptible");
        mBlockingButton = new JButton("Blocking");
        mCancelButton = new JButton("Cancel");
        northPanel.add(mInterruptibleButton);
        northPanel.add(mBlockingButton);
        northPanel.add(mCancelButton);
        mCancelButton.setEnabled(false);

        mInterruptibleButton.addActionListener(e -> {
            mInterruptibleButton.setEnabled(false);
            mBlockingButton.setEnabled(false);
            mCancelButton.setEnabled(true);
            mConnectThread = new Thread(() -> {
                connectInterruptibly();
            });
            mConnectThread.start();
        });
        mBlockingButton.addActionListener(event -> {
            mInterruptibleButton.setEnabled(false);
            mBlockingButton.setEnabled(false);
            mCancelButton.setEnabled(true);
            mConnectThread = new Thread(() -> {
                connectBlocking();
            });
            mConnectThread.start();
        });

        mCancelButton.addActionListener(e -> {
            mConnectThread.interrupt();
            mCancelButton.setEnabled(false);
        });

        mTestServer = new TestServer(this);
        new Thread(mTestServer).start();
        pack();
    }

    private void connectBlocking() {
        mMessages.append("Blocking:\n");
        try {
            Socket localhost = new Socket("localhost", 8189);
            mScanner = new Scanner(localhost.getInputStream(), "UTF-8");
            while (!Thread.currentThread().isInterrupted()) {
                mMessages.append("Reading ");
                if (mScanner.hasNextLine()) {
                    mMessages.append(mScanner.nextLine() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            EventQueue.invokeLater(() -> {
                mMessages.append("\nSocket closed\n");
                mInterruptibleButton.setEnabled(true);
                mBlockingButton.setEnabled(true);
            });
        }
    }

    private void connectInterruptibly() {
        mMessages.append("Interruptible:\n");
        try {
            SocketChannel localhost = SocketChannel.open(new InetSocketAddress("localhost", 8189));
            mScanner = new Scanner(localhost, "UTF-8");
            while (!Thread.currentThread().isInterrupted()) {
                mMessages.append("Reading ");
                if (mScanner.hasNextLine()) {
                    mMessages.append(mScanner.nextLine() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            EventQueue.invokeLater(() -> {
                mMessages.append("\nChannel closed\n");
                mInterruptibleButton.setEnabled(true);
                mBlockingButton.setEnabled(true);
            });
        }
    }
}
