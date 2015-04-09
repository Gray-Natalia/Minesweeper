/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.swing;

import cit260.winter2015.minesweeper.BestTimeManager;
import cit260.winter2015.minesweeper.BestTimeManagerBeginner;
import cit260.winter2015.minesweeper.BestTimeManagerExpert;
import cit260.winter2015.minesweeper.BestTimeManagerIntermediate;
import cit260.winter2015.minesweeper.CellManager;
import cit260.winter2015.minesweeper.GameVariables;
import cit260.winter2015.minesweeper.Minesweeper;
import cit260.winter2015.minesweeper.enums.GameCodes;
import cit260.winter2015.minesweeper.enums.LevelType;
import cit260.winter2015.minesweeper.exceptions.LoseGameException;
import cit260.winter2015.minesweeper.exceptions.NotBestTimeException;
import cit260.winter2015.minesweeper.exceptions.WinGameException;
import static cit260.winter2015.minesweeper.swing.MainFrame.mainPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.Timer;

/**
 *
 * @author knban_000
 */
public class InGame extends javax.swing.JPanel {

    private int counter = 0;

    private static JToggleButton jButtons[][];

    private static ImageIcon[] img;

    private final ClockListener clock = new ClockListener();
    private final Timer timer = new Timer(53, clock);
    private long startTime;
    public static long elapsed;
    public static String timeString;
    double elapsedSeconds;

    private final PauseClockListener pauseClock = new PauseClockListener();
    public final Timer pauseTimer = new Timer(53, pauseClock);
    private long pauseStart;
    private long pauseElapsed;

    SimpleDateFormat format = new SimpleDateFormat("H:mm:ss");

    /**
     * Creates new form MainMenu
     */
    public InGame() {
        initComponents();
    }

    public void startGame() {
        GameVariables.setGameStatus(GameCodes.PLAYING);
        jbPause.setEnabled(true);
        jButton1.setVisible(false);
        elapsed = 0;
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        statusBarTimer.setText("Time Elapsed: " + format.format(elapsed));
        counter = 0;
        Minesweeper.mm.generateMines();
        Minesweeper.cm.calculateCellValues();
        loadImages();
        BuildBoard();
        statusBarMines.setText("Mines Remaining: " + GameVariables.getNumberOfMines());
        jpBoard.setLayout(new java.awt.GridLayout(GameVariables.getNumberOfRows(), GameVariables.getNumberOfColumns(), -1, -1));
        Minesweeper.mainFrame.pack();
        Minesweeper.mainFrame.setLocationRelativeTo(null);
    }

    public void startGamePreset() {
        GameVariables.setGameStatus(GameCodes.PLAYING);
        jbPause.setEnabled(true);
        jButton1.setVisible(false);
        elapsed = 0;
        counter = 0;
        Minesweeper.mm.presetMines();
        Minesweeper.cm.calculateCellValues();
        loadImages();
        BuildBoard();
        statusBarMines.setText("Mines Remaining: " + GameVariables.getNumberOfMines());
        Minesweeper.mainFrame.resizeWindow(getWidth() + 5, getHeight() + 10);
        Minesweeper.mainFrame.setLocationRelativeTo(null);
    }

    public void BuildBoard() {
        jpBoard.removeAll();
        jButtons = null;
        jButtons = new JToggleButton[GameVariables.getNumberOfRows()][GameVariables.getNumberOfColumns()];
        for (int row = 0; row < GameVariables.getNumberOfRows(); row++) {
            for (int column = 0; column < GameVariables.getNumberOfColumns(); column++) {
                int r = row;
                int c = column;
                jButtons[row][column] = new JToggleButton("");
                jButtons[row][column].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            click(r, c);
                        } else if (e.getButton() == MouseEvent.BUTTON3) {
                            rightClick(r, c);
                        } else if (e.getButton() == MouseEvent.BUTTON2) {
                            twoButtonClick(r, c);
                        }
                    }
                });
                jpBoard.add(jButtons[row][column], BorderLayout.CENTER);
                jButtons[row][column].setToolTipText("");
                jButtons[row][column].setAlignmentY(0.0F);
                jButtons[row][column].setMargin(new java.awt.Insets(0, 0, 0, 0));
                jButtons[row][column].setMaximumSize(new java.awt.Dimension(30, 30));
                jButtons[row][column].setMinimumSize(new java.awt.Dimension(30, 30));
                jButtons[row][column].setPreferredSize(new java.awt.Dimension(30, 30));
                jButtons[row][column].setIcon(img[CellManager.states[row][column]]);
            }
        }
