package com.I9lou.es.core;

import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;

/**
 * 词频计算
 */
public class WordFrequency {
    public static void main(String[] args) throws IOException {


        Configuration configuration = new Configuration();
        IKSegmenter ik = new IKSegmenter(new StringReader("加载初始化"),configuration);
        Lexeme lexeme = null;

        //WordPart wordPart = new WordPart("10月21日，杭州保俶塔的保养维护工程正式开工。今天，西湖风景名胜区管委会发布消息，经过多方专家登塔勘察，造成保俶塔塔刹顶部倾斜的原因终于找到了！");
        WordPart wordPart = new WordPart("保俶塔保俶塔保俶塔保俶塔");
        ik.reset(wordPart.getTextReader());
        while((lexeme = ik.next())!=null){
            wordPart.addWordCounter(new WordCounter(0,lexeme.getLexemeType(),lexeme.getLexemeText()));
        }
        wordPart.getAllWordCount();
       }




    }

