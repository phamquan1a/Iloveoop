import java.util.ArrayList;

class Dictionary {
    private ArrayList<Word> words; // Danh sách các từ vựng


    public Dictionary() {
        this.words = new ArrayList<>();
    }
    public void addWord(Word word) {
        words.add(word);
    }

    // Hiển thị danh sách từ điển
    public void showAllWords() {
        System.out.println("No | English     | Vietnamese");
        int index = 1;
        for (Word word : words) {
            System.out.printf("%-3d| %-12s| %s%n", index, word.getWord_target(), word.getWord_explain());
            index++;
        }
    }

    // Tìm kiếm từ trong từ điển
    public ArrayList<Word> search(String keyword) {
        ArrayList<Word> results = new ArrayList<>();
        for (Word word : words) {
            if (word.getWord_target().startsWith(keyword)) {
                results.add(word);
            }
        }
        return results;
    }

    // Xóa từ khỏi từ điển
    public void removeWord(String target) {
        for (Word word : words) {
            if (word.getWord_target().equals(target)) {
                words.remove(word);
                return;
            }
        }
    }

    // Trả về danh sách các từ vựng
    public ArrayList<Word> getWords() {
        return words;
    }
}