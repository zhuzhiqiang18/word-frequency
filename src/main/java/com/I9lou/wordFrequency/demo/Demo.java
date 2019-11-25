package com.I9lou.wordFrequency.demo;

import com.I9lou.wordFrequency.core.Configuration;
import com.I9lou.wordFrequency.core.TermCounter;
import com.I9lou.wordFrequency.core.TermType;
import com.I9lou.wordFrequency.core.WordPart;
import com.I9lou.wordFrequency.learning.AssemblyTerm;
import com.I9lou.wordFrequency.service.FrequencySevice;
import com.I9lou.wordFrequency.service.impl.IKFrequencySeviceImpl;
import org.wltea.analyzer.cfg.IKConfiguration;

import java.io.IOException;
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
        wordPart.setText("鲁韵子/文 郑福德/图片 张大伟/视频 由霍建华、任达华、韩志硕、张赫等主演的动作悬疑电影《真相禁区》日前亮相釜山电影节红毯仪式，今天又在在釜山展览会议中心举办发布会。霍建华与韩志硕两位中韩长腿欧巴一起现身，两人均穿浅灰色上衣，造型清爽帅气。　　对于自己的大银幕“处女作”，霍建华表示一人分饰两角非常过瘾，与韩国明星张赫也合作得十分投契。当粉丝们请求他现场秀两句韩语时，霍建华害羞地请韩志硕现教了一句韩语“辛苦了”，一出口便引发观众尖叫。　　《真相禁区》由麦咏麟执导，围绕着“巴纳姆效应”的概念，讲述由“婚外情”引发了一个复杂诡谲的犯罪故事。霍建华在其中一人分饰两角，既是因蒙冤入狱而展开狠辣报复的高智商黑客，也是热血争议的警探。在现场，有媒体提问霍建华会否因为分饰两角出现精神“分裂”的状况，霍建华则微笑否认，表示这段大银幕之旅十分过瘾。同时，他也解释了电影中重要的概念“巴纳姆效应”，原来后者是指人们总是会找到理由相信自己愿意相信之事，以至于将其信以为真。　　而说到今天缺席发布会的韩国欧巴张赫，霍建华也笑称两人十分投缘。张赫曾说过自己十分爱喝中国酒，霍建华便偷偷买来送给他作为惊喜。结果两人一起喝酒，张赫还是被霍喝到了。说罢这段典故，霍建华自己倒被逗得不亦乐乎。有粉丝请他秀两句向韩国同行学的韩语，他先是害羞拒绝，后又耐不住粉丝请求向韩志硕现学了“辛苦了”的说法，当即被粉丝大赞“口音很标准”。　　《真相禁区》将于11月在中国内将保持关注。(鲁韵子/文 郑福德/图片 张大伟/视频)（来源：新浪娱乐）");
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

