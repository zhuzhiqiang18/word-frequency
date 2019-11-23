package com.I9lou.wordFrequency.demo;

import com.I9lou.wordFrequency.core.Configuration;
import com.I9lou.wordFrequency.core.TermCounter;
import com.I9lou.wordFrequency.core.WordPart;
import com.I9lou.wordFrequency.core.TermType;
import com.I9lou.wordFrequency.learning.AssemblyTerm;
import com.I9lou.wordFrequency.service.FrequencySevice;
import com.I9lou.wordFrequency.service.impl.IKFrequencySeviceImpl;
import org.wltea.analyzer.cfg.IKConfiguration;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

/**
 * 词频计算
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        FrequencySevice frequencySevice = new IKFrequencySeviceImpl();
        Configuration configuration = new IKConfiguration();
        frequencySevice.init(configuration);
        //加载初始化
        WordPart wordPart = new WordPart(true);
        //wordPart.setText("10月21日，杭州保俶塔的保养维护工程正式开工。今天，西湖风景名胜区管委会发布消息，经过多方专家登塔勘察，造成保俶塔塔刹顶部倾斜的原因终于找到了！");
        wordPart.setText("保俶塔倾斜");
        frequencySevice.processTerm(wordPart);
        System.out.println("段落："+wordPart.getText());
        System.out.println("总分词量："+wordPart.getAllWordCount());
        System.out.println("去重总词量: "+wordPart.getDistinctTermCount());
        System.out.println("===========词频量TOP5========");
        List<TermCounter> termCounterList = wordPart.getSortsTermCounter();
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
            System.out.print(w+" ");
        }

        System.out.println();
        System.out.println("===============================");
        AssemblyTerm assemblyTerm = new AssemblyTerm(termCounterList);
        assemblyTerm.reLoad();
        for (String s : assemblyTerm.getWordList()){
            System.out.print(s+" ");
        }

       }




    }

