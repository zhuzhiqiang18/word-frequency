package com.I9lou.wordFrequency.demo;

import com.I9lou.wordFrequency.core.TermCounter;
import com.I9lou.wordFrequency.core.WordPart;
import com.I9lou.wordFrequency.core.TermType;
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
        //wordPart.setText("10月21日，杭州保俶塔的保养维护工程正式开工。今天，西湖风景名胜区管委会发布消息，经过多方专家登塔勘察，造成保俶塔塔刹顶部倾斜的原因终于找到了！");
        wordPart.setText("今天真的是香菇蓝瘦，唉");
        ik.reset(wordPart.getTextReader());
        while((lexeme = ik.next())!=null){
            wordPart.addWordCounter(new TermCounter(lexeme.getLexemeType(),lexeme.getLexemeText(),lexeme.getOffset(),lexeme.getBegin(),lexeme.getLength()));
        }
        System.out.println("段落："+wordPart.getText());
        System.out.println("总分词量："+wordPart.getAllWordCount());
        System.out.println("去重总词量: "+wordPart.getDistinctWordCount());
        System.out.println("===========词频量TOP5========");
        List<TermCounter> termCounterList = wordPart.getSortsWordCounter();
        for (int i = 0; i<(termCounterList.size()>=5?5: termCounterList.size()); i++){
            System.out.println("词语："+ termCounterList.get(i).getWord()+" , " +
                    "词频："+ termCounterList.get(i).getCount()+" , " +
                    "词频率："+(termCounterList.get(i).getCount()*0.1/wordPart.getAllWordCount()*100)+"% , " +
                    "出现位置："+ termCounterList.get(i).getFirstBegin()+" , " +
                    "词元类型： "+ TermType.getWordType(termCounterList.get(i).getType()).name()
            );
        }
        System.out.println("===========分词========");

        for (String w : wordPart.getWords().keySet()){
            System.out.println(w);
        }

       }




    }

