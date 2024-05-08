import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class DictionaryApplication {
    private int i=0;
    private String[] qe={"Who always drives his customers away?",
           "What is the longest word in the English language?",
    "Why is the letter E so important?","What is higher without a head than with a head?",
    "Where can you always find money?","What has ears but can not hear?","What has a head and a foot but no body?",
    "Who works only one day in a year but never gets fired?","What has arms but can not hug?",
    "What has a face and two hands but no arms, legs or head?"};
    private String[] ae={"A doctor","Litter","alphabet","A pillow","In the dictionary",
            "Sweet potatoes","Cabinet","Queen","Couch","A shirt"};
    private String[] be={"A teacher","Smiles","common","A blanket","In the textbook","Corn","Table","Hunter","Armchair",
    "A pair of pants"};
    private String[] ce={"A taxi-driver","Cry","very popular","A pen","In the manual","Cassava","Bed","King"
    ,"Support table","A box"};
    private String[] de= {"Flight engineer","Mother","beginning of everything",
    "A car","In the secret","Vegetables","Mirror","Santa Claus","Shelf ","A leg"};
    private int[] aa={3,2,4,1,1,2,3,4,2,1};

    private Dictionary dictionary=new Dictionary();
    private DictionaryManagement management=new DictionaryManagement();
    private DictionaryCommandLine dictionaryCommandLine=new DictionaryCommandLine();
    private Random random;
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
        JLabel u_TB1=new JLabel("Nhập từ tiếng anh cần sửa: ");
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
        JPanel questionScreen=new JPanel();
        questionScreen.setLayout(new BorderLayout());
        JPanel answer= new JPanel();
        answer.setLayout(new GridLayout(2,2,20,20));
        JLabel gKQ=new JLabel();

        JButton exit6 = new JButton("Thoát");
        JButton exit7 =new JButton("Thoát");
        JButton exit8=new JButton("Thoát");

        JButton continute= new JButton("Tiếp tục");

        JButton a= new JButton("A");
        JButton b= new JButton("B");
        JButton c= new JButton("C");
        JButton d= new JButton("D");
        a.setBackground(Color.orange);
        b.setBackground(Color.orange);
        c.setBackground(Color.orange);
        d.setBackground(Color.orange);

        JLabel question = new JLabel("");
        question.setFont(fontVua);
        questionScreen.add(question,BorderLayout.CENTER);
        questionScreen.add(exit6,BorderLayout.EAST);
        answer.add(a);
        answer.add(b);
        answer.add(c);
        answer.add(d);

        gameScreen.add(questionScreen,BorderLayout.NORTH);
        gameScreen.add(answer,BorderLayout.CENTER);

        JPanel tbWin =new JPanel();
        tbWin.setLayout(new BorderLayout());
        JLabel tbwin=new JLabel("Chúc mừng,Bạn đã trả lời đúng");
        tbwin.setFont(fontDam);
        tbWin.add(tbwin,BorderLayout.CENTER);
        JButton ctw=new JButton("Chơi tiếp");
        JPanel tbWinD=new JPanel();
        tbWinD.setLayout(new GridLayout(2,1));
        tbWinD.add(ctw,BorderLayout.WEST);
        tbWinD.add(exit7,BorderLayout.EAST);
        tbWin.add(tbWinD,BorderLayout.SOUTH);

       /* JPanel tbLose= new JPanel();
        tbLose.setLayout(new BorderLayout());
        JLabel tblose= new JLabel("Rất tiếc, bạn đã sight");
        tblose.setFont(fontDam);
        JButton tryy=new JButton("Thử lại");
        JLabel tbLoseD= new JLabel();
        tbLoseD.setLayout(new GridLayout(2,1));
        tbLoseD.add(tryy);
        tbLoseD.add(exit8);
        tbLose.add(tblose,BorderLayout.CENTER);
        tbLose.add(tbLoseD,BorderLayout.SOUTH);*/
        JPanel tbLose =new JPanel();
        tbLose.setLayout(new BorderLayout());
        JLabel tbl=new JLabel("Quá ngu");
        tbl.setFont(fontDam);
        tbLose.add(tbl,BorderLayout.CENTER);
        JButton tryy=new JButton("Thử lại");
        JPanel tbLoseD=new JPanel();
        tbLoseD.setLayout(new GridLayout(2,1));
        tbLoseD.add(tryy,BorderLayout.WEST);
        tbLoseD.add(exit8,BorderLayout.EAST);
        tbLose.add(tbLoseD,BorderLayout.SOUTH);



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
                gameScreen.setVisible(true);
                consoleWindow.add(gameScreen,BorderLayout.CENTER);
                if(i>9 ) i=i-10;
                question.setText(qe[i]);
                a.setText(ae[i]);
                b.setText(be[i]);
                c.setText(ce[i]);
                d.setText(de[i]);

                a.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(aa[i]==1)
                        {
                            gameScreen.setVisible(false);
                            tbWin.setVisible(true);
                            consoleWindow.add(tbWin,BorderLayout.CENTER);
                        }
                        else
                        {
                            gameScreen.setVisible(false);
                            tbLose.setVisible(true);
                            consoleWindow.add(tbLose,BorderLayout.CENTER);
                        }

                    }
                });
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(aa[i]==2)
                        {
                            gameScreen.setVisible(false);
                            tbWin.setVisible(true);
                            consoleWindow.add(tbWin,BorderLayout.CENTER);
                        }
                        else
                        {
                            gameScreen.setVisible(false);
                            tbLose.setVisible(true);
                            consoleWindow.add(tbLose,BorderLayout.CENTER);
                        }

                    }
                });
                c.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(aa[i]==3)
                        {
                            gameScreen.setVisible(false);
                            tbWin.setVisible(true);
                            consoleWindow.add(tbWin,BorderLayout.CENTER);
                        }
                        else
                        {
                            gameScreen.setVisible(false);
                            tbLose.setVisible(true);
                            consoleWindow.add(tbLose,BorderLayout.CENTER);
                        }

                    }
                });
                d.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(aa[i]==4)
                        {
                            gameScreen.setVisible(false);
                            tbWin.setVisible(true);
                            consoleWindow.add(tbWin,BorderLayout.CENTER);
                        }
                        else
                        {
                            gameScreen.setVisible(false);
                            tbLose.setVisible(true);
                            consoleWindow.add(tbLose,BorderLayout.CENTER);
                        }

                    }
                });


            }

        });

        ctw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i++;
                tbWin.setVisible(false);
                main_screen.setVisible(false);
                gameScreen.setVisible(true);
                consoleWindow.add(gameScreen,BorderLayout.CENTER);
                if(i>9 ) i=i-10;
                question.setText(qe[i]);
                a.setText(ae[i]);
                b.setText(be[i]);
                c.setText(ce[i]);
                d.setText(de[i]);

                a.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(aa[i]==1)
                        {
                            gameScreen.setVisible(false);
                            tbWin.setVisible(true);
                            consoleWindow.add(tbWin,BorderLayout.CENTER);
                        }
                        else
                        {
                            gameScreen.setVisible(false);
                            tbLose.setVisible(true);
                            consoleWindow.add(tbLose,BorderLayout.CENTER);
                        }

                    }
                });
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(aa[i]==2)
                        {
                            gameScreen.setVisible(false);
                            tbWin.setVisible(true);
                            consoleWindow.add(tbWin,BorderLayout.CENTER);
                        }
                        else
                        {
                            gameScreen.setVisible(false);
                            tbLose.setVisible(true);
                            consoleWindow.add(tbLose,BorderLayout.CENTER);
                        }

                    }
                });
                c.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(aa[i]==3)
                        {
                            gameScreen.setVisible(false);
                            tbWin.setVisible(true);
                            consoleWindow.add(tbWin,BorderLayout.CENTER);
                        }
                        else
                        {
                            gameScreen.setVisible(false);
                            tbLose.setVisible(true);
                            consoleWindow.add(tbLose,BorderLayout.CENTER);
                        }

                    }
                });
                d.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(aa[i]==4)
                        {
                            gameScreen.setVisible(false);
                            tbWin.setVisible(true);
                            consoleWindow.add(tbWin,BorderLayout.CENTER);
                        }
                        else
                        {
                            gameScreen.setVisible(false);
                            tbLose.setVisible(true);
                            consoleWindow.add(tbLose,BorderLayout.CENTER);
                        }

                    }
                });

            }
        });

        tryy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbLose.setVisible(false);
                main_screen.setVisible(false);
                gameScreen.setVisible(true);
                consoleWindow.add(gameScreen,BorderLayout.CENTER);
                if(i>9 ) i=i-10;
                question.setText(qe[i]);
                a.setText(ae[i]);
                b.setText(be[i]);
                c.setText(ce[i]);
                d.setText(de[i]);

                a.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(aa[i]==1)
                        {
                            gameScreen.setVisible(false);
                            tbWin.setVisible(true);
                            consoleWindow.add(tbWin,BorderLayout.CENTER);
                        }
                        else
                        {
                            gameScreen.setVisible(false);
                            tbLose.setVisible(true);
                            consoleWindow.add(tbLose,BorderLayout.CENTER);
                        }

                    }
                });
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(aa[i]==2)
                        {
                            gameScreen.setVisible(false);
                            tbWin.setVisible(true);
                            consoleWindow.add(tbWin,BorderLayout.CENTER);
                        }
                        else
                        {
                            gameScreen.setVisible(false);
                            tbLose.setVisible(true);
                            consoleWindow.add(tbLose,BorderLayout.CENTER);
                        }

                    }
                });
                c.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(aa[i]==3)
                        {
                            gameScreen.setVisible(false);
                            tbWin.setVisible(true);
                            consoleWindow.add(tbWin,BorderLayout.CENTER);
                        }
                        else
                        {
                            gameScreen.setVisible(false);
                            tbLose.setVisible(true);
                            consoleWindow.add(tbLose,BorderLayout.CENTER);
                        }

                    }
                });
                d.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(aa[i]==4)
                        {
                            gameScreen.setVisible(false);
                            tbWin.setVisible(true);
                            consoleWindow.add(tbWin,BorderLayout.CENTER);
                        }
                        else
                        {
                            gameScreen.setVisible(false);
                            tbLose.setVisible(true);
                            consoleWindow.add(tbLose,BorderLayout.CENTER);
                        }

                    }
                });
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
        exit6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameScreen.setVisible(false);
                consoleWindow.add(main_screen,BorderLayout.CENTER);
                main_screen.setVisible(true);
            }
        });
        exit7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbWin.setVisible(false);
                consoleWindow.add(main_screen,BorderLayout.CENTER);
                main_screen.setVisible(true);
            }
        });

        exit8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbLose.setVisible(false);
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
