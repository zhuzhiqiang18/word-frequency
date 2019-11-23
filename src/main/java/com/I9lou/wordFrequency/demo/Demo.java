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
        wordPart.setText("10月21日，杭州保俶塔的保养维护工程正式开工。今天，西湖风景名胜区管委会发布消息，经过多方专家登塔勘察，造成保俶塔塔刹顶部倾斜的原因终于找到了！ 原因找到了！ 去年10月，西湖景区在日常监测中，就发现保俶塔塔刹顶部，有局部倾斜。 图/都市快报 最近在西湖边抬头看保俶塔，它已经被黄色的脚手架包围住，看不清真容。西湖景区正在组织实施保俶塔保养维护工程。 摄影/江志清 详情点击《保俶塔今天起开始全封闭维护！暂别了“国保”！》。 摄影/江志清 工程于10月21日开工，同时开始搭设脚手架。经过二十余天的紧张搭建，11月13日脚手架搭建完毕，来自文物保护、石质保护、古建筑保护、园林养护等方面的专家登塔为保俶塔“望闻问切、对症下药”。\n" +
                "经过现场登顶勘查，根据受损痕迹分析，专家一致推断造成保俶塔塔刹顶部发生局部倾斜的原因，是外力拉扯导致，另从塔刹顶部多处遭风筝线缠绕情况判断，风筝拉扯是导致塔刹顶部发生局部倾斜的主要原因。此外通过近距离观察，刹顶材质较为轻薄，粘结材料老化，塔顶风速又大，风筝拉扯力度之大远超想象，加之日久年深、日晒雨淋等原因，逐步造成塔刹顶部局部歪斜、破损。 下一步，西湖景区将遵循文物保护“最低干预”的原则，联系相关专家对倾斜的刹顶进行修复。同时，也将对塔身表面的植物进行清理，对塔表面勾缝脱落的部分重新进行勾缝处理。\n" +
                "西湖景区对保俶塔封闭施工期间给广大市民、游客造成的游览不便再次表示深深的歉意，请前往宝石山游览的市民、游客尽量避开施工区域，注意自身安全。 保俶塔原名应天塔，又名保叔塔、宝石塔。据史载，北宋赵匡胤于公元975年灭南唐后，吴越国王钱弘俶奉召进京（今河南开封）入朝，久留未返。他的大臣吴延爽为祝其平安，特建九层高塔于此，后崩毁。 元延祐时（公元1314——1320年），至正时（公元1341年——1368年），明正德九年（公元1514年）、嘉靖二十二年（公元1543年）都曾多次重建。现塔身是1933年集资修葺的，高四十五点三米，塔基较小，却负荷了七层高的塔身，再加上浮线叠檐，线条柔和挺秀。宛如少女伫立，与湖光山色构成一副秀丽恬静的画面，现被视为西湖的标志之一");
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