//        Minesweeper.cm.revealAll();
//        updateBoard();
        jpBoard.setVisible(true);
        jpBoard.validate();
        jpBoard.repaint();
        setVisible(true);
        validate();
        repaint();
    }

    public void updateBoard() {
        for (int row = 0; row < GameVariables.getNumberOfRows(); row++) {
            for (int column = 0; column < GameVariables.getNumberOfColumns(); column++) {
                try {
                    jButtons[row][column].setIcon(img[CellManager.states[row][column]]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                }
            }
        }
    }

    public void startTimer() {
        timer.setInitialDelay(0);
        startTime = System.currentTimeMillis();
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    public void updateClock() {
        elapsed = (System.currentTimeMillis() - startTime);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        timeString = ("Time Elapsed: " + format.format(elapsed));
        statusBarTimer.setText("Time Elapsed: " + format.format(elapsed));
    }

    private class ClockListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            updateClock();
        }
    }

    public void resumeTimer() {
        stopPauseTimer();
        startTime += pauseElapsed;
        pauseElapsed = 0;
        timer.start();
    }

    public void startPauseTimer() {
        pauseTimer.setInitialDelay(0);
        pauseStart = System.currentTimeMillis();
        pauseTimer.start();
    }

    public void stopPauseTimer() {
        pauseTimer.stop();
    }

    public void updatePauseClock() {
        pauseElapsed = (System.currentTimeMillis() - pauseStart);
    }

    private class PauseClockListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            updatePauseClock();
        }
    }

    private static void loadImages() {
        img = new ImageIcon[LevelType.NUM_IMAGES];

        for (int i = 0; i < 16; i++) {
            img[i] = new ImageIcon("images/" + i + ".png");
        }
    }

    private void click(int row, int column) {
        if (GameVariables.getGameStatus() == GameCodes.PLAYING) {
            if (counter == 0) {
                counter++;
                startTimer();
            }
            try {
                Minesweeper.cm.click(row, column);
                updateBoard();
            } catch (LoseGameException ex) {
                updateBoard();
                gameLost();
            } catch (WinGameException ex) {
                updateBoard();
                gameWon();
            }
        }
    }

    private void rightClick(int row, int column) {
        if (GameVariables.getGameStatus() == GameCodes.PLAYING) {
            if (counter == 0) {
                counter++;
                startTimer();
            }
            Minesweeper.cm.rightClick(row, column);
            statusBarMines.setText("Mines Remaining: " + Minesweeper.cm.getMinesRemaining());
            updateBoard();
        }
    }

    private void twoButtonClick(int row, int column) {
        if (GameVariables.getGameStatus() == GameCodes.PLAYING) {
            try {
                Minesweeper.cm.twoButtonClick(row, column);
                updateBoard();
            } catch (WinGameException ex) {
                updateBoard();
                gameWon();
            }
        }
    }

    private void gameWon() {
        GameVariables.setGameStatus(GameCodes.NOT_PLAYING);
        jbPause.setEnabled(false);
        stopTimer();
        stopPauseTimer();
        BestTimeManagerBeginner btmb = new BestTimeManagerBeginner();
        BestTimeManagerIntermediate btmi = new BestTimeManagerIntermediate();
        BestTimeManagerExpert btme = new BestTimeManagerExpert();
        elapsedSeconds = elapsed / 1000;

        try {
            switch (GameVariables.getDifficultyLevel()) {
                case "beginner":
                    //Throws NotBestTimeException
                    btmb.checkBestTime(elapsedSeconds);
                    jTextArea4.setText("Congratulations! You made the best times list!"
                            + " Enter your name to be added."
                            + " Your time was " + BestTimeManager.convertTime(elapsedSeconds) + ".");
                    jbHsViewHs.setEnabled(false);
                    jbHsMainMenu.setEnabled(false);
                    jdNewHighScore.setVisible(true);
                    break;
                case "intermediate":
                    //Throws NotBestTimeException
                    btmi.checkBestTime(elapsedSeconds);
                    jTextArea4.setText("Congratulations! You made the best times list!"
                            + " Enter your name to be added."
                            + " Your time was " + BestTimeManager.convertTime(elapsedSeconds) + ".");
                    jbHsViewHs.setEnabled(false);
                    jbHsMainMenu.setEnabled(false);
                    jdNewHighScore.setVisible(true);
                    break;
                case "expert":
                    //Throws NotBestTimeException
                    btme.checkBestTime(elapsedSeconds);
                    jTextArea4.setText("Congratulations! You made the best times list!"
                            + " Enter your name to be added."
                            + " Your time was " + BestTimeManager.convertTime(elapsedSeconds) + ".");
                    jbHsViewHs.setEnabled(false);
                    jbHsMainMenu.setEnabled(false);
                    jdNewHighScore.setVisible(true);
                    break;
                default:
                    jTextArea3.setText("Congratulations! You won the game. The "
                            + GameVariables.getDifficultyLevel() + " level doesn't have a best times list."
                            + " If you'd like to be ranked next time, play Beginner, Intermediate, or Expert.");
                    jdWonGame.setVisible(true);
            }
        } catch (NotBestTimeException ex) {
            double slowestTime = 0;
            switch (GameVariables.getDifficultyLevel()) {
                case "beginner":
                    slowestTime = btmb.getSlowestTime();
                    break;
                case "intermediate":
                    slowestTime = btmi.getSlowestTime();
                    break;
                case "expert":
                    slowestTime = btme.getSlowestTime();
                    break;
            }
            jTextArea3.setText("Congratulations! You won the game. You didn't make the best times list but better luck next time."
                    + " Get faster than " + BestTimeManager.convertTime(slowestTime) + " on the " + GameVariables.getDifficultyLevel() + " level next time to get a high score");
            jdWonGame.setVisible(true);
        }
    }

    private void gameLost() {
        GameVariables.setGameStatus(GameCodes.NOT_PLAYING);
        jbPause.setEnabled(false);
        stopTimer();
        stopPauseTimer();
        jdLostGame.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jdQuitToMainMenu = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jbNoQuit = new javax.swing.JButton();
        jbYesQuit = new javax.swing.JButton();
        jdLostGame = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jbPlayAgain = new javax.swing.JButton();
        jbLostMainMenu = new javax.swing.JButton();
        jdWonGame = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jbWonHs = new javax.swing.JButton();
        jbWonMainMenu = new javax.swing.JButton();
        jdNewHighScore = new javax.swing.JDialog();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jbHsViewHs = new javax.swing.JButton();
        jbHsMainMenu = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtPlayerName = new javax.swing.JTextField();
        jbSubmitName = new javax.swing.JButton();
        jpTitlePanel = new javax.swing.JPanel();
        jlTitle = new javax.swing.JLabel();
        jpTopBar = new javax.swing.JPanel();
        statusBarMines = new javax.swing.JLabel();
        statusBarTimer = new javax.swing.JLabel();
        jpCenerPane = new javax.swing.JPanel();
        jpBoard = new javax.swing.JPanel();
        jpBottomBar = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jbPause = new javax.swing.JButton();
        jbMainMenu = new javax.swing.JButton();

        jdQuitToMainMenu.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jdQuitToMainMenu.setTitle("Quit?");
        jdQuitToMainMenu.setAlwaysOnTop(true);
        jdQuitToMainMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jdQuitToMainMenu.setMinimumSize(new java.awt.Dimension(250, 200));
        jdQuitToMainMenu.setModal(true);
        jdQuitToMainMenu.setResizable(false);
        jdQuitToMainMenu.setLocationRelativeTo(Minesweeper.mainFrame);

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));

        jScrollPane1.setBackground(new java.awt.Color(0, 51, 153));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 51, 153));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Are you sure you want to quit your current game and return to the main menu? (Progress will be lost)");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(0, 51, 153));
        jPanel3.setMaximumSize(new java.awt.Dimension(168, 79));
        jPanel3.setMinimumSize(new java.awt.Dimension(168, 79));
        jPanel3.setLayout(new java.awt.GridLayout(2, 0));

        jbNoQuit.setText("No, I want to keep playing");
        jbNoQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNoQuitActionPerformed(evt);
            }
        });
        jPanel3.add(jbNoQuit);

        jbYesQuit.setText("Yes, Quit to Main Menu");
        jbYesQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbYesQuitActionPerformed(evt);
            }
        });
        jPanel3.add(jbYesQuit);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jdQuitToMainMenuLayout = new javax.swing.GroupLayout(jdQuitToMainMenu.getContentPane());
        jdQuitToMainMenu.getContentPane().setLayout(jdQuitToMainMenuLayout);
        jdQuitToMainMenuLayout.setHorizontalGroup(
            jdQuitToMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdQuitToMainMenuLayout.setVerticalGroup(
            jdQuitToMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jdLostGame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jdLostGame.setTitle("Lost Game");
        jdLostGame.setAlwaysOnTop(true);
        jdLostGame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jdLostGame.setMinimumSize(new java.awt.Dimension(250, 200));
        jdLostGame.setModal(true);
        jdLostGame.setResizable(false);
        jdLostGame.setLocationRelativeTo(Minesweeper.mainFrame);

        jPanel4.setBackground(new java.awt.Color(0, 51, 153));

        jScrollPane2.setBackground(new java.awt.Color(0, 51, 153));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(0, 51, 153));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("Sorry. You hit a mine. Better luck next time!");
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jScrollPane2.setViewportView(jTextArea2);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(0, 51, 153));
        jPanel6.setMaximumSize(new java.awt.Dimension(168, 79));
        jPanel6.setMinimumSize(new java.awt.Dimension(168, 79));
        jPanel6.setLayout(new java.awt.GridLayout(2, 0));

        jbPlayAgain.setText("Play Again");
        jbPlayAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPlayAgainActionPerformed(evt);
            }
        });
        jPanel6.add(jbPlayAgain);

        jbLostMainMenu.setText("Return to Main Menu");
        jbLostMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLostMainMenuActionPerformed(evt);
            }
        });
        jPanel6.add(jbLostMainMenu);

        jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jdLostGameLayout = new javax.swing.GroupLayout(jdLostGame.getContentPane());
        jdLostGame.getContentPane().setLayout(jdLostGameLayout);
        jdLostGameLayout.setHorizontalGroup(
            jdLostGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdLostGameLayout.setVerticalGroup(
            jdLostGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jdWonGame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jdWonGame.setTitle("You Won!");
        jdWonGame.setAlwaysOnTop(true);
        jdWonGame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jdWonGame.setMinimumSize(new java.awt.Dimension(250, 300));
        jdWonGame.setModal(true);
        jdWonGame.setResizable(false);
        jdWonGame.setLocationRelativeTo(Minesweeper.mainFrame);

        jPanel7.setBackground(new java.awt.Color(0, 51, 153));

        jScrollPane3.setBackground(new java.awt.Color(0, 51, 153));
        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(0, 51, 153));
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextArea3.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setText("Congratulations! You won the game. You didn't make the best times list but better luck next time.");
        jTextArea3.setWrapStyleWord(true);
        jTextArea3.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jScrollPane3.setViewportView(jTextArea3);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(new java.awt.Color(0, 51, 153));
        jPanel9.setMaximumSize(new java.awt.Dimension(168, 79));
        jPanel9.setMinimumSize(new java.awt.Dimension(168, 79));
        jPanel9.setLayout(new java.awt.GridLayout(2, 0));

        jbWonHs.setText("View High Scores");
        jbWonHs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbWonHsActionPerformed(evt);
            }
        });
        jPanel9.add(jbWonHs);

        jbWonMainMenu.setText("Return to Main Menu");
        jbWonMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbWonMainMenuActionPerformed(evt);
            }
        });
        jPanel9.add(jbWonMainMenu);

        jPanel8.add(jPanel9, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jdWonGameLayout = new javax.swing.GroupLayout(jdWonGame.getContentPane());
        jdWonGame.getContentPane().setLayout(jdWonGameLayout);
        jdWonGameLayout.setHorizontalGroup(
            jdWonGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdWonGameLayout.setVerticalGroup(
            jdWonGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jdNewHighScore.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jdNewHighScore.setTitle("New High Score");
        jdNewHighScore.setAlwaysOnTop(true);
        jdNewHighScore.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jdNewHighScore.setMinimumSize(new java.awt.Dimension(250, 300));
        jdNewHighScore.setModal(true);
        jdNewHighScore.setResizable(false);
        jdNewHighScore.setLocationRelativeTo(Minesweeper.mainFrame);

        jPanel11.setBackground(new java.awt.Color(0, 51, 153));

        jScrollPane4.setBackground(new java.awt.Color(0, 51, 153));
        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea4.setEditable(false);
        jTextArea4.setBackground(new java.awt.Color(0, 51, 153));
        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextArea4.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(5);
        jTextArea4.setText("Congratulations! You made the best times list! Enter your name to be added. Your time was " + InGame.timeString + ".");
        jTextArea4.setWrapStyleWord(true);
        jTextArea4.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jScrollPane4.setViewportView(jTextArea4);

        jPanel12.setLayout(new java.awt.BorderLayout());

        jPanel13.setBackground(new java.awt.Color(0, 51, 153));
        jPanel13.setMaximumSize(new java.awt.Dimension(168, 79));
        jPanel13.setMinimumSize(new java.awt.Dimension(168, 79));
        jPanel13.setLayout(new java.awt.GridLayout(2, 0));

        jbHsViewHs.setText("View High Scores");
        jbHsViewHs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHsViewHsActionPerformed(evt);
            }
        });
        jPanel13.add(jbHsViewHs);

        jbHsMainMenu.setText("Return to Main Menu");
        jbHsMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHsMainMenuActionPerformed(evt);
            }
        });
        jPanel13.add(jbHsMainMenu);

        jPanel12.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel14.setBackground(new java.awt.Color(0, 51, 153));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Player Name:");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtPlayerName)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(0, 0, 0))
        );

        jbSubmitName.setText("Submit");
        jbSubmitName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSubmitNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSubmitName)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbSubmitName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jdNewHighScoreLayout = new javax.swing.GroupLayout(jdNewHighScore.getContentPane());
        jdNewHighScore.getContentPane().setLayout(jdNewHighScoreLayout);
        jdNewHighScoreLayout.setHorizontalGroup(
            jdNewHighScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdNewHighScoreLayout.setVerticalGroup(
            jdNewHighScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(0, 51, 153));
        setMinimumSize(new java.awt.Dimension(400, 450));
        setPreferredSize(new java.awt.Dimension(400, 450));
        setLayout(new java.awt.GridBagLayout());

        jpTitlePanel.setBackground(new java.awt.Color(0, 51, 153));
        jpTitlePanel.setMaximumSize(new java.awt.Dimension(32767, 37));
        jpTitlePanel.setMinimumSize(new java.awt.Dimension(248, 46));
        jpTitlePanel.setPreferredSize(new java.awt.Dimension(500, 46));

        jlTitle.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        jlTitle.setForeground(new java.awt.Color(240, 240, 240));
        jlTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitle.setText("Minesweeper");
        jlTitle.setToolTipText("");
        jlTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jlTitle.setMaximumSize(new java.awt.Dimension(2000, 37));

        javax.swing.GroupLayout jpTitlePanelLayout = new javax.swing.GroupLayout(jpTitlePanel);
        jpTitlePanel.setLayout(jpTitlePanelLayout);
        jpTitlePanelLayout.setHorizontalGroup(
            jpTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jpTitlePanelLayout.setVerticalGroup(
            jpTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTitlePanelLayout.createSequentialGroup()
                .addComponent(jlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(jpTitlePanel, gridBagConstraints);

        jpTopBar.setBackground(new java.awt.Color(0, 51, 153));
        jpTopBar.setMaximumSize(new java.awt.Dimension(32767, 25));
        jpTopBar.setMinimumSize(new java.awt.Dimension(227, 25));
        jpTopBar.setLayout(new java.awt.GridBagLayout());

        statusBarMines.setBackground(new java.awt.Color(0, 51, 153));
        statusBarMines.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        statusBarMines.setForeground(new java.awt.Color(255, 255, 255));
        statusBarMines.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusBarMines.setText("Mines Remaining: " + GameVariables.getNumberOfMines());
        statusBarMines.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        statusBarMines.setMaximumSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jpTopBar.add(statusBarMines, gridBagConstraints);

        statusBarTimer.setBackground(new java.awt.Color(0, 51, 153));
        statusBarTimer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        statusBarTimer.setForeground(new java.awt.Color(255, 255, 255));
        statusBarTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusBarTimer.setText("Time Elapsed: " + 0);
        statusBarTimer.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        statusBarTimer.setMaximumSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jpTopBar.add(statusBarTimer, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(jpTopBar, gridBagConstraints);

        jpCenerPane.setBackground(new java.awt.Color(0, 51, 153));
        jpCenerPane.setMinimumSize(new java.awt.Dimension(280, 200));
        jpCenerPane.setName(""); // NOI18N
        jpCenerPane.setPreferredSize(new java.awt.Dimension(280, 200));

        jpBoard.setBackground(new java.awt.Color(0, 51, 153));
        jpBoard.setMinimumSize(new java.awt.Dimension(280, 280));
        jpBoard.setName(""); // NOI18N
        jpBoard.setLayout(new java.awt.GridLayout(9, 9, -1, -1));
        jpCenerPane.add(jpBoard);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        add(jpCenerPane, gridBagConstraints);

        jpBottomBar.setBackground(new java.awt.Color(0, 51, 153));
        jpBottomBar.setMaximumSize(new java.awt.Dimension(32767, 43));
        jpBottomBar.setMinimumSize(new java.awt.Dimension(193, 43));
        jpBottomBar.setPreferredSize(new java.awt.Dimension(280, 43));
        jpBottomBar.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Reveal All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 0);
        jpBottomBar.add(jButton1, gridBagConstraints);

        jbPause.setText("Pause");
        jbPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPauseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 5);
        jpBottomBar.add(jbPause, gridBagConstraints);

        jbMainMenu.setText("Quit to MainMenu");
        jbMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMainMenuActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 10);
        jpBottomBar.add(jbMainMenu, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(jpBottomBar, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jbMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMainMenuActionPerformed
        if (GameVariables.getGameStatus() == GameCodes.PLAYING) {
            stopTimer();
            startPauseTimer();
            MainFrame.card.show(mainPanel, "paused");
            jdQuitToMainMenu.setVisible(true);
        } else if (GameVariables.getGameStatus() == GameCodes.NOT_PLAYING) {
            stopPauseTimer();
            stopTimer();
            MainFrame.card.show(mainPanel, "mainMenu");
            Minesweeper.mainFrame.resizeWindow(500, 400);
        }
    }//GEN-LAST:event_jbMainMenuActionPerformed

    private void jbPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPauseActionPerformed
        stopTimer();
        startPauseTimer();
        MainFrame.card.show(mainPanel, "paused");
    }//GEN-LAST:event_jbPauseActionPerformed

    private void jbNoQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNoQuitActionPerformed
        jdQuitToMainMenu.dispose();
        MainFrame.card.show(mainPanel, "inGame");
        resumeTimer();
    }//GEN-LAST:event_jbNoQuitActionPerformed

    private void jbYesQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbYesQuitActionPerformed
        stopPauseTimer();
        stopTimer();
        MainFrame.card.show(mainPanel, "mainMenu");
        jdQuitToMainMenu.dispose();
        Minesweeper.mainFrame.resizeWindow(500 , 400);
    }//GEN-LAST:event_jbYesQuitActionPerformed

    private void jbPlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPlayAgainActionPerformed
        MainFrame.card.show(mainPanel, "levelSelection");
        jdLostGame.dispose();
        Minesweeper.mainFrame.resizeWindow(500 , 400);
    }//GEN-LAST:event_jbPlayAgainActionPerformed

    private void jbLostMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLostMainMenuActionPerformed
        MainFrame.card.show(mainPanel, "mainMenu");
        jdLostGame.dispose();
        Minesweeper.mainFrame.resizeWindow(500 , 400);
    }//GEN-LAST:event_jbLostMainMenuActionPerformed

    private void jbWonHsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbWonHsActionPerformed
        MainFrame.card.show(mainPanel, "bestTimesMenu");
        jdWonGame.dispose();
        Minesweeper.mainFrame.resizeWindow(500 , 400);
    }//GEN-LAST:event_jbWonHsActionPerformed

    private void jbWonMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbWonMainMenuActionPerformed
        MainFrame.card.show(mainPanel, "mainMenu");
        jdWonGame.dispose();
        Minesweeper.mainFrame.resizeWindow(500 , 400);
    }//GEN-LAST:event_jbWonMainMenuActionPerformed

    private void jbHsViewHsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHsViewHsActionPerformed
        MainFrame.card.show(mainPanel, "bestTimesMenu");
        jdNewHighScore.dispose();
        Minesweeper.mainFrame.resizeWindow(500 , 400);
    }//GEN-LAST:event_jbHsViewHsActionPerformed

    private void jbHsMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHsMainMenuActionPerformed
        MainFrame.card.show(mainPanel, "mainMenu");
        jdNewHighScore.dispose();
        Minesweeper.mainFrame.resizeWindow(500 , 400);
    }//GEN-LAST:event_jbHsMainMenuActionPerformed

    private void jbSubmitNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSubmitNameActionPerformed
        BestTimeManagerBeginner btmb = new BestTimeManagerBeginner();
        BestTimeManagerIntermediate btmi = new BestTimeManagerIntermediate();
        BestTimeManagerExpert btme = new BestTimeManagerExpert();
        if (jtPlayerName.getText().length() < 1) {
            JOptionPane.showMessageDialog(Minesweeper.mainFrame, "Please enter a player name.", "Name Error", JOptionPane.WARNING_MESSAGE);
        } else if (jtPlayerName.getText().length() > 15) {
            JOptionPane.showMessageDialog(Minesweeper.mainFrame, "Player name is too long. Max of 15 characters.", "Name Error", JOptionPane.WARNING_MESSAGE);
        } else {
            GameVariables.setPlayerName(jtPlayerName.getText());
            switch (GameVariables.getDifficultyLevel()) {
                case "beginner":
                    btmb.addBestTime(GameVariables.playerName, elapsedSeconds);
                    break;
                case "intermediate":
                    btmi.addBestTime(GameVariables.playerName, elapsedSeconds);
                    break;
                case "expert":
                    btme.addBestTime(GameVariables.playerName, elapsedSeconds);
                    break;
            }
            jbHsViewHs.setEnabled(true);
            jbHsMainMenu.setEnabled(true);
            jtPlayerName.setEnabled(false);
            jbSubmitName.setEnabled(false);
        }
    }//GEN-LAST:event_jbSubmitNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Minesweeper.cm.revealAll();
        updateBoard();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JButton jbHsMainMenu;
    private javax.swing.JButton jbHsViewHs;
    private javax.swing.JButton jbLostMainMenu;
    private javax.swing.JButton jbMainMenu;
    private javax.swing.JButton jbNoQuit;
    private javax.swing.JButton jbPause;
    private javax.swing.JButton jbPlayAgain;
    private javax.swing.JButton jbSubmitName;
    private javax.swing.JButton jbWonHs;
    private javax.swing.JButton jbWonMainMenu;
    private javax.swing.JButton jbYesQuit;
    private javax.swing.JDialog jdLostGame;
    private javax.swing.JDialog jdNewHighScore;
    private javax.swing.JDialog jdQuitToMainMenu;
    private javax.swing.JDialog jdWonGame;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JPanel jpBoard;
    private javax.swing.JPanel jpBottomBar;
    private javax.swing.JPanel jpCenerPane;
    private javax.swing.JPanel jpTitlePanel;
    private javax.swing.JPanel jpTopBar;
    private javax.swing.JTextField jtPlayerName;
    private javax.swing.JLabel statusBarMines;
    private javax.swing.JLabel statusBarTimer;
    // End of variables declaration//GEN-END:variables
}
