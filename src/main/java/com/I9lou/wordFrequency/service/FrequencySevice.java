package com.I9lou.wordFrequency.service;

import com.I9lou.wordFrequency.core.WordPart;

import java.io.IOException;

/**
 * @author zzq
 * @date 2019-11-23 15:20
 */
public interface FrequencySevice {
    /**
     * 分词 处理词元
     * @param wordPart
     * @throws IOException
     */
    public void processTerm(WordPart wordPart) throws IOException;
}
