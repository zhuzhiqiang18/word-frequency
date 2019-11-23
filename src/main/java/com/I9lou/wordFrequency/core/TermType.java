package com.I9lou.wordFrequency.core;

/**
 * 词元类型
 * @author zzq
 * @date 2019-11-23 10:29
 */
public enum TermType {

    //未知
    TYPE_UNKNOWN(0),
    //英文
    TYPE_ENGLISH(1),
    //数字
    TYPE_ARABIC(2),
    //英文数字混合
    TYPE_LETTER(3),
    //中文词元
    TYPE_CNWORD(4),
    //中文单字
    TYPE_CNCHAR(64),
    //日韩文字
    TYPE_OTHER_CJK(8),
    //中文数词
    TYPE_CNUM(16),
    //中文量词
    TYPE_COUNT(32),
    //中文数量词
    TYPE_CQUAN(48);

    private int type;
    TermType(int type){
        this.type = type;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static TermType getWordType(int type){
        TermType wt = TermType.TYPE_UNKNOWN;
        switch (type){
            case 1:
                wt = TermType.TYPE_ENGLISH;
                break;
            case 2:
                wt = TermType.TYPE_ARABIC;
                break;
            case 3:
                wt = TermType.TYPE_LETTER;
                break;
            case 4:
                wt = TermType.TYPE_CNWORD;
                break;
            case 64:
                wt = TermType.TYPE_CNCHAR;
                break;
            case 8:
                wt = TermType.TYPE_OTHER_CJK;
                break;
            case 16:
                wt = TermType.TYPE_CNUM;
                break;
            case 32:
                wt = TermType.TYPE_COUNT;
                break;
            case 48:
                wt = TermType.TYPE_CQUAN;
                break;

        }
        return wt;
    }

}
