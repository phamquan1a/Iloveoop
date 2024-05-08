import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class DictionaryCommandLine {
    private Dictionary dictionary;
    private DictionaryManagement management;
    private Random random;

    // Constructor
    public DictionaryCommandLine() {
        dictionary = new Dictionary();
        management = new DictionaryManagement();
        random = new Random();
    }

    // Hiển thị menu lựa chọn
    public void showMenu() {
        System.out.println("Welcome to My Application!");
        System.out.println("[0] Exit");
        System.out.println("[1] Add word");
        System.out.println("[2] Remove word");
        System.out.println("[3] Update word");
        System.out.println("[4] Display all words");
        System.out.println("[5] Lookup word");
        System.out.println("[6] Search words");
        System.out.println("[7] Game");
        System.out.println("[8] Import from file");
        System.out.println("[9] Export to file");
        System.out.print("Your action: ");
    }

    // Thực thi hành động tương ứng với lựa chọn của người dùng
    public void performAction(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Exiting program.");
                System.exit(0);
                break;
            case 1:
                dictionary.addWord(management.insertFromCommandline());
                System.out.println("Add word successfull.");
                break;
            case 2:
                System.out.print("Enter word to remove: ");
                String target = management.scanner.nextLine();
                management.removeWord(dictionary, target);
                break;
            case 3:
                System.out.print("Enter word to update: ");
                String wordToUpdate = management.scanner.nextLine();
                management.updateWord(dictionary, wordToUpdate);
                break;
            case 4:
                dictionary.showAllWords();
                break;
            case 5:
                System.out.print("Enter keyword to lookup: ");
                String keyword = management.scanner.nextLine();
                ArrayList<Word> results = management.lookup(dictionary, keyword);
                if (results.isEmpty()) {
                    System.out.println("No matching words found.");
                } else {
                    for (Word word : results) {
                        System.out.println(word.getWord_target() + " - " + word.getWord_explain());
                    }
                }
                break;
            case 6:
                System.out.print("Enter keyword to search: ");
                String searchKeyword = management.scanner.nextLine();
                ArrayList<Word> searchResults = management.search(dictionary, searchKeyword);
                if (searchResults.isEmpty()) {
                    System.out.println("No matching words found.");
                } else {
                    for (Word word : searchResults) {
                        System.out.println(word.getWord_target() + " - " + word.getWord_explain());
                    }
                }
                break;
            case 7:
                playGame(dictionary);
                break;
            case 8:
                management.insertFromFile(dictionary);
                break;
            case 9:
                management.exportToFile(dictionary);
                break;
            default:
                System.out.println("Action not supported.");
        }
    }

    // Chơi game trắc nghiệm từ vựng
    public void playGame(Dictionary dictionary) {
        ArrayList<Word> words = dictionary.getWords();
        if (words.isEmpty()) {
            System.out.println("Dictionary is empty. Add words to play the game.");
            return;
        }

        Word randomWord = words.get(random.nextInt(words.size()));
        String targetWord = randomWord.getWord_target();
        String explainWord = randomWord.getWord_explain();

        ArrayList<Word> options = new ArrayList<>(words);
        options.remove(randomWord);
        Collections.shuffle(options);

        // Tạo một mảng để chứa tất cả các phương án đáp án, bao gồm cả đáp án đúng
        String[] answerOptions = new String[4];
        answerOptions[random.nextInt(4)] = explainWord;
        for (int i = 0, j = 0; i < 4; i++) {
            if (answerOptions[i] == null) {
                answerOptions[i] = options.get(j++).getWord_explain();
            }
        }

        // Xáo trộn thứ tự các phương án đáp án
        ArrayList<String> shuffledOptions = new ArrayList<>();
        for (String option : answerOptions) {
            shuffledOptions.add(option);
        }
        Collections.shuffle(shuffledOptions);

        System.out.println("What is the meaning of the word: " + targetWord);
        for (int i = 0; i < 4; i++) {
            System.out.println((char) ('A' + i) + ". " + shuffledOptions.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Your choice [A/B/C/D]: ");
        String userChoice = scanner.nextLine().toUpperCase();

        // So sánh lựa chọn của người dùng với đáp án đúng
        int correctIndex = shuffledOptions.indexOf(explainWord);
        char correctAnswer = (char) ('A' + correctIndex);
        if (userChoice.equals(String.valueOf(correctAnswer))) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect. The correct answer is: " + correctAnswer + ". " + explainWord);
        }
    }


    // Chạy ứng dụng
    public void runApplication() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự newline sau khi đọc số
            performAction(choice);
        }
    }
}
