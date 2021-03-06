# word-frequency
计算词频

## 基于IK分词器的词频计算 内置IK词典
```java
FrequencySevice frequencySevice = new IKFrequencySeviceImpl();
        Configuration configuration = new IKConfiguration();
        frequencySevice.init(configuration);
        //加载初始化
        WordPart wordPart = new WordPart(true);
        wordPart.setText("10月21日，杭州保俶塔的保养维护工程正式开工。今天，西湖风景名胜区管委会发布消息，经过多方专家登塔勘察，造成保俶塔塔刹顶部倾斜的原因终于找到了！");
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
       }
```
## 结果
```text
段落：10月21日，杭州保俶塔的保养维护工程正式开工。今天，西湖风景名胜区管委会发布消息，经过多方专家登塔勘察，造成保俶塔塔刹顶部倾斜的原因终于找到了！
总分词量：34
去重总词量: 31
===========词频量TOP5========
词语：塔 , 词频：2 , 词频率：0.5882352941176471% , 出现位置：11 , 词元类型： TYPE_CNWORD
词语：俶 , 词频：2 , 词频率：0.5882352941176471% , 出现位置：10 , 词元类型： TYPE_CNCHAR
词语：保 , 词频：2 , 词频率：0.5882352941176471% , 出现位置：9 , 词元类型： TYPE_CNCHAR
词语：找到了 , 词频：1 , 词频率：0.29411764705882354% , 出现位置：69 , 词元类型： TYPE_CNWORD
词语：终于 , 词频：1 , 词频率：0.29411764705882354% , 出现位置：67 , 词元类型： TYPE_CNWORD
===========分词========
10月 21日 杭州 保 俶 塔 保养 维护 工程 正式 开工 今天 西湖 风景 名胜区 管委会 发布 消息 经过 多方 专家 登 勘察 造成 塔塔 刹 顶部 倾斜 原因 终于 找到了 

```
