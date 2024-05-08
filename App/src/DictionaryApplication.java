import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class DictionaryApplication {
    private Dictionary dictionary=new Dictionary();
    private DictionaryManagement management=new DictionaryManagement();
    private DictionaryCommandLine dictionaryCommandLine=new DictionaryCommandLine();
    public Word addWord2(String target,String explain) {
        return new Word(target, explain);
    }
    public ArrayList<Word> lookup(Dictionary dictionary, String keyword) {
        ArrayList<Word> results = new ArrayList<>();
        for (Word word : dictionary.getWords()) {
            if (word.getWord_target().equalsIgnoreCase(keyword)) {
                results.add(word);
            }
        }
        return results;
    }
    public void ConsoleWindow(){
        Font fontDam = new Font("Calibri",Font.BOLD,60);
        Font thanhTimKiem = new Font("Times New Roman",Font.TRUETYPE_FONT,40);
        Font ketqua=new Font("Arial",Font.BOLD,20);
        Font fontNho= new Font("Calibri",Font.TRUETYPE_FONT,10);
        Font fontVua= new Font("Calibri",0,40);
        management.insertFromFile(dictionary);
        JFrame consoleWindow=new JFrame();
        consoleWindow.setTitle("Dictionary");
        consoleWindow.setSize(1200,800);
        consoleWindow.setLocationRelativeTo(null);
        consoleWindow.setLayout(new BorderLayout());
        JPanel main_screen=new JPanel();
        main_screen.setLayout(new GridLayout(2,3,50,50));
        JButton searchButton=new JButton("Tìm từ");
        searchButton.setFont(fontDam);
        JButton addWordButton=new JButton("Thêm từ");
        addWordButton.setFont(fontDam);
        JButton removeWordButton=new JButton("Xóa từ");
        removeWordButton.setFont(fontDam);
        JButton lookupButton=new JButton("Dịch từ");
        lookupButton.setFont(fontDam);
        JButton updateButton = new JButton("Sửa từ");
        updateButton.setFont(fontDam);
        JButton game=new JButton("Game");
        game.setFont(fontDam);

        searchButton.setBackground(Color.green);
        searchButton.setForeground(Color.WHITE);
        lookupButton.setBackground(Color.green);
        lookupButton.setForeground(Color.WHITE);
        addWordButton.setBackground(Color.green);
        addWordButton.setForeground(Color.WHITE);
        removeWordButton.setBackground(Color.green);
        removeWordButton.setForeground(Color.WHITE);
        updateButton.setBackground(Color.green);
        updateButton.setForeground(Color.WHITE);
        game.setBackground(Color.green);
        game.setForeground(Color.WHITE);

        URL url = DictionaryApplication.class.getResource("Papirus-Team-Papirus-Apps-Pingus-icon.512.png");
        Image img = Toolkit.getDefaultToolkit().createImage(url);
        consoleWindow.setIconImage(img);
        searchButton.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DictionaryApplication.class.getResource("Jommans-Mushroom-Search.256.png")).getScaledInstance(100,100,Image.SCALE_SMOOTH )));
        lookupButton.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DictionaryApplication.class.getResource("Martz90-Hex-Google-translate.512.png")).getScaledInstance(100,100,Image.SCALE_SMOOTH )));
        addWordButton.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DictionaryApplication.class.getResource("Kyo-Tux-Delikate-Add.512.png")).getScaledInstance(100,100,Image.SCALE_SMOOTH )));
        removeWordButton.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DictionaryApplication.class.getResource("Icojam-Blue-Bits-Symbol-delete.256.png")).getScaledInstance(100,100,Image.SCALE_SMOOTH )));
        updateButton.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DictionaryApplication.class.getResource("Oxygen-Icons.org-Oxygen-Apps-system-software-update.256.png")).getScaledInstance(100,100,Image.SCALE_SMOOTH )));
        game.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DictionaryApplication.class.getResource("Dtafalonso-Android-Lollipop-Play-Games.512.png")).getScaledInstance(100,100,Image.SCALE_SMOOTH )));;

        main_screen.add(searchButton);
        main_screen.add(lookupButton);
        main_screen.add(addWordButton);
        main_screen.add(removeWordButton);
        main_screen.add(updateButton);
        main_screen.add(game);

        JPanel search_screen=new JPanel();
        search_screen.setLayout(new BorderLayout(20,20));
        JPanel search_C=new JPanel();
        search_C.setLayout(new BorderLayout());
        JTextField searchTarget =new JTextField();
        JButton search=new JButton("Tra từ");
        JButton exit1= new JButton("Thoát");
        JPanel search_CC=new JPanel();
        search_CC.setLayout(new BorderLayout());
        search_CC.add(search,BorderLayout.WEST);
        search_CC.add(exit1,BorderLayout.EAST);

        search_C.add(searchTarget, BorderLayout.CENTER);
        search_C.add(search_CC,BorderLayout.EAST);
        search_screen.add(search_C,BorderLayout.NORTH)   ;
        JTextArea searchExplain =new JTextArea(8,10);
        JScrollPane searchExplainPane= new JScrollPane(searchExplain, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        search_screen.add(searchExplainPane, BorderLayout.CENTER);
        searchTarget.setFont(thanhTimKiem);






        JPanel lookup_screen=new JPanel();
        JPanel lookup_C=new JPanel();
        lookup_screen.setLayout(new BorderLayout(20,20));
        lookup_C.setLayout(new BorderLayout());
        JTextField lookupTarget= new JTextField();
        JButton lookup = new JButton("Tìm kiếm");
        JTextArea lookupExplain=new JTextArea(8,10);
        JPanel lookup_CC= new JPanel();
        lookup_CC.setLayout(new BorderLayout());
        JButton exit2=new JButton("Thoát");
        lookup_CC.add(lookup,BorderLayout.WEST);
        lookup_CC.add(exit2,BorderLayout.EAST);
        lookup_C.add(lookupTarget,BorderLayout.CENTER);
        lookup_C.add(lookup_CC,BorderLayout.EAST);
        lookup_screen.add(lookup_C,BorderLayout.NORTH);
        lookup_screen.add(lookupExplain,BorderLayout.CENTER);
        lookupTarget.setFont(thanhTimKiem);
        lookupExplain.setFont(thanhTimKiem);


        consoleWindow.add(main_screen,BorderLayout.CENTER);

        JPanel addWordScreen= new JPanel();
        addWordScreen.setLayout(new BorderLayout());
        JTextArea addWordTarget = new JTextArea();
        addWordTarget.setFont(thanhTimKiem);
        JTextArea addWordEx=new JTextArea();
        addWordEx.setFont(thanhTimKiem);
        JButton exit3=new JButton("Thoát");
        JButton addWord= new JButton("Thêm từ");
        JPanel addWordC= new JPanel();
        addWordC.setLayout(new BorderLayout());
        addWordC.add(exit3, BorderLayout.SOUTH);
        addWordC.add(addWord,BorderLayout.NORTH);
        JPanel addWordS=new JPanel();
        JLabel thong_Bao1=new JLabel("Từ tiếng anh");
        JLabel thong_Bao2=new JLabel("Từ tiếng việt");
        thong_Bao1.setFont(thanhTimKiem);
        thong_Bao2.setFont(thanhTimKiem);
        JLabel ket_qua= new JLabel();
        ket_qua.setFont(ketqua);
        addWordS.setLayout(new GridLayout(3,1,0,20));
        JPanel addUP=new JPanel();
        addUP.setLayout(new BorderLayout());
        addUP.add(thong_Bao1,BorderLayout.NORTH);
        addUP.add(addWordTarget,BorderLayout.CENTER);
        JPanel addDOWN=new JPanel();
        addDOWN.setLayout(new BorderLayout());
        addDOWN.add(thong_Bao2,BorderLayout.NORTH);
        addDOWN.add(addWordEx,BorderLayout.CENTER);
        addWordS.add(addUP);
        addWordS.add(addDOWN);
        addWordS.add(ket_qua);
        addWordTarget.setFont(thanhTimKiem);
        addWordEx.setFont(thanhTimKiem);
        thong_Bao1.setFont(fontVua);
        thong_Bao2.setFont(fontVua);
        ket_qua.setFont(fontVua);
        ket_qua.setBackground(Color.GRAY);
        addWordScreen.add(addWordS,BorderLayout.CENTER);
        addWordScreen.add(addWordC,BorderLayout.EAST);
        addWordTarget.setBackground(Color.CYAN);
        addWordEx.setBackground(Color.CYAN);



        JPanel removeWordScreen= new JPanel();
        removeWordScreen.setLayout(new BorderLayout());
        JTextArea removeWordTarget = new JTextArea();
        removeWordTarget.setFont(thanhTimKiem);
        JLabel removeWordEx=new JLabel();
        removeWordEx.setFont(fontVua);
        JButton exit4=new JButton("Thoát");
        JButton removeWord= new JButton("Xóa từ");
        JPanel removeWordC= new JPanel();
        removeWordC.setLayout(new BorderLayout());
        removeWordC.add(exit4, BorderLayout.SOUTH);
        removeWordC.add(removeWord,BorderLayout.NORTH);
        JPanel removeWordS=new JPanel();
        removeWordS.setLayout(new BorderLayout());
        JPanel removeUP = new JPanel();
        removeUP.setLayout(new BorderLayout());
        JLabel r_TB1=new JLabel("Nhập từ cần xóa");
        r_TB1.setFont(fontVua);
        removeUP.add(r_TB1,BorderLayout.NORTH);
        removeUP.add(removeWordTarget,BorderLayout.CENTER);
        removeWordS.add(removeUP,BorderLayout.CENTER);
        removeWordS.add(removeWordEx,BorderLayout.SOUTH);
        removeWordScreen.add(removeWordS,BorderLayout.CENTER);
        removeWordScreen.add(removeWordC,BorderLayout.EAST);
        removeWordTarget.setBackground(Color.CYAN);

        JPanel updateWordScreen= new JPanel();
        updateWordScreen.setLayout(new BorderLayout());
        JTextArea updateWordTarget = new JTextArea();
        updateWordTarget.setFont(thanhTimKiem);
        JTextArea updateWordEx=new JTextArea();
        updateWordEx.setFont(thanhTimKiem);
        JButton exit5=new JButton("Thoát");
        JButton updateWord= new JButton("Sửa từ");
        JPanel updateWordC= new JPanel();
        updateWordC.setLayout(new BorderLayout());
        updateWordC.add(exit5, BorderLayout.SOUTH);
        updateWordC.add(updateWord,BorderLayout.NORTH);
        JPanel updateWordS=new JPanel();
        JLabel u_TB1=new JLabel("Nhập từ tiếng anh cấn sửa: ");
        JLabel u_TB2=new JLabel("Nghĩa mới:  ");
        JLabel u_KQ=new JLabel();
        JPanel updateUP=new JPanel();
        updateUP.setLayout(new BorderLayout());
        updateUP.add(u_TB1,BorderLayout.NORTH);
        updateUP.add(updateWordTarget,BorderLayout.CENTER);
        JPanel updateDOWN=new JPanel();
        updateDOWN.setLayout(new BorderLayout());
        updateDOWN.add(u_TB2,BorderLayout.NORTH);
        updateDOWN.add(updateWordEx,BorderLayout.CENTER);
        u_TB1.setFont(fontVua);
        u_TB2.setFont(fontVua);
        u_KQ.setFont(fontVua);

        updateWordS.setLayout(new GridLayout(3,1));
        updateWordS.add(updateUP);
        updateWordS.add(updateDOWN);
        updateWordS.add(u_KQ);
        updateWordScreen.add(updateWordS,BorderLayout.CENTER);
        updateWordScreen.add(updateWordC,BorderLayout.EAST);




        JPanel gameScreen = new JPanel();
        gameScreen.setLayout(new BorderLayout());
        JLabel question=new JLabel("Whoever hold this long stick....");
        JPanel answer=new JPanel();
        question.setFont(fontDam);
        answer.setLayout(new GridLayout(2,2));
        JButton answerA=new JButton("A");
        JButton answerB=new JButton("B");
        JButton answerC=new JButton("C");
        JButton answerD=new JButton("D");
        answer.add(answerA);
        answer.add(answerB);
        answer.add(answerC);
        answer.add(answerD);
        gameScreen.add(question, BorderLayout.NORTH);
        gameScreen.add(answer, BorderLayout.CENTER);

        JPanel gameTBwin=new JPanel();
        JPanel gameTBlose=new JPanel();
        gameTBwin.setLayout(new BorderLayout());
        JLabel win= new JLabel("Khôn phết");
        JButton exitwin=new JButton("Thoát");
        JButton nextwin=new JButton("Tiếp");
        JPanel winC=new JPanel();
        winC.setLayout(new BorderLayout());
        winC.add(exitwin, BorderLayout.WEST);
        winC.add(nextwin,BorderLayout.EAST);
        gameTBwin.add(win, BorderLayout.CENTER);
        gameTBwin.add(winC,BorderLayout.SOUTH);

        gameTBlose.setLayout(new BorderLayout());
        JLabel lose= new JLabel("Ngu phết");
        JButton exitlose=new JButton("Thoát");
        JButton replaylose=new JButton("Thử lại");
        JPanel loseC=new JPanel();
        loseC.setLayout(new BorderLayout());
        loseC.add(exitlose, BorderLayout.WEST);
        loseC.add(replaylose,BorderLayout.EAST);
        gameTBlose.add(lose, BorderLayout.CENTER);
        gameTBlose.add(loseC,BorderLayout.SOUTH);

        exit1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DictionaryApplication.class.getResource("Custom-Icon-Design-Flatastic-8-Go-back.512.png")).getScaledInstance(40,40,Image.SCALE_SMOOTH )));
        exit2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DictionaryApplication.class.getResource("Custom-Icon-Design-Flatastic-8-Go-back.512.png")).getScaledInstance(40,40,Image.SCALE_SMOOTH )));
        exit3.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DictionaryApplication.class.getResource("Custom-Icon-Design-Flatastic-8-Go-back.512.png")).getScaledInstance(40,40,Image.SCALE_SMOOTH )));
        exit4.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DictionaryApplication.class.getResource("Custom-Icon-Design-Flatastic-8-Go-back.512.png")).getScaledInstance(40,40,Image.SCALE_SMOOTH )));
        exit5.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DictionaryApplication.class.getResource("Custom-Icon-Design-Flatastic-8-Go-back.512.png")).getScaledInstance(40,40,Image.SCALE_SMOOTH )));

        addWord.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DictionaryApplication.class.getResource("Kyo-Tux-Delikate-Add.512.png")).getScaledInstance(40,40,Image.SCALE_SMOOTH )));
        lookup.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DictionaryApplication.class.getResource("Ampeross-Qetto-2-Search.256.png")).getScaledInstance(40,40,Image.SCALE_SMOOTH )));
        search.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DictionaryApplication.class.getResource("Jommans-Mushroom-Search.256.png")).getScaledInstance(40,40,Image.SCALE_SMOOTH )));
        removeWord.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DictionaryApplication.class.getResource("Iconfactory-Kidcons-Subtract.32.png")).getScaledInstance(40,40,Image.SCALE_SMOOTH )));
        updateWord.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DictionaryApplication.class.getResource("Github-Octicons-Arrow-switch-24.512.png")).getScaledInstance(40,40,Image.SCALE_SMOOTH )));







        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_screen.setVisible(false);
                search_screen.setVisible(true);
                consoleWindow.add(search_screen,BorderLayout.CENTER);
            }
        });

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchKeyword = searchTarget.getText();
                ArrayList<Word> searchResults = management.search(dictionary, searchKeyword);
                if (searchResults.isEmpty()) {
                    searchExplain.setText("No matching words found.");
                } else {
                    searchExplain.setText("");
                    for (Word word : searchResults) {
                        searchExplain.append(word.getWord_target() + " - " + word.getWord_explain());
                    }
                }
            }
        });

        lookupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_screen.setVisible(false);
                lookup_screen.setVisible(true);
                consoleWindow.add(lookup_screen,BorderLayout.CENTER);
            }
        });

        lookup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String keyword = lookupTarget.getText();
                ArrayList<Word> results = management.lookup(dictionary, keyword);
                if (results.isEmpty()) {
                    lookupExplain.setText("No matching words found.");
                } else {
                    for (Word word : results) {
                        lookupExplain.setText(word.getWord_target() + " - " + word.getWord_explain());
                    }
                }

            }
        });
        addWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_screen.setVisible(false);
                addWordScreen.setVisible(true);
                consoleWindow.add(addWordScreen,BorderLayout.CENTER);
            }
        });
        addWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    dictionary.addWord(addWord2(addWordTarget.getText(),addWordEx.getText()));
                    ket_qua.setText("Thêm từ thành công");
            }
        });
        removeWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_screen.setVisible(false);
                removeWordScreen.setVisible(true);
                consoleWindow.add(removeWordScreen, BorderLayout.CENTER);
            }
        });
        removeWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String target = removeWordTarget.getText();
                management.removeWord(dictionary, target);
                removeWordEx.setText("Xóa từ thành công");

            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_screen.setVisible(false);
                updateWordScreen.setVisible(true);
                consoleWindow.add(updateWordScreen,BorderLayout.CENTER);
            }
        });
        updateWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String target=updateWordTarget.getText();
                ArrayList<Word> results = lookup(dictionary, target);
                if (results.isEmpty()) {
                    u_KQ.setText("Không tìm thấy từ");
                } else {
                    String newExplain = updateWordEx.getText();
                    results.get(0).setWord_explain(newExplain);
                    u_KQ.setText("Thay đổi thành công");
                }
            }
        });

        game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_screen.setVisible(false);
                consoleWindow.add(gameScreen,BorderLayout.CENTER);
            }
        });
        exitlose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consoleWindow.add(gameScreen,BorderLayout.CENTER);
            }
        });

        exit1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search_screen.setVisible(false);
                consoleWindow.add(main_screen,BorderLayout.CENTER);
                main_screen.setVisible(true);
            }
        });
        exit2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lookup_screen.setVisible(false);
                consoleWindow.add(main_screen,BorderLayout.CENTER);
                main_screen.setVisible(true);
            }
        });
        exit3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWordScreen.setVisible(false);
                consoleWindow.add(main_screen,BorderLayout.CENTER);
                main_screen.setVisible(true);
            }
        });
        exit4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               removeWordScreen.setVisible(false);
               consoleWindow.add(main_screen,BorderLayout.CENTER);
               main_screen.setVisible(true);
            }
        });
        exit5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordScreen.setVisible(false);
                consoleWindow.add(main_screen,BorderLayout.CENTER);
                main_screen.setVisible(true);
            }
        });

        consoleWindow.setDefaultCloseOperation(3);
        consoleWindow.setVisible(true);
    }




    public static void main(String[] args) {

        DictionaryApplication dictionaryApplication=new DictionaryApplication();
        dictionaryApplication.ConsoleWindow();

    }
}
