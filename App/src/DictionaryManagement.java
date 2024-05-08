import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DictionaryManagement {
    public Scanner scanner; // Đối tượng Scanner để nhập liệu từ bàn phím

    // Constructor
    public DictionaryManagement() {
        scanner = new Scanner(System.in);
    }

    // Phương thức nhập liệu từ bàn phím
    public Word insertFromCommandline() {
        System.out.print("Enter English word: ");
        String target = scanner.nextLine();
        System.out.print("Enter Vietnamese meaning: ");
        String explain = scanner.nextLine();
        return new Word(target, explain);
    }

    // Đọc dữ liệu từ tệp và thêm vào từ điển
    public void insertFromFile(Dictionary dictionary) {
        try {
            File file = new File("dictionaries.txt");
            Scanner fileScanner = new Scanner(file);
            String wordTarget = "";
            String wordExplain = "";
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.startsWith("@")) {
                    // Lưu từ mới nếu có
                    if (!wordTarget.isEmpty()) {
                        dictionary.addWord(new Word(wordTarget, wordExplain));
                        wordTarget = "";
                        wordExplain = "";
                    }
                    // Tách từ và phần loại từ
                    String[] parts = line.split("/");
                    wordTarget = parts[0].substring(1).trim();
                    if (parts.length > 1) {
                        wordExplain ='/'+ parts[1].trim()+'/'+"\n";
                    }
                } else if (line.startsWith("*") ) {
                    // Đọc giải nghĩa và ví dụ
                    wordExplain += '*'+line.substring(1).trim() + "\n";
                } else if ( line.startsWith("-")) {
                    // Đọc giải nghĩa và ví dụ
                    wordExplain +='-'+ line.substring(1).trim() + "\n";
                }

            }
            // Lưu từ cuối cùng trong tệp
            if (!wordTarget.isEmpty()) {
                dictionary.addWord(new Word(wordTarget, wordExplain));
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    // Lưu dữ liệu từ điển vào tệp
    public void exportToFile(Dictionary dictionary) {
        try {
            FileWriter writer = new FileWriter("dictionaries.txt");
            for (Word word : dictionary.getWords()) {
                writer.write(word.getWord_target() + "\t" + word.getWord_explain() + "\n");
            }
            writer.close();
            System.out.println("Dictionary has been exported to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Tìm kiếm từ trong từ điển
    public ArrayList<Word> lookup(Dictionary dictionary, String keyword) {
        ArrayList<Word> results = new ArrayList<>();
        for (Word word : dictionary.getWords()) {
            if (word.getWord_target().equalsIgnoreCase(keyword)) {
                results.add(word);
            }
        }
        return results;
    }

    // Xóa từ khỏi từ điển
    public void removeWord(Dictionary dictionary, String target) {
        dictionary.removeWord(target);
        System.out.println("Word removed successfully.");
    }

    // Sửa từ trong từ điển
    public void updateWord(Dictionary dictionary, String target) {
        ArrayList<Word> results = lookup(dictionary, target);
        if (results.isEmpty()) {
            System.out.println("Word not found.");
        } else {
            System.out.println("Enter new Vietnamese meaning: ");
            String newExplain = scanner.nextLine();
            results.get(0).setWord_explain(newExplain);
            System.out.println("Word updated successfully.");
        }
    }

    // Tìm kiếm từ trong từ điển
    public ArrayList<Word> search(Dictionary dictionary, String keyword) {
        ArrayList<Word> results = new ArrayList<>();
        for (Word word : dictionary.getWords()) {
            if (word.getWord_target().startsWith(keyword)) {
                results.add(word);
            }
        }
        return results;
    }
}