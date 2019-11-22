package com.I9lou.es;

import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.Map;

/**
 * 词频计算
 */
public class WordFrequency {
    public static void main(String[] args) throws IOException {
        String str = "从那时起，我就不是坏人了";
        StringReader reader = new StringReader(str);

        Configuration configuration = new Configuration();

        IKSegmenter ik = new IKSegmenter(reader,configuration);
        Lexeme lexeme = null;
        while((lexeme = ik.next())!=null)
            Map<String,<Map>
            System.out.println(lexeme.getLexemeText());
    }
    }

