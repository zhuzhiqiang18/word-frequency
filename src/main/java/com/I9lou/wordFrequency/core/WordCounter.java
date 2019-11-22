package com.I9lou.wordFrequency.core;

import java.util.Objects;

//词语计数器
public class WordCounter{

    //词语个数
    private int count;

    //词语类型
    private int type;

    //词语
    private String word;

    //词语长度
    private int length;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    /**
     * 自增
     * @return
     */
    public WordCounter increaseCount(){
        this.count=count+1;
        return this;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public int getLength() {
        return length;
    }

    public WordCounter(int count, int type, String word) {
        this.count = count;
        this.type = type;
        this.word = word;
        this.length = word.length();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCounter that = (WordCounter) o;
        return Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}
