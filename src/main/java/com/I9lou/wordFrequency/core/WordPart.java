package com.I9lou.wordFrequency.core;

import java.io.StringReader;
import java.util.*;

//被分析的文字段落
public class WordPart {
    private static final String COUNT="count";
    private static final String WORD="word";
    private String text;
    private StringReader textReader;
    //分词链
    private Map<String,WordCounter> words ;

    //所有分词个数
    private long allWordCount;

    //分词是否保持有序 默认无须
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

    private void init(){
        if(wordsOrder){
            words = new LinkedHashMap<>(16 , 0.95f);
        }else{
            words = new HashMap<>(16 , 0.95f);
        }
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

    /**
     * 排序
     * @return
     */
    public List<WordCounter> getSortsWordCounter() {
        List<WordCounter>  wordCounterList = new ArrayList<>(words.values());
        Collections.sort(wordCounterList, new Comparator<WordCounter>() {
            @Override
            public int compare(WordCounter w1, WordCounter w2) {
                if(w1.getCount()>=w2.getCount()){
                    return -1;
                }else {
                    return 1;
                }
            }
        });
        return wordCounterList;
    }

    //去重分词个数
    public long getDistinctWordCount() {
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

    public Map<String, WordCounter> getWords() {
        return words;
    }

    public void setText(String text) {
        this.text = text;
        this.textReader = new StringReader(text);
    }
}
