class Word {
    private String word_target; // từ vựng tiếng Anh
    private String word_explain; // giải nghĩa tiếng Việt

    // Constructor
    public Word(String target, String explain) {
        this.word_target = target;
        this.word_explain = explain;
    }

    // Getter và Setter
    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }
}