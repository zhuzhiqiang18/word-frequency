package com.I9lou.wordFrequency.demo;

import com.I9lou.wordFrequency.core.TermCounter;
import com.I9lou.wordFrequency.core.TermType;
import com.I9lou.wordFrequency.core.WordPart;
import com.I9lou.wordFrequency.service.FrequencySevice;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * 词频计算
 */
public class SpringDemo {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context/ctx-*.xml");
        FrequencySevice frequencySevice= context.getBean(FrequencySevice.class);

        WordPart wordPart = new WordPart(true);
        //wordPart.setText("10月21日，杭州保俶塔的保养维护工程正式开工。今天，西湖风景名胜区管委会发布消息，经过多方专家登塔勘察，造成保俶塔塔刹顶部倾斜的原因终于找到了！");
        wordPart.setText("今天（11月15日）下午，2019杭州市“公述民评”面对面问政第四场的现场，杭州市教育局副局长蒋锋表示：“明年杭州初中肯定实行‘公民同招’，超过招生计划的，100%电脑派位，不会给民办初中自主招生留一个名额。”（来源：都市快报）蒋锋说，100%派位后，后续的公开透明也是要继续努力的，比如设计方案时，就会考虑分班时怎样保证平行分班？“这都是我们后续要做的工作。”这个月月底，教育部将召开大会，邀请了各大省市教育部门相关负责人，浙江也在其中，专门研究今年招生细则，预计在12月份前公布招生细则，明年会落实到位。以后杭州家长买学区房、不只要看小学，还要看对口直升的公办初中是否靠谱。此前，省教育厅曾发布33条重点举措征求意见。详戳→公民同招、严控校内考试次数、一个班一个群！33条重点举措，省教育厅征求意见。 浙江公民同招时间轴：2019年1月10日在中共杭州市委十二届六次全体（扩大）会议上，提升公共服务方面，全会明确提出实施公办民办小学同步招生。2019年1月24日在年初召开的2019全省教育系统工作会议上，浙江省教育厅发布了《2018年浙江教育改革发展情况和2019年工作思路》。会上特别引起大家关注的，在深化招生考试制度改革方面，省教育厅提出的“2019年，严格落实义务教育就近入学制度，规范小学入学、“小升初”招生办法，公办小学按学区进行划片招生，有条件的地方探索双学区招生；逐步取消各类特长生招生；民办小学、初中原则上在审批区域内招生，具体招生方式包括自主报名、随机摇号、面谈或体能测试等。”2019年4月3日杭州市教育局发布了《杭州市教育局关于做好公办民办小学同步招生工作的通知》，5月5日开始网报，6月22、23日面谈，杭州小学公民同招方案落地。2019年10月下旬浙江省14部门联合起草了《浙江省中小学生减负工作实施方案（征求意见稿）》，第19条提出，对公办民办学校同步招生。2019年11月15日2019杭州市“公述民评”面对面问政第四场的现场，杭州市教育局副局长蒋锋表示，明年杭州初中实行‘公民同招’，超过招生计划的，100%电脑派位。");
        frequencySevice.processTerm(wordPart);
        System.out.println("段落："+wordPart.getText());
        System.out.println("总分词量："+wordPart.getAllWordCount());
        System.out.println("去重总词量: "+wordPart.getDistinctTermCount());
        System.out.println("===========词频量TOP5========");
        List<TermCounter> termCounterList = wordPart.getSortsTermCounter();
        for (int i = 0; i<(termCounterList.size()>=10?10: termCounterList.size()); i++){
            System.out.println("词语："+ termCounterList.get(i).getWord()+" , " +
                    "词频："+ termCounterList.get(i).getCount()+" , " +
                    "词频率："+(termCounterList.get(i).getCount()*1.0/wordPart.getAllWordCount()*100)+"% , " +
                    "出现位置："+ termCounterList.get(i).getFirstBegin()+" , " +
                    "词元类型： "+ TermType.getWordType(termCounterList.get(i).getType()).name()
            );
        }
        System.out.println("===========分词========");

        for (String w : wordPart.getWords().keySet()){
            System.out.print(w+" ");
        }

        System.out.println();
        //Integer.parseInt()

       }

    }

