package com.example.signalsfrommars.model;

public class Choice {

    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    private  String mText;

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int mNextPage) {
        this.mNextPage = mNextPage;
    }

    private int mNextPage;

    public Choice(String text, int nextPage){
        mText=text;
        mNextPage=nextPage;
    }
}
