# word-frequency
计算词频

## 基于IK分词器的词频计算 内置IK词典
```java
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
        List<WordCounter> termCounterList = wordPart.getSortsWordCounter();
        for (int i=0;i<(termCounterList.size()>=5?5:termCounterList.size());i++){
            System.out.println("词语："+termCounterList.get(i).getWord()+" , 词频："+termCounterList.get(i).getCount()+" , 词频率："+(termCounterList.get(i).getCount()*0.1/wordPart.getAllWordCount()*100)+"%");
        }
        System.out.println("===========分词========");
        
        for (String w : wordPart.getWords().keySet()){
            System.out.println(w);
        }
        
       }
```
## 结果
```text
段落：10月21日，杭州保俶塔的保养维护工程正式开工。今天，西湖风景名胜区管委会发布消息，经过多方专家登塔勘察，造成保俶塔塔刹顶部倾斜的原因终于找到了！
总分词量：36
去重总词量31
===========词频量TOP5========
词语：塔 , 词频：4 , 词频率：1.1111111111111112%
词语：俶 , 词频：2 , 词频率：0.5555555555555556%
词语：保 , 词频：2 , 词频率：0.5555555555555556%
词语：到了 , 词频：1 , 词频率：0.2777777777777778%
词语：找 , 词频：1 , 词频率：0.2777777777777778%
```
