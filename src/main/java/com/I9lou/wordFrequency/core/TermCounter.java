package com.I9lou.wordFrequency.core;

import java.util.Objects;

//词语计数器
public class TermCounter {

    //词语个数
    private int count;

    //词语类型
    private int type;

    //词语
    private String word;

    //词语长度
    private int length;

    //偏移量
    private int firstOffset;

    //第一次出现开始位置
    private int firstBegin;


    public TermCounter(int type, String word, int offset, int begin, int length) {
        this.type = type;
        this.word = word;
        this.length = length;
        this.firstBegin = begin;
        this.firstOffset = offset;

    }

    /**
     * 自增
     * @return
     */
    public TermCounter increaseCount(){
        this.count=count+1;
        return this;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TermCounter that = (TermCounter) o;
        return Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public void setLength(int length) {
        this.length = length;
    }

    public int getFirstOffset() {
        return firstOffset;
    }

    public void setFirstOffset(int firstOffset) {
        this.firstOffset = firstOffset;
    }

    public int getFirstBegin() {
        return firstBegin;
    }

    public void setFirstBegin(int firstBegin) {
        this.firstBegin = firstBegin;
    }
}
