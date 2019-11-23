package com.I9lou.wordFrequency.learning;

import com.I9lou.wordFrequency.core.TermCounter;
import com.I9lou.wordFrequency.core.TermType;

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

    private int flag;
    public AssemblyTerm(List<TermCounter> termCounters){
        this.termCounters = termCounters;
    }

    public void reLoad(){
        Collections.sort(termCounters, new Comparator<TermCounter>() {
            @Override
            public int compare(TermCounter t1, TermCounter t2) {
                return t1.getFirstBegin()-t2.getFirstBegin();
            }
        });

        for (int i=0;i<termCounters.size();i++){
            if(termCounters.get(i).getType()== TermType.TYPE_CNCHAR.getType()){
                //todo 决策是不是一个词语
                System.out.println(termCounters.get(i).getWord()+"  "+termCounters.get(i).getFirstBegin());
            }

        }



    }
}
