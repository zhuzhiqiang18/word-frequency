package com.I9lou.wordFrequency.service.impl;

import com.I9lou.wordFrequency.core.TermCounter;
import com.I9lou.wordFrequency.core.WordPart;
import com.I9lou.wordFrequency.service.FrequencySevice;
import org.wltea.analyzer.cfg.IKConfiguration;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;

/**
 * 基于Ik分词的词频
 * @author zzq
 * @date 2019-11-23 15:22
 */
public class IKFrequencySeviceImpl implements FrequencySevice {
    private  IKSegmenter ik;
    private IKConfiguration ikConfiguration;

    public IKFrequencySeviceImpl(IKConfiguration ikConfiguration){
        this.ikConfiguration = ikConfiguration;
        ikConfiguration.setUseSmart(true);
        ik = new IKSegmenter(new StringReader(""), ikConfiguration);
    }


    @Override
    public void processTerm(WordPart wordPart) throws IOException {
        ik.reset(wordPart.getTextReader());
        Lexeme lexeme = null;
        while((lexeme = ik.next())!=null){
            wordPart.addTermCounter(new TermCounter(lexeme.getLexemeType(),lexeme.getLexemeText(),lexeme.getOffset(),lexeme.getBegin(),lexeme.getLength()));
        }
    }


}
