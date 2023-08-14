import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ChatPanel extends JPanel {

    JLabel eLabel, m1Label, m2Label, m3Label;
    JPanel ePanel, m1Panel, m2Panel, m3Panel;

    JButton tButton;

    ImageIcon empty = new ImageIcon("./Images/empty.png");
    ImageIcon msg1 = new ImageIcon("./Images/msg1.png");
    ImageIcon msg2 = new ImageIcon("./Images/msg2.png");
    ImageIcon msg3 = new ImageIcon("./Images/msg3.png");
    ImageIcon button = new ImageIcon("./Images/button.png");

    public ChatPanel() {
        setPanel();
        setComponent();
        addListener();
    }

    void setPanel() {

        setLayout(new GridLayout(5,1));

        ePanel = new JPanel();
        m1Panel = new JPanel();
        m2Panel = new JPanel();
        m3Panel = new JPanel();;

        eLabel = new JLabel(empty); 
        m1Label = new JLabel(msg1);
        m2Label = new JLabel(msg2);
        m3Label = new JLabel(msg3);

        tButton = new JButton(button);

        ePanel.add(eLabel);        add(ePanel);
        m1Panel.add(m1Label);    add(m1Panel);
        m2Panel.add(m2Label);    add(m2Panel);
        m3Panel.add(m3Label);    add(m3Panel);

        add(tButton);
    }

    void setComponent() {
        ePanel.setBackground(Color.white);
        m1Panel.setBackground(Color.white);
        m2Panel.setBackground(Color.white);
        m3Panel.setBackground(Color.white);

        setBackground(Color.white);
    }

    void addListener() {
        tButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InetAddress ia = InetAddress.getLocalHost();
                    String ip_str = ia.toString();
                    String ip = ip_str.substring(ip_str.indexOf("/") + 1);
                    new ClientGui(ip, 5420);
                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}