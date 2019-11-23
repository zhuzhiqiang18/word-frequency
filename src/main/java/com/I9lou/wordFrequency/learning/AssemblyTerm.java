package com.I9lou.wordFrequency.learning;

import com.I9lou.wordFrequency.core.TermCounter;
import com.I9lou.wordFrequency.core.TermType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 组词
 * @author zzq
 * @date 2019-11-23 11:03
 */
public class AssemblyTerm {
    private List<TermCounter> termCounters ;
    private List<String> wordList;

    public AssemblyTerm(List<TermCounter> termCounters){
        this.termCounters = termCounters;
    }

    public void reLoad(){
        wordList = new ArrayList<>();
        Collections.sort(termCounters, new Comparator<TermCounter>() {
            @Override
            public int compare(TermCounter t1, TermCounter t2) {
                return t1.getFirstBegin()-t2.getFirstBegin();
            }
        });
        String word ="";
        int begin = 0;
        for (int i=0;i<termCounters.size();i++){
            TermCounter termCounter =  termCounters.get(i);

            if(termCounter.getLength()== 1){
              if(termCounter.getType() == TermType.TYPE_CNCHAR.getType() || termCounter.getType() == TermType.TYPE_CNWORD.getType()){
                      if( termCounter.getFirstBegin() - begin ==1){
                          word+=termCounter.getWord();
                          begin = termCounter.getFirstBegin();
                          if(i==termCounters.size()-1 ||
                                  (termCounters.get(i+1).getLength()>1 &&
                                          (termCounters.get(i+1).getType() == TermType.TYPE_CNCHAR.getType() ||
                                                  termCounters.get(i+1).getType() == TermType.TYPE_CNWORD.getType()))  ){
                              add(word);
                          }
                      }else {//新词
                          add(word);
                          word =termCounter.getWord();
                          begin = termCounter.getFirstBegin();
                      }
              }
                //System.out.println(termCounters.get(i).getWord()+"  "+termCounters.get(i).getFirstBegin());
            }
        }
    }

    public void add(String word){
        //System.out.println("=="+word);
        if(word.length()>1){
            wordList.add(word);
        }
    }

    public List<String> getWordList() {
        return wordList;
    }
}
