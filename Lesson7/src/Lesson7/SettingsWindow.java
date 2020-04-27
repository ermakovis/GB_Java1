package Lesson7;

//Почему javax.swing.* не включает в себя javax.swing.border?
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SettingsWindow extends JFrame {
    private static final String FIELD_SIZE_PREFIX = "Field size is: ";
    private static final String WIN_LENGTH_PREFIX = "Win length is: ";
    private static int settingsWidth;
    private static int settingsHeight;
    MainWindow mainWindow;

    private void setSettingsWindow () {
        Rectangle rectangle = mainWindow.getBounds();
        Point point = mainWindow.getLocation();
        settingsWidth = rectangle.width / 2;
        settingsHeight = rectangle.height / 2;

        this.setTitle("Settings");
        this.setSize(settingsWidth, settingsHeight);
        this.setLocation(point.x + settingsWidth / 2, point.y + settingsHeight / 2);
        JPanel contentPanel = new JPanel();
        Border padding = BorderFactory.createEmptyBorder(5, 10, 5, 10);
        contentPanel.setBorder(padding);
        this.setContentPane(contentPanel);
        this.setLayout(new FlowLayout());
        this.setVisible(false);
    }

    private void setSettingsGameMode() {
        add(new JLabel("Game mode", SwingConstants.CENTER));

        JRadioButton pve = new JRadioButton("Human vs AI", true);
        pve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.setGameMode(mainWindow.AI_MODE);
            }
        });
        pve.setPreferredSize(new Dimension(settingsWidth - 20, 20));

        JRadioButton pvp = new JRadioButton("Human vs Human");
        pvp.setPreferredSize(new Dimension(settingsWidth - 20, 20));
        pvp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.setGameMode(mainWindow.PVP_MODE);
            }
        });

        ButtonGroup gameModeGroup = new ButtonGroup();
        gameModeGroup.add(pve);
        gameModeGroup.add(pvp);
        add(pve);
        add(pvp);
    }

    private void setSettingsGameField () {
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + mainWindow.MIN_FIELD_SIZE);
        JSlider slideWinLen = new JSlider(mainWindow.MIN_FIELD_SIZE,
                mainWindow.MIN_FIELD_SIZE, mainWindow.MIN_FIELD_SIZE);
        slideWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue  = slideWinLen.getValue();
                lbWinLength.setText(WIN_LENGTH_PREFIX + currentValue);
                mainWindow.setWinLength(currentValue);
            }
        });
        //add(new JLabel("Choose win length"));
        add(lbWinLength);
        add(slideWinLen);


        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + mainWindow.MIN_FIELD_SIZE);
        JSlider slideFieldSize = new JSlider(mainWindow.MIN_FIELD_SIZE,
                mainWindow.MAX_FIELD_SIZE, mainWindow.MIN_FIELD_SIZE);
        slideFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideFieldSize.getValue();
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                slideWinLen.setMaximum(currentValue);
                mainWindow.setFieldSize(currentValue);
            }
        });
        add(lbFieldSize);
        add(slideFieldSize);
    }

    private void setSettingsDoneButton() {
        JButton btnDone = new JButton("Done");
        btnDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.settingsWindow.setVisible(false);
            }
        });
        add(btnDone);
    }

    SettingsWindow (MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setSettingsWindow();
        setSettingsGameMode();
        setSettingsGameField();
        setSettingsDoneButton();
    }
}
