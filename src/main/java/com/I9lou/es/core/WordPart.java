package com.I9lou.es.core;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

//被分析的文字段落
public class WordPart {
    private String text;
    private StringReader textReader;
    private Map<String,WordCounter> words = new HashMap<>();
    //所有分词个数
    private long allWordCount=0;



    public WordPart(String text){
        this.text = text;
        this.textReader = new StringReader(text);
    }


    public void addWordCounter(WordCounter wordCounter){
        allWordCount+=1;
        WordCounter wc = words.get(wordCounter.getWord());
        if(wc==null){
            words.put(wordCounter.getWord(),wordCounter.increaseCount());
        }else{
            wc.increaseCount();
        }
    }

    public long getAllWordCount() {
        return allWordCount;
    }

    //去重分词个数
    public long getDistinctWordCount() {
        return words.size();
    }

    public String getText() {
        return text;
    }

    public StringReader getTextReader() {
        return textReader;
    }

    public Map<String, WordCounter> getWords() {
        return words;
    }
}
