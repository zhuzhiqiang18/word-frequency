package com.I9lou.wordFrequency.demo;

import com.I9lou.wordFrequency.core.WordCounter;
import com.I9lou.wordFrequency.core.WordPart;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

/**
 * 词频计算
 */
public class WordFrequency {
    public static void main(String[] args) throws IOException {

        Configuration configuration = new Configuration();
        configuration.setUseSmart(true);
        //加载初始化
        IKSegmenter ik = new IKSegmenter(new StringReader(""),configuration);
        Lexeme lexeme = null;

        WordPart wordPart = new WordPart(true);
        wordPart.setText("10月21日，杭州保俶塔的保养维护工程正式开工。今天，西湖风景名胜区管委会发布消息，经过多方专家登塔勘察，造成保俶塔塔刹顶部倾斜的原因终于找到了！");
        //WordPart wordPart = new WordPart("保俶塔的保俶塔保俶塔保俶塔");
        ik.reset(wordPart.getTextReader());
        while((lexeme = ik.next())!=null){
            wordPart.addWordCounter(new WordCounter(0,lexeme.getLexemeType(),lexeme.getLexemeText()));
        }
        System.out.println("段落："+wordPart.getText());
        System.out.println("总分词量："+wordPart.getAllWordCount());
        System.out.println("去重总词量: "+wordPart.getDistinctWordCount());
        System.out.println("===========词频量TOP5========");
        List<WordCounter> wordCounterList = wordPart.getSortsWordCounter();
        for (int i=0;i<(wordCounterList.size()>=5?5:wordCounterList.size());i++){
            System.out.println("词语："+wordCounterList.get(i).getWord()+" , 词频："+wordCounterList.get(i).getCount()+" , 词频率："+(wordCounterList.get(i).getCount()*0.1/wordPart.getAllWordCount()*100)+"%");
        }
        System.out.println("===========分词========");

        for (String w : wordPart.getWords().keySet()){
            System.out.println(w);
        }

       }




    }

