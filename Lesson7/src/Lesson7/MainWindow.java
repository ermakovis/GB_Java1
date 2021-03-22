package Lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    public final int AI_MODE = 0;
    public final int PVP_MODE = 1;
    public final int MIN_FIELD_SIZE = 3;
    public final int MAX_FIELD_SIZE = 10;
    //Может настройки лучше хранить в классе SettingsWindow?
    //Орисовывание картинки и сами настройки хочется разделить
    private int gameMode = AI_MODE;
    private int fieldSize = MIN_FIELD_SIZE;
    private int winLength = fieldSize;
    SettingsWindow settingsWindow;
    JPanel gamePanel = new JPanel();

    public int getGameMode() {
        return gameMode;
    }
    public int getFieldSize() {
        return fieldSize;
    }
    public int getWinLength() {
        return winLength;
    }
    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }
    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }
    public void setWinLength(int winLength) {
        this.winLength = winLength;
    }

    private void setMainWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth() ;
        int screenHeight = (int) screenSize.getHeight() ;
        int winWidth = screenWidth / 4 ;
        int winHeight = winWidth;

        setSize(winWidth, winHeight);
        setLocation((screenWidth - winWidth) / 2, (screenHeight - winHeight) / 2) ;
        setTitle("TicTacToe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(gamePanel, BorderLayout.CENTER);
    }

    //Люблю единообразие, понимаю, что эта запись выглядит странно
    private void setSettingsWindow() {
        settingsWindow = new SettingsWindow(this);
    }

    //Есть желание и для каждой кнопки сделать метод
    private void setSouthPanel() {
        JButton btnStart = new JButton("Start");
        JButton btnSettings = new JButton("Settings");
        JButton btnExit = new JButton("Exit");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setGamePanel();
            }
        });
        btnSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(!settingsWindow.isVisible());
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JPanel retPanel = new JPanel(new GridLayout(1,3));
        retPanel.add(btnStart);
        retPanel.add(btnSettings);
        retPanel.add(btnExit);
        add(retPanel, BorderLayout.SOUTH);
    }

    private void setGamePanel() {
        gamePanel.removeAll();
        gamePanel.setLayout(new GridLayout(fieldSize, fieldSize));
        JButton[][] tiles = new JButton[fieldSize][fieldSize];

        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                tiles[x][y] = new JButton();
                gamePanel.add(tiles[x][y]);
                tiles[x][y].setActionCommand(x + " " + y);
            }
        }
        //Актуализирует содержимое панели
        revalidate();
        //Перерисовывает фрейм, для того, чтобы убрать наложение панелек.
        repaint();
    }

    MainWindow() {
        setMainWindow();
        setSettingsWindow();
        setSouthPanel();
        setVisible(true);
    }
}
