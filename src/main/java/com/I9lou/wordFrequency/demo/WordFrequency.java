package com.I9lou.wordFrequency.demo;

import com.I9lou.wordFrequency.core.TermCounter;
import com.I9lou.wordFrequency.core.WordPart;
import com.I9lou.wordFrequency.core.TermType;
import com.I9lou.wordFrequency.learning.AssemblyTerm;
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
        wordPart.setText("<p class=\"section\">最近，萧山一姑娘在萧内网发帖引发网友热议。她说，她家离城区较远，开车上班要一个小时。但如果选择<strong>租房</strong>，<strong>房租</strong>几乎要占到工资的一半。怎么选？很纠结……评论区不少网友表示和她一样「心累」。钱多、离家近的工作不好找，城区选择机会多，但在<strong>租房</strong>和每天开车上下班之间，同样难以抉择。<strong>租房</strong>太贵：给房东打工开车太累：通勤时间长最近，微博上 #<strong>租房</strong>幸福感报告# 引发热议。数据显示，<strong>房租</strong>占工资20%最幸福，少搬一次家，幸福感会提升30%。独立卫生间比<strong>房租</strong>更重要。过去一年，一居室<strong>租房</strong>增长近4倍，「一人一居，猫狗双全」堪称现代青年的终极幸福……〖欢迎转发、留言和点赞〗来源：萧内网萧山论坛</p>");
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
            System.out.print(w+" ");
        }

        /*System.out.println( );
        AssemblyTerm assemblyTerm = new AssemblyTerm(termCounterList);
        assemblyTerm.reLoad();*/

       }




    }

