package com.I9lou.wordFrequency.core;

import java.io.StringReader;
import java.util.*;

//被分析的文字段落
public class WordPart {
    private String text;
    private StringReader textReader;
    //分词链
    private Map<String, TermCounter> words ;
    //所有分词个数
    private long allWordCount;
    //分词是否保持有序 默认无序
    private boolean wordsOrder;


    public WordPart(String text){
        this.text = text;
        this.textReader = new StringReader(text);
        init();
    }

    public WordPart(String text,boolean wordsOrder){
        this(text);
        this.wordsOrder = wordsOrder;
        init();
    }

    /**
     * 是否开启顺序分词
     * @param wordsOrder
     */
    public WordPart(boolean wordsOrder){
        this.wordsOrder = wordsOrder;
        init();
    }

    /**
     * 分词链是否保持有序
     */
    private void init(){
        if(wordsOrder){
            words = new LinkedHashMap<>(16 , 0.95f);
        }else{
            words = new HashMap<>(16 , 0.95f);
        }
    }

    /**
     * 添加分词计数器
     * @param termCounter
     */
    public void addTermCounter(TermCounter termCounter){
        allWordCount+=1;
        TermCounter wc = words.get(termCounter.getWord());
        if(wc==null){
            words.put(termCounter.getWord(), termCounter.increaseCount());
        }else{
            wc.increaseCount();
        }
    }

    public long getAllWordCount() {
        return allWordCount;
    }

    /**
     * 排序
     * @return
     */
    public List<TermCounter> getSortsTermCounter() {
        List<TermCounter> termCounterList = new ArrayList<>(words.values());
        Collections.sort(termCounterList, new Comparator<TermCounter>() {
            @Override
            public int compare(TermCounter w1, TermCounter w2) {
                if(w1.getCount()>=w2.getCount()){
                    return -1;
                }else {
                    return 1;
                }
            }
        });
        return termCounterList;
    }

    //去重分词个数
    public long getDistinctTermCount() {
        return words.size();
    }

    public String getText() {
        return text;
    }

    public StringReader getTextReader() {
        if(text==null||text.length()==0){
            throw new  RuntimeException("请设置文字段落,method:setText()");
        }
        return textReader;
    }

    public Map<String, TermCounter> getWords() {
        return words;
    }

    public void setText(String text) {
        this.text = text;
        this.textReader = new StringReader(text);
    }

}
