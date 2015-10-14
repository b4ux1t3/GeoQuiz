package com.bauxite.chris.geoquiz;

public class TrueFalse {
    // Holds the question index.
    private int question;

    // Holds the answer of the question. Stupid name.
    private boolean trueQuestion;

    public TrueFalse(int question, boolean trueQuestion){
        this.question = question;
        this.trueQuestion = trueQuestion;
    }

    public boolean isTrueQuestion() {
        return trueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        this.trueQuestion = trueQuestion;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }
}
