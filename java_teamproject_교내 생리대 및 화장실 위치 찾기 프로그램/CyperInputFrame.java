import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CyperInputFrame extends JFrame {
    private JSlider cyperSlider;
    private JLabel valueLabel;
    private JButton submitButton;
    private int cyper;
	Font f1 = new Font("���� ���", Font.BOLD, 15);

    public CyperInputFrame() {
        setTitle("���� �ֱ� �Է�");
        setSize(300, 200);
		setLocation(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel sliderPanel = createSliderPanel();
		add(sliderPanel, BorderLayout.CENTER);

        JPanel buttonPanel = createButtonPanel();
		buttonPanel.setOpaque(true);
		buttonPanel.setBackground(Color.WHITE);
        add(buttonPanel, BorderLayout.SOUTH);
    }
	
    private JPanel createSliderPanel() {
        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new BorderLayout());
		sliderPanel.setBackground(Color.WHITE);


        cyperSlider = new JSlider(JSlider.HORIZONTAL, 15, 45, 28);
        cyperSlider.setMajorTickSpacing(2); 
        cyperSlider.setPaintTicks(true); 
        cyperSlider.setPaintLabels(true);
		cyperSlider.setBackground(Color.WHITE);
		
        cyperSlider.addChangeListener(e -> {
            int value = cyperSlider.getValue(); 
            valueLabel.setText("�ֱ�: " + value);
        });

        valueLabel = new JLabel("�ֱ�: " + cyperSlider.getValue(), SwingConstants.CENTER); 
		valueLabel.setFont(f1);
		
        sliderPanel.add(cyperSlider, BorderLayout.CENTER);
        sliderPanel.add(valueLabel, BorderLayout.SOUTH);

        return sliderPanel; 
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);

        submitButton = new JButton("Ȯ��");
		submitButton.setBackground(Color.WHITE);
		submitButton.setFont(f1);

		submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cyper = cyperSlider.getValue(); 

            UIManager.put("OptionPane.background", Color.WHITE);
            UIManager.put("Panel.background", Color.WHITE);
            JDialog dialog = new JDialog();
			dialog.setFont(f1);
            JOptionPane.showMessageDialog(dialog, "�Է��Ͻ� �ֱ�: " + cyper);
            dialog.dispose();
			dispose();

            }
        });
		
        buttonPanel.add(submitButton);
        return buttonPanel;
    }

    public int getCyper() {
        return cyper;
    }
}
