package com.I9lou.es.core;

import java.util.Objects;

//���������
public class WordCounter implements Comparable<WordCounter>{

    //�������
    private int count;

    //��������
    private int type;

    //����
    private String word;

    //���ﳤ��
    private int length;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    /**
     * ����
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
    public int compareTo(WordCounter o) {
        if(this.count >= o.getCount()){
            return 1;
        }
        return 0;
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
